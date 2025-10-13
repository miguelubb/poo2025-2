package ejemplos.semana07.excepcionesBasico;

public class Fraccion {
    private int numerador;
    private int denominador;
    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        if (denominador == 0) {
            //lanzar la excepcion
            DenominadorRuntimeException e=new DenominadorRuntimeException("El denominador no puede ser 0");
            throw e;
            //throw new DenominadorExeption("El denominador no puede ser 0");
        }
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) throws DenominadorException {
        this.denominador = denominador;
        if (denominador == 0) {
            throw new DenominadorException("El denominador no puede ser 0");
        }
    }

    @Override
    public String toString() {
        return numerador + "/" + denominador;
    }
}
