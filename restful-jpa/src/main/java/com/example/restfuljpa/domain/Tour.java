package com.example.restfuljpa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * The Tour contains all attributes of an Explore California Tour.
 */
@Entity
public class Tour implements Serializable {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String title;

    @Column(length = 2000)
    private String description;

    @Column(length = 2000)
    private String blurb;

    @Column
    private Integer price;

    @Column
    private String duration;

    @Column(length = 2000)
    private String bullets;

    @Column
    private String keywords;

    @ManyToOne
    private TourPackage tourPackage;

    @Column
    private Difficulty difficulty;

    @Column
    private Region region;

    protected Tour() {
    }

    public Tour(final String title, final String description, final String blurb, final Integer price, final String duration, final String bullets, final String keywords,
            final TourPackage tourPackage, final Difficulty difficulty, final Region region) {
        this.title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.tourPackage = tourPackage;
        this.difficulty = difficulty;
        this.region = region;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        final Tour tour = (Tour) o;
        return Objects.equals(this.id, tour.id) && Objects.equals(this.title, tour.title) && Objects.equals(this.description, tour.description)
                && Objects.equals(this.blurb, tour.blurb) && Objects.equals(this.price, tour.price) && Objects.equals(this.duration, tour.duration)
                && Objects.equals(this.bullets, tour.bullets) && Objects.equals(this.keywords, tour.keywords) && Objects.equals(this.tourPackage, tour.tourPackage)
                && (this.difficulty == tour.difficulty) && (this.region == tour.region);
    }

    public String getBlurb() {
        return this.blurb;
    }

    public String getBullets() {
        return this.bullets;
    }

    public String getDescription() {
        return this.description;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }

    public String getDuration() {
        return this.duration;
    }

    public Integer getId() {
        return this.id;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public Integer getPrice() {
        return this.price;
    }

    public Region getRegion() {
        return this.region;
    }

    public String getTitle() {
        return this.title;
    }

    public TourPackage getTourPackage() {
        return this.tourPackage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.title, this.description, this.blurb, this.price, this.duration, this.bullets, this.keywords, this.tourPackage, this.difficulty,
                this.region);
    }

    public void setBlurb(final String blurb) {
        this.blurb = blurb;
    }

    public void setBullets(final String bullets) {
        this.bullets = bullets;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public void setDifficulty(final Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setDuration(final String duration) {
        this.duration = duration;
    }

    public void setKeywords(final String keywords) {
        this.keywords = keywords;
    }

    public void setPrice(final Integer price) {
        this.price = price;
    }

    public void setRegion(final Region region) {
        this.region = region;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public void setTourPackage(final TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }

    @Override
    public String toString() {
        return "Tour{" + "id=" + this.id + ", title='" + this.title + '\'' + ", description='" + this.description + '\'' + ", blurb='" + this.blurb + '\'' + ", price=" + this.price
                + ", duration='" + this.duration + '\'' + ", bullets='" + this.bullets + '\'' + ", keywords='" + this.keywords + '\'' + ", tourPackage=" + this.tourPackage
                + ", difficulty=" + this.difficulty + ", region=" + this.region + '}';
    }
}
