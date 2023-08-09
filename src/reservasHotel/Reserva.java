package reservasHotel;

import java.util.Date;

public class Reserva {

    private Cliente cliente;
    private Hotel hotel;
    private Habitacion habitacion;
    private boolean disponibilidad;

    private Date fechaCheckIn;
    private Date fechaCheckOut;

    public Reserva(Cliente cliente, Hotel hotel, Habitacion habitacion, boolean disponibilidad, Date fechaCheckIn, Date fechaCheckOut) {
        this.cliente = cliente;
        this.hotel = hotel;
        this.habitacion = habitacion;
        this.disponibilidad = disponibilidad;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
    }
}