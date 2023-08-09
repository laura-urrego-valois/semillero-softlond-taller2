package registroAlumnos;

import java.util.ArrayList;
import java.util.List;

public class Alumno<T extends Number> {

    private String nombre;
    private int edad;
    private List<T> calificaciones;

    public Alumno(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
        this.calificaciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public List<T> getCalificaciones() {
        return calificaciones;
    }

    public void asignarCalificacion(T calificacion) {
        calificaciones.add(calificacion);
    }

    public double calculoPromedio() {
        double promedio = 0;
        for (T calificacion : calificaciones) {
            promedio += calificacion.doubleValue();
        }
        return promedio / calificaciones.size();
    }

    @Override
    public String toString() {
        return "Alumno{ " +
                "\nNombre= " + nombre +
                "\nEdad= " + edad +
                "\nCalificaciones= " + calificaciones +
                "\nPromedio= " + calculoPromedio() +
                ' ' + '}';
    }
}
