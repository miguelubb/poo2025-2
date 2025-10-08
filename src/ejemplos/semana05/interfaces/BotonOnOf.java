package ejemplos.semana05.interfaces;

public class BotonOnOf extends ClaseAbstractaOnOf {
    private boolean on=false;

    public BotonOnOf() {
        on=false;
    }
    @Override
    public void on() {
        on=true;
    }

    @Override
    public void off() {
        on=false;
    }

    @Override
    public String toString() {
        return "BotonOnOf{" +
                "on=" + on +
                '}';
    }
}
