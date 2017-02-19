package model;

/**
 * Created by Alan on 02/02/2017.
 */
public class Rental {

    private int idRental;
    private String customer;
    private Car car;
    private City city;

    public Rental() {
    }

    public Rental(int idRental, String customer, Car car, City city) {
        this.idRental = idRental;
        this.customer = customer;
        this.car = car;
        this.city = city;
    }

    public int getIdRental() {
        return idRental;
    }

    public void setIdRental(int idRental) {
        this.idRental = idRental;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Rental{" +
                "idRental=" + idRental +
                ", customer='" + customer + '\'' +
                ", car=" + car +
                ", city=" + city +
                '}';
    }
}
