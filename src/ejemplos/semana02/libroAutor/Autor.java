package ejemplos.semana02.libroAutor;

import java.util.ArrayList;
import java.util.Objects;

public class Autor {
    private String nombre;
    private String email;
    private ArrayList<Libro> libros;

    public Autor(String nombre, String email) {
        this.nombre = nombre;
        this.email = email;
        //este paso es fundamental!!!
        this.libros = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean agregaLibro(Libro libro){
        //importante:
        //contains solo funciona si libro tiene impelementado un equals
        if(libros.contains(libro)){
            return false;
        }
        return libros.add(libro);
    }

    public boolean eliminarLibro(Libro libro){
        //importante:
        //remove solo funciona si libro tiene impelementado un equals
        return libros.remove(libro);
    }

    public String[] obtieneTituloLibros(){
        String[] out=new String[libros.size()];
        for (int i = 0; i < libros.size(); i++) {
            out[i]=libros.get(i).getTitulo();
        }
        return out;
    }
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Autor autor)) return false;
        return Objects.equals(nombre, autor.nombre) && Objects.equals(email, autor.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, email);
    }
}
