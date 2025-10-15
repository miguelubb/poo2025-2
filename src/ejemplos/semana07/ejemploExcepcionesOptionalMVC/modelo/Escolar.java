package ejemplos.semana07.ejemploExcepcionesOptionalMVC.modelo;

import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.EmptyValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.NullValueException;

public class Escolar extends Pasajero {
    private String nivelEscolar;

    public Escolar(String rut, String nombre, String telefono, String nombreContacto, String nivel) throws EmptyValueException, NullValueException {
        super(rut, nombre, telefono, nombreContacto);
        this.nivelEscolar = nivel;
    }

    @Override
    public long tarifa(long precioNormal) {
        double factor = switch (nivelEscolar.toLowerCase()) {
            case "básica" -> 0.0;
            case "media" -> 0.4;
            default -> 0.5;
        };
        //se podría importar round. como en TerceraEdad
        //redondeo a la decena más cercana.
        return Math.round(precioNormal/10.0 * factor)*10;
    }
}
