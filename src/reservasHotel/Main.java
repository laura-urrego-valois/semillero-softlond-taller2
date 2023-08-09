package reservasHotel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Hotel> hoteles = new ArrayList<>();
        hoteles.add(new Hotel("Hotel Casa Grande"));
        hoteles.add(new Hotel("Hotel Villa Celeste"));
        hoteles.add(new Hotel("Hotel Jardines del Sol"));
        hoteles.add(new Hotel("Hotel Miramar"));

        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new Habitacion(101));
        habitaciones.add(new Habitacion(201));
        habitaciones.add(new Habitacion(301));
        habitaciones.add(new Habitacion(401));
        habitaciones.add(new Habitacion(501));

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Microsoft"));
        clientes.add(new Cliente("Unilever"));
        clientes.add(new Cliente("Procter & Gamble"));
        clientes.add(new Cliente("Amazon"));
        clientes.add(new Cliente("Apple"));

        while (true) {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("Por favor selecciona el número de la opción deseada");
            System.out.println("1. Listar habitaciones disponibles");
            System.out.println("2. Hacer reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listarHabitacionesDisponibles(hoteles, habitaciones, scanner);
                    break;
                case 2:
                    hacerReserva(hoteles, habitaciones, clientes, scanner);
                    break;
                case 3:
                    cancelarReserva(hoteles, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("¡Selección inválida!");
            }
        }
    }

    private static void listarHabitacionesDisponibles(List<Hotel> hoteles, List<Habitacion> habitaciones, Scanner scanner) {
        System.out.println("Selecciona un hotel:");
        for (int i = 0; i < hoteles.size(); i++) {
            System.out.println((i + 1) + ". " + hoteles.get(i).getNombreHotel());
        }

        int hotelSeleccionado = scanner.nextInt();

        if (hotelSeleccionado >= 1 && hotelSeleccionado <= hoteles.size()) {
            Hotel hotel = hoteles.get(hotelSeleccionado - 1);
            System.out.println("Habitaciones disponibles en " + hotel.getNombreHotel() + ":");
            for (Habitacion habitacion : habitaciones) {
                if (habitacion.isDisponible()) {
                    System.out.println("Habitación " + habitacion.getNumeroHabitacion());
                }
            }
        } else {
            System.out.println("¡Selección de hotel inválida!");
        }
    }

    private static void hacerReserva(List<Hotel> hoteles, List<Habitacion> habitaciones, List<Cliente> clientes, Scanner scanner) {

        System.out.println("Selecciona el número que contiene el nombre de la empresa que hará la reserva:");
        listarClientes(clientes);

        int clienteSeleccionado = scanner.nextInt();

        if (clienteSeleccionado < 1 || clienteSeleccionado > clientes.size()) {
            System.out.println("¡Selección de cliente inválida!");
            return;
        }

        Cliente cliente = clientes.get(clienteSeleccionado - 1);

        System.out.println("Ingresa el nombre del huésped que ocupará la habitación: ");
        String nombreHuesped = scanner.next();

        System.out.println("Ingresa la cédula del huésped que ocupará la habitación: ");
        String cedulaHuesped = scanner.next();

        System.out.println("Selecciona el número que contiene el nombre del hotel para hacer la reserva: ");
        listarHoteles(hoteles);

        int hotelSeleccionado = scanner.nextInt();

        if (hotelSeleccionado < 1 || hotelSeleccionado > hoteles.size()) {
            System.out.println("¡Selección de hotel inválida!");
            return;
        }

        Hotel hotel = hoteles.get(hotelSeleccionado - 1);

        System.out.println("Habitaciones disponibles para: " + hotel.getNombreHotel() + ":");
        for (Habitacion habitacion : habitaciones) {
            if (habitacion.isDisponible()) {
                System.out.println("Habitación " + habitacion.getNumeroHabitacion());
            }
        }

        System.out.println("Selecciona el número de la habitación que deseas reservar (ej. 101, 201, 301, 401, 501): ");
        int numeroHabitacion = scanner.nextInt();

        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                if (!habitacion.isDisponible()) {
                    System.out.println("La habitación seleccionada no está disponible");
                    return;
                }

                Date fechaCheckIn = new Date();
                Date fechaCheckOut = new Date();

                System.out.println("Ingresa la fecha de Check-In (formato: dd/MM/yyyy): ");
                String fechaCheckInStr = scanner.next();

                System.out.println("Ingresa la fecha de Check-Out (formato: dd/MM/yyyy): ");
                String fechaCheckOutStr = scanner.next();

                try {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    fechaCheckIn = dateFormat.parse(fechaCheckInStr);
                    fechaCheckOut = dateFormat.parse(fechaCheckOutStr);

                    Reserva reserva = new Reserva(cliente, hotel, habitacion, false, fechaCheckIn, fechaCheckOut);
                    habitacion.setDisponible(false);

                    System.out.println("¡Reserva realizada con éxito!");
                    System.out.println("Información de la reserva:");
                    System.out.println("Cliente: " + cliente.getNombreEmpresa());
                    System.out.println("Huesped: " + nombreHuesped);
                    System.out.println("Cédula: " + cedulaHuesped);
                    System.out.println("Hotel: " + hotel.getNombreHotel());
                    System.out.println("Habitación: " + habitacion.getNumeroHabitacion());
                    System.out.println("Fecha de Check-In: " + fechaCheckIn);
                    System.out.println("Fecha de Check-Out: " + fechaCheckOut);

                    return;
                } catch (Exception e) {
                    System.out.println("Error al procesar las fechas. Asegúrate de usar el formato dd/MM/yyyy.");
                    return;
                }
            }
        }

        System.out.println("No se encontró la habitación " + numeroHabitacion + " en " + hotel.getNombreHotel());
    }

    private static void listarClientes(List<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            System.out.println((i + 1) + ". " + clientes.get(i).getNombreEmpresa());
        }
    }

    private static void listarHoteles(List<Hotel> hoteles) {
        for (int i = 0; i < hoteles.size(); i++) {
            System.out.println((i + 1) + ". " + hoteles.get(i).getNombreHotel());
        }
    }

    private static void cancelarReserva(List<Hotel> hoteles, Scanner scanner) {
        System.out.println("Selecciona el número que contiene el nombre del hotel para cancelar la reserva: ");
        listarHoteles(hoteles);

        int hotelSeleccionado = scanner.nextInt();

        if (hotelSeleccionado < 1 || hotelSeleccionado > hoteles.size()) {
            System.out.println("¡Selección de hotel inválida!");
            return;
        }

        Hotel hotel = hoteles.get(hotelSeleccionado - 1);

        List<Habitacion> habitacionesReservadas = new ArrayList<>();

        for (Habitacion habitacion : hotel.getHabitaciones()) {
            if (!habitacion.isDisponible()) {
                habitacionesReservadas.add(habitacion);
            }
        }

        if (habitacionesReservadas.isEmpty()) {
            System.out.println("No hay habitaciones reservadas en " + hotel.getNombreHotel() + ".");
            return;
        }

        System.out.println("Habitaciones reservadas en " + hotel.getNombreHotel() + ":");
        for (Habitacion habitacion : habitacionesReservadas) {
            System.out.println("Habitación " + habitacion.getNumeroHabitacion());
        }

        System.out.println("Ingresa el número de la habitación que deseas cancelar:");
        int numeroHabitacion = scanner.nextInt();

        for (Habitacion habitacion : habitacionesReservadas) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion) {
                habitacion.setDisponible(true);
                System.out.println("¡Reserva cancelada con éxito para la habitación " + numeroHabitacion + " en " + hotel.getNombreHotel() + "!");
                return;
            }
        }

        System.out.println("No se encontró la habitación " + numeroHabitacion + " en " + hotel.getNombreHotel() + " o no está reservada.");
    }


}
