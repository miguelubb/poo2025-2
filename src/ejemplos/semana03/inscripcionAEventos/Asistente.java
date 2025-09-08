package ejemplos.semana03.inscripcionAEventos;

import java.util.ArrayList;
import java.util.Objects;

public class Asistente {
    private String nombre, email;

    private ArrayList<Inscripcion> inscripciones;
    public Asistente(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        inscripciones = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }
    public void addInscripciones(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
    }
    public Inscripcion[] getInscripciones() {
        return inscripciones.toArray(new Inscripcion[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Asistente asistente)) return false;
        return Objects.equals(email, asistente.email);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(email);
    }
}
