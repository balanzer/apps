package com.example.restfuljpa.web;

import java.util.AbstractMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfuljpa.domain.Tour;
import com.example.restfuljpa.domain.TourRating;
import com.example.restfuljpa.domain.TourRatingPk;
import com.example.restfuljpa.repo.TourRatingRepository;
import com.example.restfuljpa.repo.TourRepository;

@RestController
@RequestMapping(path = "/tours/{tourId}/ratings")
public class TourRatingController {

    TourRatingRepository tourRatingRepository;
    TourRepository tourRepository;

    @Autowired
    public TourRatingController(final TourRatingRepository tourRatingRepository, final TourRepository tourRepository) {
        super();
        this.tourRatingRepository = tourRatingRepository;
        this.tourRepository = tourRepository;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void createTourRating(@PathVariable(value = "tourId") final int tourId, @RequestBody @Validated final RatingDto ratingDto) {
        final Tour tour = this.verifyTour(tourId);
        this.tourRatingRepository.save(new TourRating(new TourRatingPk(tour, ratingDto.getCustomerId()), ratingDto.getScore(), ratingDto.getComment()));
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{customerId}")
    public void deleteRatinng(@PathVariable(value = "tourId") final int tourId, @PathVariable(value = "customerId") final int customerId) {
        final TourRating tourRating = this.verifyTourRating(tourId, customerId);
        this.tourRatingRepository.delete(tourRating);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<RatingDto> getAllRatingsforTour(@PathVariable(value = "tourId") final int tourId) {
        final Tour tour = this.verifyTour(tourId);
        return this.tourRatingRepository.findByPkTourId(tourId).stream().map(tourRating -> this.toDto(tourRating)).collect(Collectors.toList());
    }

    @RequestMapping(method = RequestMethod.GET, path = "/average")
    public AbstractMap.SimpleEntry<String, Double> getAverage(@PathVariable(value = "tourId") final int tourId) {
        final List<TourRating> tourRatings = this.tourRatingRepository.findByPkTourId(tourId);
        final OptionalDouble avarage = tourRatings.stream().mapToInt(TourRating::getScore).average();
        return new AbstractMap.SimpleEntry<>("average", avarage.isPresent() ? avarage.getAsDouble() : null);
    }

    /**
     * Exception handler if NoSuchElementException is thrown in this Controller
     *
     * @param ex
     * @return Error message String.
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NoSuchElementException.class)
    public String return400(final NoSuchElementException ex) {
        return ex.getMessage();

    }

    private RatingDto toDto(final TourRating tourRating) {
        return new RatingDto(tourRating.getScore(), tourRating.getComment(), tourRating.getPk().getCustomerId());
    }

    @RequestMapping(method = RequestMethod.PATCH)
    public RatingDto updateWithPatch(@PathVariable(value = "tourId") final int tourId, @RequestBody @Validated final RatingDto ratingDto) {
        final TourRating tourRating = this.verifyTourRating(tourId, ratingDto.getCustomerId());
        if (ratingDto.getScore() != null) {
            tourRating.setScore(ratingDto.getScore());
        }
        if (ratingDto.getComment() != null) {
            tourRating.setComment(ratingDto.getComment());
        }

        return this.toDto(this.tourRatingRepository.save(tourRating));
    }

    @RequestMapping(method = RequestMethod.PUT)
    public RatingDto updateWithPut(@PathVariable(value = "tourId") final int tourId, @RequestBody @Validated final RatingDto ratingDto) {
        final TourRating tourRating = this.verifyTourRating(tourId, ratingDto.getCustomerId());

        tourRating.setScore(ratingDto.getScore());
        tourRating.setComment(ratingDto.getComment());

        return this.toDto(this.tourRatingRepository.save(tourRating));
    }

    /**
     * Verify and return the Tour given a tourId.
     *
     * @param tourId
     * @return the found Tour
     * @throws NoSuchElementException
     *             if no Tour found.
     */
    private Tour verifyTour(final int tourId) throws NoSuchElementException {
        final Tour tour = this.tourRepository.findOne(tourId);
        if (tour == null) {
            throw new NoSuchElementException("Tour does not exist " + tourId);
        }
        return tour;
    }

    /**
     * Verify and return the TourRating for a particular tourId and Customer
     *
     * @param tourId
     * @param customerId
     * @return the found TourRating
     * @throws NoSuchElementException
     *             if no TourRating found
     */
    private TourRating verifyTourRating(final int tourId, final int customerId) throws NoSuchElementException {
        final TourRating rating = this.tourRatingRepository.findByPkTourIdAndPkCustomerId(tourId, customerId);
        if (rating == null) {
            throw new NoSuchElementException("Tour-Rating pair for request(" + tourId + " for customer" + customerId);
        }
        return rating;
    }
}
