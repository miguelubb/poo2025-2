package ejemplos.semana01.rectangulo;

public class Rectangulo {
    private int ancho;
    private int largo;

    public Rectangulo(int ancho, int largo) {
        this.ancho=ancho;
        this.largo=largo;
    }
    public int area(){
        return largo*ancho;
    }
    public int perimetro(){
        return (largo+ancho)*2;
    }
}
