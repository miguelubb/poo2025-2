package ejemplos.semana07.ejemploExcepcionesOptionalMVC.modelo;
//la importación estática permite importar los métodos estáticos de una clase
//tambien se pueden importar los objetos privados. Con esto se simplifica las llamadas
//en vez de Math.round, simplemente se usa round.

import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.EmptyValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.NullValueException;

import static java.lang.Math.*;
public class TerceraEdad extends Pasajero {
    public TerceraEdad(String rut, String nombre, String telefono, String nombreContacto) throws EmptyValueException, NullValueException {
        super(rut, nombre, telefono, nombreContacto);
    }

    @Override
    public long tarifa(long precioNormal) {
        return round(precioNormal/10.0*0.4)*10;
    }
}
