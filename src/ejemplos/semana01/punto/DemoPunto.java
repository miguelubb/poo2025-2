package ejemplos.semana01.punto;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class DemoPunto {
    public static void main(String[] args) {
        Punto p;
        p=new Punto(7,2);
        System.out.println("Posición de Pepe: "+ p);
        System.out.println("distancia al origen: "+p.distanciaAlOrigen());
        //"pepe" p ¿cuál es tu distancia al origen?
        //p.distanciaAlorigen();
    }
}