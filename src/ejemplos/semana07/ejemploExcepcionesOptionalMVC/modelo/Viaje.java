package ejemplos.semana07.ejemploExcepcionesOptionalMVC.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Viaje {
    private String origen, destino;
    private long precioNormal;
    private int capacidad;
    private List<Pasajero> pasajeros=new ArrayList<>();
    public Viaje(String origen, String destino, long precioNormal, int capacidad) {
        this.origen = origen;
        this.destino = destino;
        this.precioNormal = precioNormal;
        this.capacidad = capacidad;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public long getPrecioNormal() {
        return precioNormal;
    }

    public void setPrecioNormal(long precioNormal) {
        this.precioNormal = precioNormal;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Viaje viaje)) return false;
        return precioNormal == viaje.precioNormal && capacidad == viaje.capacidad && Objects.equals(origen, viaje.origen) && Objects.equals(destino, viaje.destino);
    }

    @Override
    public int hashCode() {
        return Objects.hash(origen, destino, precioNormal, capacidad);
    }

    public long recaudacion(){
        long suma=0;
        for(Pasajero p: pasajeros){
            suma+= p.tarifa(precioNormal);
        }
        return suma;
    }

    public boolean subePasajero(Pasajero p){
        if(pasajeros.contains(p)){
            return false;
        }
        return pasajeros.add(p);
    }
    public boolean bajaPasajero(Pasajero p){
       return pasajeros.remove(p);
    }
    public String[][] planilla(){
        String[][] out=new String[pasajeros.size()][5];
        for(int i=0;i<out.length;i++){
            out[i][0]=pasajeros.get(i).getRut();
            out[i][1]=pasajeros.get(i).getNombre();
            out[i][2]=pasajeros.get(i).getTelefono();
            out[i][3]=pasajeros.get(i).getNombreContacto();
            out[i][4]=String.format("$ %,d.-",pasajeros.get(i).tarifa(precioNormal));
        }
        return out;
    }
}
