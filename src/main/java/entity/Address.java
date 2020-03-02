package entity;

import java.util.Objects;

public class Address {
    private long id;
    private String country;
    private String city;
    private String street;
    private String postcode;

    public Address() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return getId() == address.getId() &&
                getCountry().equals(address.getCountry()) &&
                getCity().equals(address.getCity()) &&
                getStreet().equals(address.getStreet()) &&
                getPostcode().equals(address.getPostcode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getCountry(), getCity(), getStreet(), getPostcode());
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
