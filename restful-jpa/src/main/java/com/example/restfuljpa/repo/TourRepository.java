package com.example.restfuljpa.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.restfuljpa.domain.Tour;

public interface TourRepository extends CrudRepository<Tour, Integer> {

}
