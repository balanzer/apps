package com.example.restfuljpa.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * A Classification of Tours.
 */
@Entity
public class TourPackage implements Serializable {

    @Id
    private String code;

    @Column
    private String name;

    protected TourPackage() {
    }

    public TourPackage(final String code, final String name) {
        this.code = code;
        this.name = name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if ((o == null) || (this.getClass() != o.getClass())) {
            return false;
        }
        final TourPackage that = (TourPackage) o;
        return Objects.equals(this.code, that.code) && Objects.equals(this.name, that.name);
    }

    public String getCode() {
        return this.code;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.code, this.name);
    }

    @Override
    public String toString() {
        return "TourPackage{" + "code='" + this.code + '\'' + ", name='" + this.name + '\'' + '}';
    }
}
