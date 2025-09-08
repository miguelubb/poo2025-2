package ejemplos.semana03.inscripcionAEventos;

import java.util.Scanner;

public class Main {
    private static Scanner tcld=new Scanner(System.in);
    private static SistemaEvento sistema=new SistemaEvento();
    public static void main(String[] args) {
        String[] menu={"Crear evento","Crear Asistente","Inscribir asistente a evento",
                "Lista de Asistentes", "Lista de eventos", "Lista de asistentes a evento","Salir"};
        int op=0;
        do{
            System.out.println("Menú Principal");
            System.out.println("--------------------------------");
            for(int i=0;i<menu.length;i++){
                System.out.printf("%d.- %s%n",i+1, menu[i]);
            }
            op=tcld.nextInt();
            switch(op){
                case 1->creaEvento();
                case 2->creaAsistente();
                case 3->inscribeEvento();

                case 4->listaEventos();
                case 5->listaAsistentes();
                case 6->listaAsistentesEvento();
                case 7->System.out.println("Adios...");
                default -> System.out.println("Error, opción no válida");
            }
        }while(op!= menu.length);
    }
    public static void creaEvento(){

    }
    public static void creaAsistente(){
        System.out.println("Creación de Asistente");
        System.out.println("Nombre: ");
        String nombre=tcld.next();
        System.out.println("email: ");
        String email=tcld.next();
        boolean isOk=sistema.creaAsistente(nombre,email);
        if(isOk){
            System.out.println("Asistente creadado de forma exitosa.");
        }else{
            System.out.println("No fue posible crear asistente. Asistente ya existe");
        }
    }
    public static void inscribeEvento(){
    }
    public static void listaEventos(){

    }
    public static void listaAsistentes(){

    }
    public static void listaAsistentesEvento(){

    }
    public static void error(){

    }
}
