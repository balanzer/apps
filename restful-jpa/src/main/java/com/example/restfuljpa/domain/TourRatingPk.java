package com.example.restfuljpa.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

/**
 * Tour Rating Primary Key containing a Tour and a Customer Identifier
 * 
 * Created by Mary Ellen Bowman
 */
@Embeddable
public class TourRatingPk implements Serializable {

    @ManyToOne
    private Tour tour;

    @Column(insertable = false, updatable = false, nullable = false)
    private Integer customerId;

    public TourRatingPk() {
    }

    /**
     * Fully initialize a Tour Rating Pk
     *
     * @param tour
     *            the tour.
     * @param customerId
     *            the customer identifier.
     */
    public TourRatingPk(final Tour tour, final Integer customerId) {
        this.tour = tour;
        this.customerId = customerId;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }

        final TourRatingPk that = (TourRatingPk) o;

        if (!this.tour.equals(that.tour)) {
            return false;
        }
        return this.customerId.equals(that.customerId);

    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public Tour getTour() {
        return this.tour;
    }

    @Override
    public int hashCode() {
        int result = this.tour.hashCode();
        result = (31 * result) + this.customerId.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "TourRatingPk{" + "tour=" + this.tour + ", customerId=" + this.customerId + '}';
    }
}
