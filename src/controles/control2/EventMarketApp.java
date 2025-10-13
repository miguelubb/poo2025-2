package controles.control2;
import java.util.*;
public class EventMarketApp {
    private Scanner tcld = new Scanner(System.in);

    public static void main(String[] args) {
        EventMarketApp app = new EventMarketApp();
    }

    public void menu(){
        System.out.println("""
                Menú principal
                1) Registrar cliente
                2) Crear Evento
                3) Registrar Servicio
                4) Cambiar Estado de evento
                5) Listar clientes
                6) Listar Eventos
                7) Salir
                
                Ingrese su opción: 
                """);
        int op=tcld.nextInt();
        switch(op){
            case 1 -> registrarClietne();
            case 2 -> crearEvento();
            case 3 -> registarServicio();
        }
    }

    private void crearEvento() {

    }

    private void registarServicio() {

    }

    private void registrarClietne() {

    }
}
