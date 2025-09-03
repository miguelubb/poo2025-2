package ejemplos.semana02.colecciones;

import java.util.ArrayList;

public class EjemploArrayList {
    public static void main(String[] args) {
        //Lampara[] misLamparas = new Lampara[10];
        ArrayList<Lampara> misLamparas = new ArrayList<>();
        String[] marcas = {
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

        for (int i = 0; i < 10; i++) {
           // misLamparas[i] = new Lampara(marcas[i], potencias[i]);
            misLamparas.add(new Lampara(marcas[i], potencias[i]));
        }
        //imprimir todas las lámparas
        for (int i = 0; i < misLamparas.size(); i++) {
            //System.out.println(misLamparas[i]);
            System.out.println(misLamparas.get(i));
        }

        int encendidas = 0;
        for (int i = 0; i < misLamparas.size(); i++) {
            if (misLamparas.get(i).getEstado() == Estado.ENCENDIDA) {
                encendidas++;
            }
        }

        System.out.println("Hay " + encendidas + " lámparas encendidas.");

        int menorA80 = 0;
        for (int i = 0; i < misLamparas.size(); i++) {
            if (misLamparas.get(i).getPotencia() < 80) {
                menorA80++;
            }
        }
        System.out.println("Hay " + menorA80 + " lámparas con menos de 80 watts.");
    }
}
