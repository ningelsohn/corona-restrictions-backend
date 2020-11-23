package de.ningelgen.coronarestricitons.user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.hibernate.annotations.NaturalId;

import de.ningelgen.coronarestricitons.area.AdministrativeArea;

@Entity
@Table(name = "users", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"username"}),
    @UniqueConstraint(columnNames = {"email"})
})
public class User {

    @Id
    @GeneratedValue
    @JsonIgnore
    private long id;

    @Version
    @JsonIgnore
    private int version;

    @Size(max = 15)
    @NotNull
    @NotBlank
    @NaturalId
    private String username;

    @Size(max = 40)
    @Email
    @NotNull
    @NotBlank
    @NaturalId
    private String email;

    @Size(max = 100)
    @NotNull
    @NotBlank
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    // TODO: might define enum for roles and permissions
    private String roles;

    private String permissions;

    @OneToOne
    private AdministrativeArea area;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String loginname) {
        this.username = loginname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles(){
        if (this.roles.length() > 0) {
            return Arrays.asList(this.roles.split(","));
        } else {
            return new ArrayList<>();
        }
    }

    public List<String> getPermissions(){
        if (this.permissions.length() > 0) {
            return Arrays.asList(this.permissions.split(","));
        } else {
            return new ArrayList<>();
        }
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
        User other = (User) obj;
        if (id != other.id)
            return false;
        if (version != other.version)
            return false;
        return true;
    }
}

