package com.example.restfuljpa.web;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RatingDto {

    @Min(0)
    @Max(5)
    private Integer score;

    @Size(max = 255)
    private String comment;

    @NotNull
    private Integer customerId;

    protected RatingDto() {
    }

    /**
     * Constructor to fully initialize the RatingDto
     *
     * @param score
     * @param comment
     * @param customerId
     */
    public RatingDto(final Integer score, final String comment, final Integer customerId) {
        this.score = score;
        this.comment = comment;
        this.customerId = customerId;
    }

    public String getComment() {
        return this.comment;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public Integer getScore() {
        return this.score;
    }

    public void setComment(final String comment) {
        this.comment = comment;
    }

    public void setCustomerId(final Integer customerId) {
        this.customerId = customerId;
    }

    public void setScore(final Integer score) {
        this.score = score;
    }

}
