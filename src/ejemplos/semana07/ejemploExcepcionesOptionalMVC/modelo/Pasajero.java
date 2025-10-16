package ejemplos.semana07.ejemploExcepcionesOptionalMVC.modelo;

import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.EmptyValueException;
import ejemplos.semana07.ejemploExcepcionesOptionalMVC.excepciones.NullValueException;

import java.util.Objects;

public abstract class Pasajero {
    private String rut, nombre, telefono, nombreContacto;

    public Pasajero(String rut, String nombre, String telefono, String nombreContacto) throws NullValueException, EmptyValueException {
        this.rut = rut;
        this.nombre = nombre;
        this.telefono = telefono;
        this.nombreContacto = nombreContacto;
        if(rut==null){
            throw new NullValueException("rut");
        }
        if(rut.isEmpty()){
            throw new EmptyValueException("rut");
        }
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws NullValueException, EmptyValueException {
        if(rut==null){
            throw new NullValueException("rut");
        }
        if(rut.isEmpty()){
            throw new EmptyValueException("rut");
        }
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pasajero pasajero)) return false;
        return Objects.equals(rut, pasajero.rut) && Objects.equals(nombre, pasajero.nombre) && Objects.equals(telefono, pasajero.telefono) && Objects.equals(nombreContacto, pasajero.nombreContacto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rut, nombre, telefono, nombreContacto);
    }

    @Override
    public String toString() {
        return "Pasajero{" +
                "rut='" + rut + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nombreContacto='" + nombreContacto + '\'' +
                '}';
    }

    public abstract long tarifa(long precioNormal);
}
