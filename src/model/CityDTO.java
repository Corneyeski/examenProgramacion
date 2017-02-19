package model;

import java.util.List;

/**
 * Created by Alan on 02/02/2017.
 */
public class CityDTO {

    private String name;
    private int rents;

    public CityDTO() {
    }

    public CityDTO(String name, int rents) {
        this.name = name;
        this.rents = rents;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRents() {
        return rents;
    }

    public void setRents(int rents) {
        this.rents = rents;
    }

    @Override
    public String toString() {
        return "CityDTO{" +
                "name='" + name + '\'' +
                ", rents=" + rents +
                '}';
    }
}
