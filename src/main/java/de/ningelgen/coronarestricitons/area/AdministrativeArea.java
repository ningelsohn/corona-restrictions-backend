package de.ningelgen.coronarestricitons.area;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonIgnore;

import de.ningelgen.coronarestricitons.district.District;
import de.ningelgen.coronarestricitons.user.AreaAdminUser;

@Entity
public class AdministrativeArea {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    @Version
    @JsonIgnore
    private int version;

    @OneToOne
    private AreaAdminUser admin;

    @OneToMany(mappedBy = "area")
    @JsonIgnore
    private List<District> districts = new LinkedList<>();

    // GETTERS AND SETTERS

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public AreaAdminUser getAdmin() {
        return admin;
    }

    public void setAdmin(AreaAdminUser admin) {
        this.admin = admin;
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
    }

    // HASH AND EQUALS

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
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
        AdministrativeArea other = (AdministrativeArea) obj;
        if (id != other.id)
            return false;
        if (version != other.version)
            return false;
        return true;
    }
    
}
