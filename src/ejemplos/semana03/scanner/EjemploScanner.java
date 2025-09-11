package ejemplos.semana03.scanner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class EjemploScanner {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        String f = now.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        System.out.println("Fecha de hoy: " + f);
        //Juan Riquielme; 35; juan.riquelme@ubiobio.cl;Cálculo, Aalgebra, POO
        //Ana Garrido; 33; ana.garrido@ubiobio.cl;POO, Cálculo
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(";|\r\n|[\n\r\u2028\u2029\u0085]");
        System.out.println("Ingrese los datos por fila de dos personas siguiendo el ejemplo:");
        System.out.println("Ejemplo: Juan Riquielme; 35; juan.riquelme@ubiobio.cl;Cálculo, Aalgebra, POO ");
        for (int i = 0; i < 2; i++) {
            String nombre = sc.next().trim();
            int edad = Integer.parseInt(sc.next().trim());
            String correo = sc.next().trim();
            String[] asignaturas = sc.next().split(",");
            System.out.println(nombre);
            System.out.println(edad);
            System.out.println(correo);
            System.out.println(Arrays.toString(asignaturas));
        }


    }
}
