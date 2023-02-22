package Phonebook;

public class Address {
    Integer houseapptNumb;
    String streetName;
    String city;
    String state;
    Integer zipCode;

    public Address () {}

    public Address(Integer houseapptNumb, String streetName, String city, String state, Integer zipCode) {
        this.houseapptNumb = houseapptNumb;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public Integer getHouseapptNumb() {
        return houseapptNumb;
    }

    public void setHouseapptNumb(Integer houseapptNumb) {
        this.houseapptNumb = houseapptNumb;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getZipCode() {
        return zipCode;
    }

    public void setZipCode(Integer zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Address [houseapptNumb=" + houseapptNumb + ", streetName=" + streetName + ", city=" + city + ", state="
                + state + ", zipCode=" + zipCode + "]";
    }

    
}
