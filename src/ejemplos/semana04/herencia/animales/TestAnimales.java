package ejemplos.semana04.herencia.animales;

import java.util.ArrayList;

public class TestAnimales {
    public static void main(String[] args) {
        Animal a=new Perro("Boby");
        Perro b=new Perro("Firulais");
        Animal c=b;

        ArrayList<Animal> animales=new ArrayList<>();
        animales.add(a);
        animales.add(b);
        animales.add(new Gato("Tom"));
        animales.add(new Gato("Misifus"));
        animales.remove(4);
        animales.add(new Gato("Doraimon"));
        animales.add(new Pato("Donald"));
        animales.add(new Pato("Lucas"));
        animales.add(new Pato("mcPato"));
        for(Animal a1:animales){
            System.out.println(a1.saludar());
        }
    }
}
