package ejemplos.semana06.ejemploMVC.Farmacia.vista;

import ejemplos.semana06.ejemploMVC.Farmacia.controlador.ControladorFarmacia;

import java.util.Scanner;

public class UIFarmacia {
    private static UIFarmacia instance=new UIFarmacia();
    private UIFarmacia(){}
    public static UIFarmacia getInstance(){
        return instance;
    }

    Scanner sc=new Scanner(System.in);

    public void menu(){
        int op=0;
        do{
            System.out.println("""
                    1) Crear Medicamento
                    2) Crear Laboratorio
                    3) Listar Medicamentos y Laboratorios
                    4) Salir
                    Ingrese opción: 
                    """);
            op=sc.nextInt();
            switch(op){
                case 1 -> creaMedicamento();
                case 4 -> System.out.print("...Adios");
                default -> System.out.println("Opcion no implementada");
            }
        }while(op!=4);
    }

    private void creaMedicamento(){
        System.out.println("Nombre:");
        String nombre=sc.next();
        System.out.println("Presentación (capsula, comprimido, gotas, polvo):");
        String presentacion=sc.next();
        System.out.println("Precio:");
        int precio=sc.nextInt();
        boolean ok=ControladorFarmacia.getInstance().creaMedicamento(nombre,presentacion,precio);
        System.out.println(ok ?"Medicamento creado con éxito":"Error: Medicamento no creado");
    }
}
