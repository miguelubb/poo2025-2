package ejemplos.semana07.excepcionesBasico;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EjemploExcepciones {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el divisor y el dividendo");
        int divisor = 1, dividendo = 1;
        try {
            divisor = sc.nextInt();
            dividendo = sc.nextInt();
            System.out.println(divisor + "/" + dividendo + "=" + (divisor / dividendo));
        } catch (InputMismatchException e) {
            System.out.println("Error los datos ingresados no son núméricos");
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println("El dividendo no puede ser 0");
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Error desconocido al dividir");
            System.out.println(e.getMessage());
        }

    }
}
