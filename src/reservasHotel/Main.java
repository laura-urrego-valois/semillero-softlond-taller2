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
        for (Hotel hotel : hoteles) {
            habitaciones.add(new Habitacion(101, hotel));
            habitaciones.add(new Habitacion(201, hotel));
            habitaciones.add(new Habitacion(301, hotel));
            habitaciones.add(new Habitacion(401, hotel));
            habitaciones.add(new Habitacion(501, hotel));
        }


        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Microsoft"));
        clientes.add(new Cliente("Unilever"));
        clientes.add(new Cliente("Procter & Gamble"));
        clientes.add(new Cliente("Amazon"));
        clientes.add(new Cliente("Apple"));

        List<Reserva> reservas = new ArrayList<>();

        while (true) {
            System.out.println("MENÚ PRINCIPAL");
            System.out.println("Por favor selecciona el número de la opción deseada");
            System.out.println("1. Listar todas las reservas");
            System.out.println("2. Hacer reserva");
            System.out.println("3. Cancelar reserva");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    listarReservas(reservas);
                    break;
                case 2:
                    hacerReserva(hoteles, habitaciones, clientes, reservas, scanner);
                    break;
                case 3:
                    cancelarReserva(hoteles, reservas, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                default:
                    System.out.println("¡Selección inválida!");
            }
        }
    }

    private static void listarReservas(List<Reserva> reservas) {
        if (reservas.isEmpty()) {
            System.out.println("No hay reservas realizadas.");
            return;
        }

        System.out.println("Lista de reservas realizadas:");
        for (Reserva reserva : reservas) {
            System.out.println("Cliente: " + reserva.getCliente().getNombreEmpresa());
            System.out.println("Huésped: " + reserva.getHuesped());
            System.out.println("Cédula: " + reserva.getCedula());
            System.out.println("Hotel: " + reserva.getHotel().getNombreHotel());
            System.out.println("Habitación: " + reserva.getHabitacion().getNumeroHabitacion());
            System.out.println("Check-In: " + reserva.getFechaCheckIn());
            System.out.println("Check-Out: " + reserva.getFechaCheckOut());
            System.out.println("Cancelada: " + (reserva.isCancelada() ? "Sí" : "No"));
            System.out.println("---------------------------");
        }
    }

    private static void hacerReserva(List<Hotel> hoteles, List<Habitacion> habitaciones, List<Cliente> clientes, List<Reserva> reservas, Scanner scanner) {
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
            if (habitacion.getNombreHotel().equals(hotel.getNombreHotel()) && habitacion.isDisponible()) {
                System.out.println("Habitación " + habitacion.getNumeroHabitacion());
            }
        }

        System.out.println("Selecciona el número de la habitación que deseas reservar (ej. 101, 201, 301, 401, 501): ");
        int numeroHabitacion = scanner.nextInt();

        for (Habitacion habitacion : habitaciones) {
            if (habitacion.getNumeroHabitacion() == numeroHabitacion && habitacion.getNombreHotel().equals(hotel.getNombreHotel())) {
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

                    if (!verificarDisponibilidad(reservas, habitacion, hotel, fechaCheckIn, fechaCheckOut)) {
                        System.out.println("La habitación ya está reservada para las fechas seleccionadas.");
                        return;
                    }

                    Reserva reserva = new Reserva(cliente, hotel, habitacion, false, fechaCheckIn, fechaCheckOut);
                    habitacion.setDisponible(false);
                    reserva.setCliente(cliente);
                    reserva.setHuesped(nombreHuesped);
                    reserva.setCedula(cedulaHuesped);
                    reserva.setHotel(hotel);
                    reserva.setHabitacion(habitacion);
                    reserva.setFechaCheckIn(fechaCheckIn);
                    reserva.setFechaCheckOut(fechaCheckOut);
                    reservas.add(reserva);

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


    private static boolean verificarDisponibilidad(List<Reserva> reservas, Habitacion habitacion, Hotel hotel, Date fechaCheckIn, Date fechaCheckOut) {
        for (Reserva reserva : reservas) {
            if (reserva.getHabitacion().equals(habitacion) && reserva.getHotel().equals(hotel)) {
                if (!reserva.isCancelada() &&
                        fechaCheckIn.compareTo(reserva.getFechaCheckOut()) < 0 &&
                        fechaCheckOut.compareTo(reserva.getFechaCheckIn()) > 0) {
                    return false;
                }
            }
        }
        return true;
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

    private static void cancelarReserva(List<Hotel> hoteles, List<Reserva> reservas, Scanner scanner) {
        System.out.println("Selecciona el número que contiene el nombre del hotel para cancelar la reserva: ");
        listarHoteles(hoteles);

        int hotelSeleccionado = scanner.nextInt();

        if (hotelSeleccionado < 1 || hotelSeleccionado > hoteles.size()) {
            System.out.println("¡Selección de hotel inválida!");
            return;
        }

        Hotel hotel = hoteles.get(hotelSeleccionado - 1);

        System.out.println("Reservas en " + hotel.getNombreHotel() + ":");

        List<Reserva> reservasEnHotel = new ArrayList<>();

        for (Reserva reserva : reservas) {
            if (reserva.getHotel().equals(hotel)) {
                reservasEnHotel.add(reserva);
            }
        }

        if (reservasEnHotel.isEmpty()) {
            System.out.println("No hay habitaciones reservadas en " + hotel.getNombreHotel() + ".");
            return;
        }

        for (Reserva reserva : reservasEnHotel) {
            System.out.println("Habitación " + reserva.getHabitacion().getNumeroHabitacion() + " - "
                    + "Check-In: " + reserva.getFechaCheckIn() + ", Check-Out: " + reserva.getFechaCheckOut());
        }

        System.out.println("Ingresa el número de la habitación de la reserva que deseas cancelar:");
        int numeroHabitacion = scanner.nextInt();

        for (Reserva reserva : reservasEnHotel) {
            if (reserva.getHabitacion().getNumeroHabitacion() == numeroHabitacion) {
                reserva.getHabitacion().setDisponible(true);
                reserva.setCancelada(true);
                System.out.println("¡Reserva cancelada con éxito para la habitación " + numeroHabitacion + " en " + hotel.getNombreHotel() + "!");
                return;
            }
        }

        System.out.println("No se encontró la habitación " + numeroHabitacion + " en " + hotel.getNombreHotel() + " o no está reservada.");
    }

}
