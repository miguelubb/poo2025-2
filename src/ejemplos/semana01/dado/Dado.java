package ejemplos.semana01.dado;

public class Dado {
    private byte cara;

    public Dado(){
        cara=1;
    }
    public byte getCara(){
        return cara;
    }
    public void lanzar(){
        cara=(byte)(Math.random()*6+1);
    }
}
