package de.ningelgen.coronarestricitons.restriction;

import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Restriction {

    @Id
    @GeneratedValue
    @JsonIgnore
    private int id;

    @Version
    @JsonIgnore
    private int version;

    @NotNull
    @Size(min = 3, max = 20)
    private String title;

    @NotNull
    @Size(min = 5, max = 1000)
    private String description;

    @NotNull
    private int areaId;

    @NotNull
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate appliesSince;

    // GETTERS AND SETTERS

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRegionId() {
        return areaId;
    }

    public void setRegionId(int areaId) {
        this.areaId = areaId;
    }

    public LocalDate getAppliesSince() {
        return appliesSince;
    }

    public void setAppliesSince(LocalDate appliesSince) {
        this.appliesSince = appliesSince;
    }
    
    // HASH AND EQUALS

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + version;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Restriction other = (Restriction) obj;
        if (id != other.id)
            return false;
        if (version != other.version)
            return false;
        return true;
    }
}
