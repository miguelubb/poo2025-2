package ejemplos.semana11.ejemploBasicoStreams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class EjemploConObjeto {
    static ArrayList<Persona> personas = new ArrayList<>();

    public static void main(String[] args) {
        personas.add(new Persona(1,"Juan Zapata 1"));
        personas.add(new Persona(2,"Ester Segura 2"));
        personas.add(new Persona(3,"Ana Alarcón 3"));
        personas.add(new Persona(4,"Luis Fuentes 4"));
        personas.add(new Persona(5,"Bernardo Muñoz 5"));
        Optional<Persona> personaBuscada=findByID(5);
        if(personaBuscada.isPresent()){
            System.out.println("Persona buscada: "+personaBuscada.get().getNombre());
        }else{
            System.out.println("No existe el Persona buscada");
        }
        personas.stream()
                .sorted(Comparator.comparing(Persona::getNombre))
                .forEach(System.out::println);
    }

    public static Optional<Persona> findByID(int id){
        return personas
                .stream()
                .filter(p -> p.getId()==id)
                .findFirst();
    }
}
