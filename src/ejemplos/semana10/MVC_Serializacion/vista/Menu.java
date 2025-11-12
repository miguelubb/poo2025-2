package ejemplos.semana10.MVC_Serializacion.vista;

import ejemplos.semana10.MVC_Serializacion.controlador.Controlador;

import java.util.Locale;
import java.util.Scanner;


public class Menu {
    private Controlador ctrl;
    private Scanner sc;

    Menu() {
        ctrl = Controlador.getInstancia();
        sc = new Scanner(System.in);
        sc.useLocale(Locale.UK);//separador de miles .
        sc.useDelimiter("\r\n|[\n\r]");
    }

    public void display() {
        int opcion = 0;
        do {
            System.out.println(""" 
                    Menú Principal 
                    ===================================
                    1) Abrir
                    2) Guardar
                    3) Crear un persona
                    4) Modificar una persona
                    5) Eliminar una persona
                    6) Listar las personas
                    7) Salir
                    
                    Ingrese opción: 
                    """);
            opcion = sc.nextInt();
            switch (opcion) {
                case 1 -> ctrl.load();
                case 2 -> ctrl.save();
                case 3 -> crearPersona();
                case 4 -> modificarPerson();
                case 5 -> eliminarPersona();
                case 6 -> listarPersona();
                case 7 -> System.out.println("adios...");
            }
        } while (opcion != 7);
    }

    private void listarPersona() {
        System.out.println("Lista de personas:");
        System.out.printf("%5s %-20s %-20s %-20s%n", "id", "Nombre", "Email", "Teléfono");
        for (String[] row : ctrl.listadoContactos()) {
            System.out.printf("%5s %-20s %-20s %-20s%n", row[0], row[1], row[2], row[3]);
        }
    }

    private void eliminarPersona() {
        System.out.println("Eliminar persona:");
        int id = sc.nextInt();
        boolean ok = ctrl.eliminarContacto(id);
        String msg = ok ? "Eliminado" : "Error, no se encontró el contacto";
        System.out.println(msg);
    }

    private void modificarPerson() {
        System.out.println("Modificar persona:");
        System.out.println("ID:");
        int id = sc.nextInt();
        //buscar persona
        String[] persona = ctrl.buscarContacto(id);
        System.out.println("Modificar nombre (digite '=' para mantener)");
        System.out.println("Nombre Actual: " + persona[1]);
        System.out.print("Nombre Nuevo : ");
        String nombre = sc.next();
        nombre = nombre.equals("=") ? persona[1] : nombre;

        System.out.println("Modificar Email (digite '=' para mantener)");
        System.out.println("Email Actual: " + persona[2]);
        System.out.println("Email Nuevo : ");
        String email = sc.next();
        email = email.equals("=") ? persona[2] : email;
        System.out.println("Modificar Telefono:");
        System.out.println("Telefono Actual: " + persona[3]);
        System.out.println("Telefono Nuevo: ");
        String telefono = sc.next();
        telefono = telefono.equals("=") ? persona[3] : telefono;
        boolean ok = ctrl.modificarContacto(id, nombre, email, telefono);
        String msg = ok ? "Contacto Modificado" : "No se pudo modificar el contacto";
        System.out.println(msg);
    }

    private void crearPersona() {
        System.out.println("Crear persona:");
        System.out.print("ID: ");
        int id = sc.nextInt();
        System.out.print("Nombre: ");
        String nombre = sc.next();
        System.out.print("Email: ");
        String email = sc.next();
        System.out.print("Telefono: ");
        String telefono = sc.next();
        boolean ok = ctrl.agregarContacto(id, nombre, email, telefono);
        String msg = ok ? "Agregado correctamente" : "Error: persona ya existe";
        System.out.println(msg);
    }

}
