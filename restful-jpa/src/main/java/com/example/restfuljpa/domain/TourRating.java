package com.example.restfuljpa.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

/**
 * Rating of a Tour by a Customer
 *
 * Created by Mary Ellen Bowman
 */
@Entity
public class TourRating {

    @EmbeddedId
    private TourRatingPk pk;

    @Column(nullable = false)
    private Integer score;

    @Column
    private String comment;

    protected TourRating() {
    }

    /**
     * Create a fully initialized TourRating.
     *
     * @param pk
     *            primiary key of a tour and customer id.
     * @param score
     *            Integer score (1-5)
     * @param comment
     *            Optional comment from the customer
     */
    public TourRating(final TourRatingPk pk, final Integer score, final String comment) {
        this.pk = pk;
        this.score = score;
        this.comment = comment;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        final TourRating that = (TourRating) o;
        return Objects.equals(this.pk, that.pk) && Objects.equals(this.score, that.score) && Objects.equals(this.comment, that.comment);
    }

    public String getComment() {
        return this.comment;
    }

    public TourRatingPk getPk() {
        return this.pk;
    }

    public Integer getScore() {
        return this.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.pk, this.score, this.comment);
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public void setPk(final TourRatingPk pk) {
        this.pk = pk;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "TourRating{" + "pk=" + this.pk + ", score=" + this.score + ", comment='" + this.comment + '\'' + '}';
    }
}
