import model.Car;
import model.City;
import model.Driver;
import model.Rental;
import persistance.RentingJDBC;

import java.sql.SQLException;

/**
 * Created by Alan on 02/02/2017.
 */
public class main {

    public static void main(String[] args) {

        try {

            RentingJDBC bbdd = new RentingJDBC();

            Driver d = new Driver("26061070t","alan","699389065",350.50);
            Car c = new Car("12414","mustang",6,d);
            City city = new City("08120","barcelona");
            Rental r = new Rental(42,"alan",c,city);

            System.out.println("Estableciendo conexion...");
            bbdd.conectar();
            System.out.println("conexion establecida");

            System.out.println("insertando alquiler en BBDD...");
            bbdd.insertarAlquiler(r);
            System.out.println("Alquiler insertado");

            System.out.println("modificando sueldo de un chofer...");
            bbdd.modificarSueldoChofer("12412414x",357);
            System.out.println("Sueldo modificado");

            System.out.println("Solicitando lista de coches de un conductor");
            for(Car car : bbdd.cochesChofer("141124f")){
                System.out.println(car);
            }
            System.out.println("coches devueltos");

            System.out.println("Solicitando alquileres de una ciudad...");
            for(Rental rent : bbdd.alquileresCiudad("08120")){
                System.out.println(rent);
            }
            System.out.println("Alquileres devueltos");


            System.out.println("desconectando de la BBDD...");
            bbdd.desconectar();
            System.out.println("desconectado");
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        }
    }
}
