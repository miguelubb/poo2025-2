package ejemplos.semana05.interfaces;

public class Rectangulo implements Comparable<Rectangulo>{
    private float a, b;
    public Rectangulo(float a, float b) {
        this.a = a;
        this.b = b;
    }
    public float area(){
        return a*b;
    }
    public float perimetro(){
        return 2*(a+b);
    }


    @Override
    public int compareTo(Rectangulo o) {
        return (int)((this.area()-o.area())*10000);
    }
}
