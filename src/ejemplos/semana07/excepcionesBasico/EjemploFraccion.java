package ejemplos.semana07.excepcionesBasico;

public class EjemploFraccion {
    public static void main(String[] args)  {
        Fraccion miFraccion=new Fraccion(3,5);
        try {
            modifaDenominador(miFraccion,0);
        } catch (DenominadorException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(miFraccion);
    }

    private static void modifaDenominador(Fraccion miFraccion, int i) throws DenominadorException {
            miFraccion.setDenominador(0);
    }
}
