package ejemplos.semana10.MVC_Serializacion.modelo;

import java.io.Serializable;
import java.util.Objects;

public class Contacto implements Serializable {
    private int  id;
    private  String nombre;
    private String email;
    private String telefono;

    public Contacto(int id, String nombre, String email, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Contacto contacto)) return false;
        return id == contacto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Contacto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
    public String[] toStringArray(){
        String[] resultado=new String[4];
        resultado[0]=Integer.toString(id);
        resultado[1]=nombre;
        resultado[2]=email;
        resultado[3]=telefono;
        return resultado;
    }
}
