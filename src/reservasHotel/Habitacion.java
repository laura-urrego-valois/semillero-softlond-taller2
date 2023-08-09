package reservasHotel;

public class Habitacion {

    private int numeroHabitacion;

    private boolean disponible;

    private String nombreHotel;

    public Habitacion(int numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
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
}
