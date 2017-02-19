package model;

/**
 * Created by Alan on 02/02/2017.
 */
public class City {

    private String postalCode;
    private String name;

    public City() {
    }

    public City(String postalCode, String name) {
        this.postalCode = postalCode;
        this.name = name;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "postalCode='" + postalCode + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
