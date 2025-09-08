package ejemplos.semana03.inscripcionAEventos;

import java.time.LocalDate;
import java.util.Objects;

public class Inscripcion {
    private LocalDate fecha;
    private Asistente asistente;
    private Evento evento;

    public Inscripcion(Asistente asistente, Evento evento) {
        this.asistente = asistente;
        this.evento = evento;
        this.fecha = LocalDate.now();
    }
    public LocalDate getFechaInscripcion() {
        return fecha;
    }

    public Asistente getAsistente() {
        return asistente;
    }
    public Evento getEvento() {
        return evento;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Inscripcion that)) return false;
        return Objects.equals(asistente, that.asistente) && Objects.equals(evento, that.evento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(asistente, evento);
    }
}
