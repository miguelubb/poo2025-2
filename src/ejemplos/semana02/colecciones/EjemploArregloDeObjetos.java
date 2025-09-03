package ejemplos.semana02.colecciones;

public class EjemploArregloDeObjetos {
    public static void main(String[] args) {
        Lampara[] misLamparas=new Lampara[10];
        String[] marcas={
                "Philips",
                "Osram",
                "GE Lighting",
                "Sylvania",
                "Panasonic",
                "Cree",
                "Feit Electric",
                "TCP",
                "Havells",
                "NVC Lighting"
        };
        int[] potencias = {
                15,
                25,
                40,
                60,
                75,
                100,
                150,
                200,
                250,
                500
        };
        for (int i = 0; i < misLamparas.length; i++) {
            misLamparas[i]=new Lampara(marcas[i],potencias[i]);
        }
        for (int i = 0; i < misLamparas.length; i++) {
            System.out.println(misLamparas[i]);
        }
        int encendidas=0;
        for (int i = 0; i < misLamparas.length; i++) {
            if(misLamparas[i].getEstado()==Estado.ENCENDIDA){
                encendidas++;
            }
        }
        System.out.println("Hay "+ encendidas + " lámparas encendidas.");
        int menorA80=0;
        for (int i = 0; i < misLamparas.length; i++) {
            if(misLamparas[i].getPotencia()<80){
                menorA80++;
            }
        }
        System.out.println("Hay "+ menorA80 +" lámparas con menos de 80 watts.");
    }
}
