package com.example.restfuljpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restfuljpa.domain.TourPackage;
import com.example.restfuljpa.repo.TourPackageRepository;

@Service
public class TourPackageService {

    private final TourPackageRepository tourPackageRepository;

    @Autowired
    public TourPackageService(final TourPackageRepository tourPackageRepository) {
        this.tourPackageRepository = tourPackageRepository;
    }

    public TourPackage createTourPackage(final String code, final String name) {
        if (!this.tourPackageRepository.exists(code)) {
            return this.tourPackageRepository.save(new TourPackage(code, name));
        }
        return null;
    }

    public Iterable<TourPackage> listAll() {
        return this.tourPackageRepository.findAll();
    }

    public long total() {
        return this.tourPackageRepository.count();
    }
}
