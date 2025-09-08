package ejemplos.semana03.inscripcionAEventos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SistemaEvento {
    private ArrayList<Evento> eventos=new ArrayList<>();
    private ArrayList<Asistente> asistentes=new ArrayList<>();

    public SistemaEvento(){

    }
    public boolean creaAsistente(String nombre, String email){
        Asistente asistente=new Asistente(nombre,email);
        if(asistentes.contains(asistente)){
            return false;
        }
        return asistentes.add(asistente);//siempre retorna verdadero!!
    }

    public boolean creaEvento(String nombre, LocalDate fecha, int precio, TipoEvento tipo){
        Evento evento=new Evento(nombre,fecha,precio,tipo);
        if(eventos.contains(evento)){
            return false;
        }
        return eventos.add(evento);//en arraylist add siempre retorna true!!!!
    }

    public boolean inscribeAsistenteEnEvento(String nombreAsistente, String nombreEvento){
        //busqueda de asistente
        Asistente asistente=findAsistente(nombreAsistente);
        if(asistente==null){
            return false;
        }
        //Aquí estoy seguro que el asistente existe y está guardado en la variable asistente.
        Evento evento=findEvento(nombreEvento);
        if(evento==null){
            return false;
        }
        //aquí tengo el evento y el asistente
        return evento.inscribeAsistente(asistente);
    }
    private Asistente findAsistente(String nombre){
        for(Asistente a:asistentes){
            if(a.getNombre().equals(nombre)){
                return a;
            }
        }
        return null;
    }
    private Evento findEvento(String nombre){
        for(Evento e:eventos){
            if(e.getNombre().equals(nombre)){
                return e;
            }
        }
        return null;
    }

    public String[][] listaAsistentes(){
        String[][] lista=new String[asistentes.size()][2];
        for(int i=0;i<asistentes.size();i++){
            lista[i][0]=asistentes.get(i).getNombre();
            lista[i][1]=asistentes.get(i).getEmail();
        }
        return lista;
    }

    public String[][] listaEventos(){
        String[][] lista=new String[eventos.size()][4];
        for(int i=0;i<eventos.size();i++){
            lista[i][0]=eventos.get(i).getNombre();
            lista[i][1]=eventos.get(i).getFecha().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            //lista[i][1]=eventos.get(i).getFecha().toString();//formato iso "yyyy-MM-dd"
            lista[i][2]=String.format("%,d",eventos.get(i).getPrecio());
            lista[i][3]=eventos.get(i).getTipo().toString();
        }
        return lista;
    }

    public String[][] listaAsistenteAEvento(String nombreEvento){
        Evento evento=findEvento(nombreEvento);
        if(evento==null){
            return new String[0][0];
        }
        Inscripcion[] inscripciones=evento.getInscripciones();
        String[][] lista=new String[inscripciones.length][2];
        for(int i=0;i<inscripciones.length;i++){
            lista[i][0]=inscripciones[i].getAsistente().getNombre();
            lista[i][1]=inscripciones[i].getAsistente().getEmail();
        }
        return lista;
    }
}
