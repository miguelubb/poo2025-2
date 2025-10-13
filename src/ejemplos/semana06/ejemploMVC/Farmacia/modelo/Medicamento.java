package ejemplos.semana06.ejemploMVC.Farmacia.modelo;

import java.util.Objects;

public class Medicamento {
    private String nombre;
    private Tipo presentacion;
    private int precio;

    public Medicamento(String nombre, Tipo presentacion, int precio) {
        this.nombre = nombre;
        this.presentacion = presentacion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public Tipo getPresentacion() {
        return presentacion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Medicamento{" +
                "nombre='" + nombre + '\'' +
                ", presentacion=" + presentacion +
                ", precio=" + precio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Medicamento that)) return false;
        return Objects.equals(nombre, that.nombre) && presentacion == that.presentacion;
    }

}
