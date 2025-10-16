package ejemplos.semana07.ejemploExcepcionesOptionalMVC.vista;

import ejemplos.semana07.ejemploExcepcionesOptionalMVC.controlador.Controlador;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.EmptyValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.NullValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.RutException;

import java.sql.SQLOutput;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class UIViaje {
    private Scanner sc;

    //--------Singleton
    private UIViaje() {
        //inicializar variables de instancia si hubiere.
        sc = new Scanner(System.in);
    }

    private static UIViaje instance = new UIViaje();

    public static UIViaje getInstance() {
        return instance;
    }
    //------fin singleton

    public void menu() {
        int op = 0;

        do {
            System.out.println("""
                    ...::: Menú Principal :::...
                    1) Crear pasajero Escolar
                    2) Crear pasajero Tercera edad
                    3) Crear pasejero Normal
                    4) Crear Viaje
                    5) Planilla de viaje (incluye recaudación)
                    6) Listar pasajeros(de los distintos tipos)
                    7) Listar Viajes
                    8) Subir un pasajero a Viaje
                    9) bajar un pasajero a Viaje
                    0) Salir
                    Ingrese opcion:
                    """);
            Optional<Integer> opcion = leerEntero();
            if (opcion.isPresent()) {
                op=opcion.get();
                switch (op) {
                    case 1 -> crearEscolar();
                    case 2 -> System.out.println("No impelemntada");
                    case 3 -> System.out.println("No impelemntada");
                    default -> System.out.println("opcion no valida");
                }
            }else{
                System.out.println("La opción del menú debe ser un número válido");
            }
        } while (op != 0);

    }

    private void crearEscolar() {
        System.out.println("Cración de un Pasajero Escolar");
        System.out.println("Rut: ");
        String rut = sc.next();
        System.out.println("Nombre: ");
        String nombre = sc.next();
        System.out.println("Telefono: ");
        String telefono = sc.next();
        System.out.println("Contacto: ");
        String contacto = sc.next();
        System.out.println("Nivel: ");
        String nivel = sc.next();
        try {
            Controlador sistema = Controlador.getInstance();
            boolean ok = sistema.crearEscolar(rut, nombre, telefono, contacto, nivel);
            System.out.println(ok ? "Pasajero Escolar creada exitosamente"
                    : "Pasajero Escolar Está repetido");
        } catch (EmptyValueException e) {
            System.out.println("El rut no puede estar vacío");
        } catch (NullValueException e) {
            System.out.println("El rut no puede ser nulo");
        } catch (RutException e) {
            System.out.println("El rut no es válido");
        }
    }

    private Optional<Integer> leerEntero() {
        try {
            int data = Integer.parseInt(sc.next());
            return Optional.of(data);
        }catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
