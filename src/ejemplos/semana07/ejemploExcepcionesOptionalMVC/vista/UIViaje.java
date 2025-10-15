package ejemplos.semana07.ejemploExcepcionesOptionalMVC.vista;

import ejemplos.semana07.ejemploExcepcionesOptionalMVC.controlador.Controlador;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.EmptyValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.NullValueException;

import java.sql.SQLOutput;
import java.util.Scanner;

public class UIViaje {
    private Scanner sc;
    //--------Singleton
    private UIViaje() {
        //inicializar variables de instancia si hubiere.
        sc=new Scanner(System.in);
    }
    private static UIViaje instance=new UIViaje();
    public static UIViaje getInstance() {
        return instance;
    }
    //------fin singleton

    public void menu(){
        int op=0;

        do{
            System.out.println("""
                    ...::: Menú Principal :::...
                    1) Crear pasajero Escolar
                    2) ...
                    3)
                    0) Salir
                    Ingrese opcion:
                    """);
            op=sc.nextInt();
            switch(op){
                case 1 -> crearEscolar();
                case 2 -> System.out.println("No impelemntada");
                case 3 -> System.out.println("No impelemntada");
                default -> System.out.println("opcion no valida");
            }
        }while(op!=0);

    }

    private void crearEscolar() {
        System.out.println("Cración de un Pasajero Escolar");
        System.out.println("Rut: ");
        String rut=sc.next();
        System.out.println("Nombre: ");
        String nombre=sc.next();
        System.out.println("Telefono: ");
        String telefono=sc.next();
        System.out.println("Contacto: ");
        String contacto=sc.next();
        System.out.println("Nivel: ");
        String nivel=sc.next();
        try {
            boolean ok= Controlador.getInstance()
                    .crearEscolar(rut, nombre, telefono, contacto, nivel);
            System.out.println(ok?"Pasajero Escolar creada exitosamente"
                    :"Pasajero Escolar Está repetido");
        } catch (EmptyValueException e) {
            System.out.println("El rut no puede estar vacío");
        } catch (NullValueException e) {
            System.out.println("El rut no puede ser nulo");
        }
    }
}
