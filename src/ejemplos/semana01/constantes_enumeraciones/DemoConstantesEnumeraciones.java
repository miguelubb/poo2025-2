package ejemplos.semana01.constantes_enumeraciones;

public class DemoConstantesEnumeraciones {
    public static void main(String[] args) {
        System.out.println("Ejemplo de uso de constantes");
        int miColor = Color.ROJO;
        System.out.println("Color: " + miColor);
        //lo mismo pero con enumeración ColorEnum.
        System.out.println("Ejemplo de uso de enumeraciones");
        ColorEnum miColorEnum = ColorEnum.ROJO;
        System.out.println("Color: " + miColorEnum);
    }
}
