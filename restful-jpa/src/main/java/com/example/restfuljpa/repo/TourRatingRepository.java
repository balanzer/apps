package com.example.restfuljpa.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.restfuljpa.domain.TourRating;
import com.example.restfuljpa.domain.TourRatingPk;

@RepositoryRestResource(exported = false)
public interface TourRatingRepository extends CrudRepository<TourRating, TourRatingPk> {

    List<TourRating> findByPkTourId(Integer tourId);

    TourRating findByPkTourIdAndPkCustomerId(Integer tourId, Integer customerId);
}
