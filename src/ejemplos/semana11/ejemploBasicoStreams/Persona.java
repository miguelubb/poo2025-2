package ejemplos.semana11.ejemploBasicoStreams;

public class Persona{
    private int id;
    private String nombre;
    Persona(int id,String nombre){
        this.id=id;
        this.nombre=nombre;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String toString(){
        return id+";"+nombre;
    }
}
