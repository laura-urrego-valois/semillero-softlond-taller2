package reservasHotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Hotel {

    private String nombreHotel;

    private List<Habitacion> habitaciones;

    public Hotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
        this.habitaciones = new ArrayList<>();
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public void setNombreHotel(String nombreHotel) {
        this.nombreHotel = nombreHotel;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

}
