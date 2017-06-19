package com.example.restfuljpa.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.restfuljpa.domain.Difficulty;
import com.example.restfuljpa.domain.Region;
import com.example.restfuljpa.domain.Tour;
import com.example.restfuljpa.domain.TourPackage;
import com.example.restfuljpa.repo.TourPackageRepository;
import com.example.restfuljpa.repo.TourRepository;

public class TourService {

    private final TourRepository tourRepository;
    private final TourPackageRepository tourPackageRepository;

    @Autowired
    public TourService(final TourRepository tourRepository, final TourPackageRepository tourPackageRepository) {
        this.tourRepository = tourRepository;
        this.tourPackageRepository = tourPackageRepository;
    }

    public Tour createTour(final String title, final String description, final String blurb, final Integer price, final String duration, final String bullets,
            final String keywords, final String tourPakcageCode, final Difficulty difficulty, final Region region) {
        final TourPackage tourPackage = this.tourPackageRepository.findOne(tourPakcageCode);

        if (null == tourPackage) {
            throw new RuntimeException("Tour package does not exists code:" + tourPakcageCode);
        }
        return this.tourRepository.save(new Tour(title, description, blurb, price, duration, bullets, keywords, tourPackage, difficulty, region));
    }

    public Iterable<Tour> listAll() {
        return this.tourRepository.findAll();
    }

    public long total() {
        return this.tourRepository.count();
    }
}
