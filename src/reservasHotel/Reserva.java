package reservasHotel;

import java.util.Date;

public class Reserva {

    private Cliente cliente;
    private String huesped;
    private String cedula;
    private Hotel hotel;
    private Habitacion habitacion;
    private boolean cancelada;
    private Date fechaCheckIn;
    private Date fechaCheckOut;

    public Reserva(Cliente cliente, String huesped, String cedula, Hotel hotel, Habitacion habitacion, boolean cancelada, Date fechaCheckIn, Date fechaCheckOut) {
        this.cliente = cliente;
        this.huesped = huesped;
        this.cedula = cedula;
        this.hotel = hotel;
        this.habitacion = habitacion;
        this.cancelada = cancelada;
        this.fechaCheckIn = fechaCheckIn;
        this.fechaCheckOut = fechaCheckOut;
    }

    public Reserva(Cliente cliente, Hotel hotel, Habitacion habitacion, boolean b, Date fechaCheckIn, Date fechaCheckOut) {
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getHuesped() {
        return huesped;
    }

    public void setHuesped(String huesped) {
        this.huesped = huesped;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public boolean isCancelada() {
        return cancelada;
    }

    public void setCancelada(boolean cancelada) {
        this.cancelada = cancelada;
    }

    public Date getFechaCheckIn() {
        return fechaCheckIn;
    }

    public void setFechaCheckIn(Date fechaCheckIn) {
        this.fechaCheckIn = fechaCheckIn;
    }

    public Date getFechaCheckOut() {
        return fechaCheckOut;
    }

    public void setFechaCheckOut(Date fechaCheckOut) {
        this.fechaCheckOut = fechaCheckOut;
    }
}