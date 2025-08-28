package ejemplos.semana01.punto;

public class Punto {
    //atributos
    private int x;
    private int y;
    //constructores
    public Punto(int a, int b) {
        x = a;
        y = b;
    }
    //métodos
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int distanciaAlOrigen(){
        return (int)Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
    }

    public void traslada(int desplX, int desplY){
        x+=desplX;
        y+=desplY;
    }
}
