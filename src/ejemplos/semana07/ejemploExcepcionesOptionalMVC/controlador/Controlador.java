package ejemplos.semana07.ejemploExcepcionesOptionalMVC.controlador;

import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.EmptyValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.NullValueException;
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


    public boolean crearEscolar(String rut, String nombre, String telefono, String contacto, String nivel) throws EmptyValueException, NullValueException {
        Pasajero p=new Escolar(rut,nombre,telefono,contacto,nivel);
        if(pasajeros.contains(p)){
            return false;
        }
        return pasajeros.add(p);
    }

}
