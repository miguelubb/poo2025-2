package ejemplos.semana07.ejemploExcepcionesOptionalMVC.modelo;

import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.EmptyValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.NullValueException;

public class Normal extends  Pasajero {

    public Normal(String rut, String nombre, String telefono, String nombreContacto) throws EmptyValueException, NullValueException {
        super(rut, nombre, telefono, nombreContacto);
    }

    @Override
    public long tarifa(long precioNormal) {
        return precioNormal;
    }
}
