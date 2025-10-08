package ejemplos.semana05.interfaces;

import java.util.ArrayList;
import java.util.List;

public class TestInterfaces {
    public static void main(String[] args) {
        BotonOnOf bt=new BotonOnOf();
        System.out.println(bt);

        ArrayList<OnOf> lista=new ArrayList<>();
        lista.add(new Radio());
        lista.add(new Radio());
        lista.add(new AireAcondicionado());
        lista.add(new AireAcondicionado());
        for (OnOf a:lista) {
            a.on();
            System.out.println(a);
            System.out.println(a.estado());
        }



        OnOf o= new OnOf() {
            int estado=0;
            @Override
            public void on() {
                estado=1;
            }

            @Override
            public void off() {
                estado=0;
            }
        };
        o.off();
        o.on();
    }


}
