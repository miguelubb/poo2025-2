package ejemplos.semana03.inscripcionAEventos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Evento {
    private String nombre;
    private LocalDate fecha;
    private int precio;
    private TipoEvento tipo;
    private ArrayList<Inscripcion> inscripciones;

    public Evento(String nombre, LocalDate fecha, int precio, TipoEvento tipo) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.precio = precio;
        this.tipo = tipo;
        this.inscripciones = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public int getPrecio() {
        return precio;
    }

    public TipoEvento getTipo() {
        return tipo;
    }

    public boolean inscribeAsistente(Asistente asistente) {
        Inscripcion inscripcion=new Inscripcion(asistente,this);
        if(inscripciones.contains(inscripcion)){
            return false;
        }
        inscripciones.add(inscripcion);
        asistente.addInscripciones(inscripcion);
        return true;
    }
    public Inscripcion[] getInscripciones() {
        return inscripciones.toArray(new Inscripcion[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Evento evento)) return false;
        return Objects.equals(nombre, evento.nombre) && Objects.equals(fecha, evento.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, fecha);
    }
}
