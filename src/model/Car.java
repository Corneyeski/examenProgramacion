package model;

/**
 * Created by Alan on 02/02/2017.
 */
public class Car {

    private String idCar;
    private String model;
    private int capacity;
    private Driver driver;

    public Car() {
    }

    public Car(String idCar, String model, int capacity, Driver driver) {
        this.idCar = idCar;
        this.model = model;
        this.capacity = capacity;
        this.driver = driver;
    }

    public String getIdCar() {
        return idCar;
    }

    public void setIdCar(String idCar) {
        this.idCar = idCar;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar='" + idCar + '\'' +
                ", model='" + model + '\'' +
                ", capacity=" + capacity +
                ", driver=" + driver +
                '}';
    }
}
