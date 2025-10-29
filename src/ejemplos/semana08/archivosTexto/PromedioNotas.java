package ejemplos.semana08.archivosTexto;

import java.io.*;
import java.util.Locale;
import java.util.Scanner;

public class PromedioNotas {
    public static void main(String[] args) {
        String filepath = "src/ejemplos/semana08/archivosTexto/data.txt";
        try {
            Scanner sc = new Scanner(new File(filepath));
            sc.useDelimiter("\r\n|; |[\r\n]");
            sc.useLocale(Locale.UK);
            while (sc.hasNextLine()) {
                String nombre=sc.next();
                String notas=sc.next();
                double prom = sc.nextDouble();
                double promCalculado = promedio(notas);
                System.out.println(nombre+"; "+notas+"; "+prom+"; "+promCalculado);
            }
        } catch (FileNotFoundException e) {

        }
    }

    private static double promedio(String notas) {
        String[] notasSplit=notas.split(",");
        double prom=0.0;
        for(String nota:notasSplit){
            prom+=Double.parseDouble(nota.strip());
        }
        return prom/notasSplit.length;
    }
}
