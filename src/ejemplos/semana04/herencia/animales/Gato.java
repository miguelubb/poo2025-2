package ejemplos.semana04.herencia.animales;

public class Gato extends Animal{
    public Gato(String nombre) {
        super(nombre);
    }
    @Override
    public String saludar() {
        return getNombre()+": miau, miau!!!";
    }
}
