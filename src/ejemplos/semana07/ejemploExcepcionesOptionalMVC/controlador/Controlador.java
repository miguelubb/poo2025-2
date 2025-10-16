package ejemplos.semana07.ejemploExcepcionesOptionalMVC.controlador;

import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.EmptyValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.NullValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.RutException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.modelo.Escolar;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.modelo.Pasajero;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.modelo.Viaje;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    //------------ Singleton -------------------------------
    private static Controlador instance=new Controlador();
    public static Controlador getInstance(){
        return instance;
    }
    private Controlador(){

    }
    //-------------- Fin Singleton --------------------------
    private List<Pasajero> pasajeros=new ArrayList<>();
    private List<Viaje> viajes=new ArrayList<>();


    public boolean crearEscolar(String rut, String nombre, String telefono, String contacto, String nivel) throws EmptyValueException, NullValueException, RutException {
        if(validarRut(rut)) {
            Pasajero p = new Escolar(rut, nombre, telefono, contacto, nivel);
            if (pasajeros.contains(p)) {
                return false;
            }
            return pasajeros.add(p);
        }else{
            throw new RutException("Error: Rut no válido para el escolar");
        }
    }

    public boolean validarRut(String rut) {
        //"11.111.111-2"
        if (rut == null || rut.isEmpty()) return false;

        // Eliminar puntos y guion
        rut = rut.replace(".", "").replace("-", "");
        //"111111112"
        // Separar cuerpo y dígito verificador
        if (rut.length() < 2) return false;
        String cuerpo = rut.substring(0, rut.length() - 1);
        //cuerpo="11111111"
        char dvIngresado = rut.charAt(rut.length() - 1);
        //dvIngresado='2'
        try {
            int rutNum = Integer.parseInt(cuerpo);
            char dvCalculado = calcularDV(rutNum);
            return Character.toUpperCase(dvIngresado) == dvCalculado;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private char calcularDV(int rut) {
        int m = 0, s = 1;
        while (rut != 0) {
            s = (s + rut % 10 * (9 - m++ % 6)) % 11;
            rut /= 10;
        }
        return (char) (s != 0 ? s + 47 : 'K');
    }

}
