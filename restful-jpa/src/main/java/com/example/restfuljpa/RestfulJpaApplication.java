package com.example.restfuljpa;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.restfuljpa.domain.Difficulty;
import com.example.restfuljpa.domain.Region;
import com.example.restfuljpa.services.TourPackageService;
import com.example.restfuljpa.services.TourService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootApplication
public class RestfulJpaApplication implements CommandLineRunner {

    /**
     * Helper class to import the records in the ExploreCalifornia.json
     */
    static class TourFromFile {

        /**
         * Open the ExploreCalifornia.json, unmarshal every entry into a TourFromFile Object.
         *
         * @return a List of TourFromFile objects.
         * @throws IOException
         *             if ObjectMapper unable to open file.
         */
        static List<TourFromFile> importTours() throws IOException {
            return new ObjectMapper().setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY)
                    .readValue(TourFromFile.class.getResourceAsStream("/ExploreCalifornia.json"), new TypeReference<List<TourFromFile>>() {
                    });
        }

        // attributes as listed in the .json file
        private String packageType, title, description, blurb, price, length, bullets, keywords, difficulty, region;
    }

    public static void main(final String[] args) {
        SpringApplication.run(RestfulJpaApplication.class, args);
    }

    @Autowired
    private TourPackageService tourPackageService;

    @Autowired
    private TourService tourService;

    @Override
    public void run(final String... arg0) throws Exception {
        // Create the default tour packages
        this.tourPackageService.createTourPackage("BC", "Backpack Cal");
        this.tourPackageService.createTourPackage("CC", "California Calm");
        this.tourPackageService.createTourPackage("CH", "California Hot springs");
        this.tourPackageService.createTourPackage("CY", "Cycle California");
        this.tourPackageService.createTourPackage("DS", "From Desert to Sea");
        this.tourPackageService.createTourPackage("KC", "Kids California");
        this.tourPackageService.createTourPackage("NW", "Nature Watch");
        this.tourPackageService.createTourPackage("SC", "Snowboard Cali");
        this.tourPackageService.createTourPackage("TC", "Taste of California");

        TourFromFile.importTours().forEach(t -> this.tourService.createTour(t.title, t.description, t.blurb, Integer.parseInt(t.price), t.length, t.bullets, t.keywords,
                t.packageType, Difficulty.valueOf(t.difficulty), Region.findByLabel(t.region)));

        // this.tourPackageService.listAll().forEach(tourPackage -> System.out.println(tourPackage));
        System.out.println("Total Tour packages : " + this.tourPackageService.total());
        System.out.println("Total Tours : " + this.tourService.total());
    }
}
