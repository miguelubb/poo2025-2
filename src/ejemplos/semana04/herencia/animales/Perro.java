package ejemplos.semana04.herencia.animales;

public class Perro extends Animal {

    public Perro(String nombre) {
        super(nombre);
    }
    @Override
    public String saludar() {
        return getNombre()+": "+ladrar()+", "+ladrar()+"!!";
    }
    public String ladrar(){
        return "Guau";
    }
}
