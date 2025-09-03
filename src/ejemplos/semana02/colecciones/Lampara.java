package ejemplos.semana02.colecciones;

import java.util.Objects;

public class Lampara {
    private String marca;
    private int potencia;
    private Estado estado;

    public Lampara(String marca, int potencia) {
        this.marca = marca;
        this.potencia = potencia;
        estado=Estado.APAGADA;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    public Estado getEstado() {
        return estado;
    }
    public void endender(){
        estado=Estado.ENCENDIDA;
    }
    public void apagar(){
        estado=Estado.APAGADA;
    }

    @Override
    public String toString() {
        return marca + ", " + potencia +", "+ estado;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Lampara lampara)) return false;
        return potencia == lampara.potencia && Objects.equals(marca, lampara.marca) && estado == lampara.estado;
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca, potencia, estado);
    }
}
