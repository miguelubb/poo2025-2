package ejemplos.semana02.libroAutor;

import java.util.Arrays;

public class TestLibroAutor {
    public static void main(String[] args) {
        Libro papelucho=new Libro("Papelucho", 1947);
        Libro papeluchoDetective=new Libro("Papelucho detective", 1957);
        Autor marcelaPaz=new Autor("Marcela Paz", "marcela.paz@gmail.com");
        System.out.println("autores de: "+papelucho.getTitulo());
        System.out.println(Arrays.toString(papelucho.obtieneNombreAutores()));

        System.out.println("autores de: "+papeluchoDetective.getTitulo());
        System.out.println(Arrays.toString(papeluchoDetective.obtieneNombreAutores()));

        System.out.println("libros de: "+marcelaPaz.getNombre());
        System.out.println(Arrays.toString(marcelaPaz.obtieneTituloLibros()));

        System.out.println("asociando libros a "+ marcelaPaz.getNombre());
        marcelaPaz.agregaLibro(papelucho);
        marcelaPaz.agregaLibro(papeluchoDetective);

        //se crearon los objetos, pero no se han asociados ni libros ni autores
        papelucho.agregarAutor(marcelaPaz);
        papeluchoDetective.agregarAutor(marcelaPaz);

        //volver a imprimir
        System.out.println("autores de: "+papelucho.getTitulo());
        System.out.println(Arrays.toString(papelucho.obtieneNombreAutores()));

        System.out.println("autores de: "+papeluchoDetective.getTitulo());
        System.out.println(Arrays.toString(papeluchoDetective.obtieneNombreAutores()));

        System.out.println("libros de: "+marcelaPaz.getNombre());
        System.out.println(Arrays.toString(marcelaPaz.obtieneTituloLibros()));
    }
}
