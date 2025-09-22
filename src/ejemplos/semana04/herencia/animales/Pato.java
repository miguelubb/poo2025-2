package ejemplos.semana04.herencia.animales;

public class Pato extends Animal{
    public Pato(String nombre) {
        //se invoca el constructor de la superclase
        super(nombre);
    }
    @Override
    public String saludar() {
        return getNombre()+": cuac, cuac!!!";
    }
}
