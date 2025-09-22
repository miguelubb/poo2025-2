package ejemplos.semana04.herencia.animales;

import java.util.Objects;

public abstract class Animal {
    private String nombre;
    public Animal(String nombre) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public abstract String saludar();

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Animal animal)) return false;
        return Objects.equals(nombre, animal.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(nombre);
    }
}
