package ejemplos.semana05.interfaces;

public class AireAcondicionado implements OnOf {
    private int estado;
    private static final int ON=1;
    private static final int OFF=2;
    public AireAcondicionado() {
        estado=OFF;
    }
    @Override
    public void on() {
        estado=ON;
    }

    @Override
    public void off() {
        estado=OFF;
    }
    @Override
    public String estado() {
        return estado==ON?"ON":"OFF";
    }
    @Override
    public String toString() {
        return "AireAcondicionado{" +
                "estado=" + estado +
                '}';
    }
}
