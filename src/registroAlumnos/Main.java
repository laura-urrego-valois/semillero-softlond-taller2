package registroAlumnos;

public class Main {

    public static void main(String[] args) {

        SistemaAlumnos<Double> sistemaAlumnos = new SistemaAlumnos<>();

        sistemaAlumnos.agregarAlumno("Alberto", 12);
        sistemaAlumnos.agregarAlumno("Daniela", 13);
        sistemaAlumnos.agregarAlumno("Carlos", 14);
        sistemaAlumnos.agregarAlumno("Fernanda", 12);

        sistemaAlumnos.asignarCalificacion("Alberto", 9.5);
        sistemaAlumnos.asignarCalificacion("Alberto", 8.0);
        sistemaAlumnos.asignarCalificacion("Alberto", 10.0);

        sistemaAlumnos.asignarCalificacion("Daniela", 8.5);
        sistemaAlumnos.asignarCalificacion("Daniela", 7.2);
        sistemaAlumnos.asignarCalificacion("Daniela", 9.0);

        sistemaAlumnos.asignarCalificacion("Carlos", 7.0);
        sistemaAlumnos.asignarCalificacion("Carlos", 8.0);
        sistemaAlumnos.asignarCalificacion("Carlos", 9.5);

        sistemaAlumnos.asignarCalificacion("Fernanda", 7.8);
        sistemaAlumnos.asignarCalificacion("Fernanda", 8.0);
        sistemaAlumnos.asignarCalificacion("Fernanda", 10.0);

        System.out.println("LISTA DE ALUMNOS");
        sistemaAlumnos.mostrarInformacionAlumno();
    }
}
