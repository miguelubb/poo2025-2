package ejemplos.semana05.interfaces;

public interface OnOf {

    void on();
    void off();

    default String estado(){
        return "indefinido";
    }
}
