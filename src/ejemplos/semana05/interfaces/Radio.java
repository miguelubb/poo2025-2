package ejemplos.semana05.interfaces;

public class Radio implements OnOf {
    BotonOnOf boton;
    private float dial=89.0f;

    public Radio() {
        this.boton = new BotonOnOf();
        boton.off();
    }
    @Override
    public void on() {
        boton.on();
    }

    @Override
    public void off() {
        boton.off();
    }



    public void dial(float valor){
        this.dial=valor;
    }
    @Override
    public String toString() {
        return "Radio{" +
                "boton=" + boton +
                '}';
    }
}
