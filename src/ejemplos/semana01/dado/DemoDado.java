package ejemplos.semana01.dado;

public class DemoDado {
    public static void main(String[] args) {
        Dado dado1 = new Dado();
        Dado dado2 = new Dado();
        dado1.lanzar();
        dado2.lanzar();
        System.out.println("suma dados: "+ (dado1.getCara() + dado2.getCara()));
    }
}
