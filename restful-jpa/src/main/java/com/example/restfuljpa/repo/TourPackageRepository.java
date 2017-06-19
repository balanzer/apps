package com.example.restfuljpa.repo;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.restfuljpa.domain.TourPackage;

@RepositoryRestResource(exported = false)
public interface TourPackageRepository extends PagingAndSortingRepository<TourPackage, String> {

    TourPackage findByName(@Param("name") String name);
}
