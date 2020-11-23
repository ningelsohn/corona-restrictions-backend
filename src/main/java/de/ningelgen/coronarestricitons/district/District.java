package de.ningelgen.coronarestricitons.district;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.ningelgen.coronarestricitons.area.AdministrativeArea;

@Entity
public class District {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    @Version
    @JsonIgnore
    private int version;

    @NotNull
    @Column(unique = true)
    private int postcode;

    @NotNull
    private String name;
    
    @ManyToOne
    private AdministrativeArea area;

    // GETTER AND SETTER

    public int getPostCode() {
        return postcode;
    }

    public void setPostCode(int postCode) {
        this.postcode = postCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdministrativeArea getArea() {
        return area;
    }

    public void setArea(AdministrativeArea area) {
        this.area = area;
    }

    // HASH AND EQUALS

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((area == null) ? 0 : area.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + postcode;
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
        District other = (District) obj;
        if (area == null) {
            if (other.area != null)
                return false;
        } else if (!area.equals(other.area))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (postcode != other.postcode)
            return false;
        return true;
    }
}
