package ejemplos.semana02.libroAutor;

import java.util.ArrayList;
import java.util.Objects;

public class Libro {
    private String titulo;
    private int yearPublicacion;
    //implementa asociación con autor
    //autores no es un atributo propiamente tal,
    //formalmente es una variable de instancia que se usa para
    //implementar la asociación
    private ArrayList<Autor> autores;

    public Libro(String titulo, int yearPublicacion) {
        this.titulo = titulo;
        this.yearPublicacion = yearPublicacion;
        this.autores = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Libro libro)) return false;
        return Objects.equals(titulo, libro.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(titulo);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getYearPublicacion() {
        return yearPublicacion;
    }

    public void setYearPublicacion(int yearPublicacion) {
        this.yearPublicacion = yearPublicacion;
    }

    public boolean agregarAutor(Autor autor){
        if(autores.contains(autor)){
            return false;
        }
        return autores.add(autor);
    }
    public boolean eliminarAutor(Autor autor){
        return autores.remove(autor);
    }
    public String[] obtieneNombreAutores(){
        String[] out=new String[autores.size()];
        for (int i = 0; i < autores.size(); i++) {
            out[i]=autores.get(i).getNombre();
        }
        return out;
    }
}
