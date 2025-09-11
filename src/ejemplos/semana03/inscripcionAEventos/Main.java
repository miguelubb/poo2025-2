package ejemplos.semana03.inscripcionAEventos;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    private static Scanner tcld = new Scanner(System.in);
    private static SistemaEvento sistema = new SistemaEvento();

    public static void main(String[] args) {
        String[] menu = {"Crear evento", "Crear Asistente", "Inscribir asistente a evento",
                "Lista de eventos", "Lista de asistentes", "Lista de asistentes a evento", "Salir"};
        init();
        int op = 0;
        do {
            System.out.println("Menú Principal");
            System.out.println("--------------------------------");
            for (int i = 0; i < menu.length; i++) {
                System.out.printf("%d.- %s%n", i + 1, menu[i]);
            }
            op = tcld.nextInt();
            switch (op) {
                case 1 -> creaEvento();
                case 2 -> creaAsistente();
                case 3 -> inscribeEvento();
                case 4 -> listaEventos();
                case 5 -> listaAsistentes();
                case 6 -> listaAsistentesEvento();
                case 7 -> System.out.println("Adios...");
                default -> System.out.println("Error, opción no válida");
            }
        } while (op != menu.length);
    }
    private static void init(){
        sistema.creaEvento("UBB", LocalDate.of(2025, 12,12),1500, TipoEvento.CHARLA);
        sistema.creaEvento("Hackaton", LocalDate.of(2025, 12,12),1500, TipoEvento.CHARLA);
        sistema.creaAsistente("Juan","juan@gmail.com");
        sistema.creaAsistente("Ana","ana@gmail.com");
        sistema.creaAsistente("Isabel","isabel@gmail.com");
        sistema.creaAsistente("Luis","luis@gmail.com");
        sistema.inscribeAsistenteEnEvento( "Juan", "UBB");
        sistema.inscribeAsistenteEnEvento( "Ana", "UBB");
        sistema.inscribeAsistenteEnEvento( "Isabel", "UBB");
        sistema.inscribeAsistenteEnEvento( "Juan", "Hackaton");
        sistema.inscribeAsistenteEnEvento( "Ana", "Hackaton");
        sistema.inscribeAsistenteEnEvento( "Luis", "Hackaton");
    }
    public static void creaEvento() {
        System.out.println("Creación de Evento");
        System.out.println("Nombre: ");
        String nombre=tcld.next();
        System.out.println("Fecha (dd/MM/yyyy): ");
        String[] fechaStr=tcld.next().split("/");
        int day=Integer.parseInt(fechaStr[0]);
        int month=Integer.parseInt(fechaStr[1]);
        int year=Integer.parseInt(fechaStr[2]);
        LocalDate fecha=LocalDate.of(year,month,day);
        System.out.println("Precio: ");
        int precio=tcld.nextInt();
        System.out.println("Tipo [1]CHARLA,[2]SEMINARIO,[3]CONGRESO]: ");
        String[] nombreEvento={"CHARLA","SEMINARIO","CONGRESO"};
        TipoEvento tipo=TipoEvento.valueOf(nombreEvento[tcld.nextInt()-1]);
        boolean ok=sistema.creaEvento(nombre, fecha, precio, tipo);
        if (ok) {
            System.out.println("Evento Creado");
        }else{
            System.out.println("Error: evento no creado");
        }
    }

    public static void creaAsistente() {
        System.out.println("Creación de Asistente");
        System.out.println("Nombre: ");
        String nombre = tcld.next();
        System.out.println("email: ");
        String email = tcld.next();
        boolean isOk = sistema.creaAsistente(nombre, email);
        if (isOk) {
            System.out.println("Asistente creadado de forma exitosa.");
        } else {
            System.out.println("No fue posible crear asistente. Asistente ya existe");
        }
    }

    public static void inscribeEvento() {
        System.out.println("Inscribir asistente a evento");
        System.out.println("Nombre Asistente: ");
        String nombreAsistente=tcld.next();
        System.out.println("Nombre Evento: ");
        String nombreEvento=tcld.next();
        boolean isOk=sistema.inscribeAsistenteEnEvento(nombreAsistente, nombreEvento);
        if(isOk){
            System.out.println("Evento Inscrito");
        }else{
            System.out.println("Error: evento no inscrito");
        }
    }

    public static void listaEventos() {
        String[][] eventos=sistema.listaEventos();
        System.out.println("Lista de Eventos");
        System.out.printf("*%20s-%12s-%12s-%12s*%n",linea(20),linea(12),linea(12),linea(12));
        System.out.printf("|%-20s|%12s|%12s|%-12s|%n","Nombre","Fecha","Precio","Tipo");
        for (int i = 0; i < eventos.length; i++) {
            System.out.printf("+%20s+%12s+%12s+%12s+%n",linea(20),linea(12),linea(12),linea(12));
            System.out.printf("|%-20s|%12s|%12s|%-12s|%n",eventos[i][0],eventos[i][1], eventos[i][2], eventos[i][3]);
        }
        System.out.printf("*%20s-%12s-%12s-%12s*%n",linea(20),linea(12),linea(12),linea(12));
    }

    public static void listaAsistentes() {
        String[][] asistentes=sistema.listaAsistentes();
        System.out.println("Lista de Asistentes");
        System.out.printf("*%30s-%40s*%n",linea(30),linea(40));
        System.out.printf("|%-30s|%-40s|%n","Nombre","Email");
        for (int i = 0; i < asistentes.length; i++) {
            System.out.printf("|%30s+%40s|%n",linea(30),linea(40));
            System.out.printf("|%-30s+%-40s|%n",asistentes[i][0],asistentes[i][1]);
        }
        System.out.printf("*%30s+%40s*%n",linea(30),linea(40));
    }

    public static void listaAsistentesEvento() {
        System.out.println("Lista de Asistentes a evento");
        System.out.println("Nombre Evento: ");
        String nombreEvento=tcld.next();
        String[][] asistentes=sistema.listaAsistenteAEvento(nombreEvento);
        System.out.printf("*%30s-%40s*%n",linea(30),linea(40));
        System.out.printf("|%30s|%40s|%n","Nombre","Email");
        for (int i = 0; i < asistentes.length; i++) {
            System.out.printf("|%30s+%40s|%n",linea(30),linea(40));
            System.out.printf("|%30s+%40s|%n",asistentes[i][0],asistentes[i][1]);
        }
        System.out.printf("*%30s+%40s*%n",linea(30),linea(40));
    }
    private static String linea(int largo){
        StringBuffer linea=new StringBuffer();
        for(int i=0;i<largo;i++){
            linea.append("-");
        }
        return linea.toString();
    }
}
