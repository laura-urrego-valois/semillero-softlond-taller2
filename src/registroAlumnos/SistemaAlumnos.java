package registroAlumnos;

import java.util.HashMap;
import java.util.Map;

public class SistemaAlumnos<T extends Number> {

    private Map<String, Alumno<T>> alumnos;

    public SistemaAlumnos() {
        this.alumnos = new HashMap<>();
    }

    public void agregarAlumno(String nombre, int edad) {
        Alumno<T> alumno = new Alumno<>(nombre, edad);
        alumnos.put(nombre, alumno);
    }

    public void asignarCalificacion(String nombre, T calificacion) {
        Alumno<T> alumno = alumnos.get(nombre);
        if (alumno != null) {
            alumno.asignarCalificacion(calificacion);
        } else {
            System.out.println("No se asignó un alumno a la calificación " + calificacion);
        }
    }

    public void mostrarInformacionAlumno() {
        for (Alumno<T> alumno : alumnos.values()) {
            System.out.println(alumno);
        }
    }
}
