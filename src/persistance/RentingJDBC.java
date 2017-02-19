package persistance;

import model.*;
import model.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Alan on 02/02/2017.
 */
public class RentingJDBC {


    private Connection conexion;

    public RentingJDBC() {}


    public void insertarAlquiler(Rental r) throws SQLException {

        String insert = "insert into rental values (?,?,?,?);";
        PreparedStatement ps = conexion.prepareStatement(insert);

        ps.setInt(1, r.getIdRental());
        ps.setString(2,r.getCustomer());
        ps.setString(3,r.getCar().getIdCar());
        ps.setString(4,r.getCity().getPostalCode());

        ps.executeUpdate();

        ps.close();
    }

    public void modificarSueldoChofer(String dni,int sueldo) throws SQLException{

        String update = "update driver SET salary = ? where dni = ?";
        PreparedStatement ps = conexion.prepareStatement(update);

        ps.setInt(1,sueldo);
        ps.setString(2,dni);

        ps.executeUpdate();

        ps.close();
    }

    public List<Car> cochesChofer(String dni) throws SQLException{

        List<Car> cars = new ArrayList<>();

        String obtener = "select * from car where driver ='" + dni+"'";
        Statement consulta = conexion.createStatement();

        ResultSet ps = consulta.executeQuery(obtener);

        while(ps.next()){

            cars.add(cogerCoche(ps));
        }
        return cars;
    }

    public List<Rental> alquileresCiudad(String postal) throws SQLException{

        List<Rental> rentals = new ArrayList<>();

        String obtener = "select * from rental where city ='" + postal+"'";
        Statement consulta = conexion.createStatement();

        ResultSet ps = consulta.executeQuery(obtener);

        while (ps.next()){

            Rental rent = new Rental();
            rent.setIdRental(ps.getInt("idRental"));
            rent.setCustomer(ps.getString("customer"));

            String obtenerC = "select * from car where idcar ='" + ps.getString("car")+"'";
            Statement consultaC = conexion.createStatement();

            ResultSet psC = consultaC.executeQuery(obtenerC);

            if(psC.next()){
               rent.setCar(cogerCoche(psC));
            }

            String obtenerCity = "select * from city where postalCode ='" + ps.getString("city")+"'";
            Statement consultaCity = conexion.createStatement();

            ResultSet psCity = consultaCity.executeQuery(obtenerCity);

            if(ps.next()){
                City c = new City();
                c.setPostalCode(psCity.getString("postalCode"));
                c.setName(psCity.getString("name"));
                rent.setCity(c);
            }
            rentals.add(rent);
        }
        return rentals;
    }

    public List<CityDTO> ranking() throws SQLException{

        List<CityDTO> ranking = new ArrayList<>();

        String obtener = "select * from rent GROUP BY city";
        Statement consulta = conexion.createStatement();

        ResultSet ps = consulta.executeQuery(obtener);

        ranking.sort(Comparator.comparing(CityDTO::getRents));


        return ranking;
    }

    public Car cogerCoche(ResultSet ps) throws SQLException{

        Car c = new Car();
        Driver d = new Driver();
        c.setIdCar(ps.getString("idcar"));
        c.setModel(ps.getString("model"));
        c.setCapacity(ps.getInt("capacity"));

        String obtenerC = "select * from driver where dni ='" + ps.getString("driver")+"'";
        Statement consultaC = conexion.createStatement();
        ResultSet psC = consultaC.executeQuery(obtenerC);

        if(ps.next()){
            d.setDni(psC.getString("dni"));
            d.setName(psC.getString("name"));
            d.setPhone(psC.getString("phone"));
            d.setSalary(psC.getDouble("salary"));
        }
        c.setDriver(d);
        return c;
    }

    public void conectar() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/renting";
        String usr = "root";
        String pass = "";
        conexion = DriverManager.getConnection(url, usr, pass);
    }

    public void desconectar() throws SQLException {
        if (conexion != null) {
            conexion.close();
        }
    }
}
