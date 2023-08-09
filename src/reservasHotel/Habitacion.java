package reservasHotel;

public class Habitacion {

    private int numeroHabitacion;

    private boolean disponible;

    private String nombreHotel;

    private Hotel hotel;

    public Habitacion(int numeroHabitacion, Hotel hotel) {
        this.numeroHabitacion = numeroHabitacion;
        this.hotel = hotel;
        this.nombreHotel = hotel.getNombreHotel();
        this.disponible = true;
    }

    public int getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getNombreHotel() {
        return nombreHotel;
    }

    public Hotel getHotel() {
        return hotel;
    }
}
