package ejemplos.semana11.ejemploBasicoStreams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class EjemploIntStreams {
    static void main() {
        int[] valores = {11, 12, 13, 14, 1, 6, 7, 8, 9, 2, 3, 4, 5, 10, 15, 16, 17, 18, 19, 20};
        System.out.println("Todos los valores:");
        IntStream.of(valores)
                .forEach(val -> System.out.printf("%d ", val));
        System.out.println("\nSolo los pares");
        IntStream.of(valores)
                .filter(val -> val % 2 == 0)
                .sorted()
                .forEach(val -> System.out.printf("%d ", val));
        System.out.println("\nSolo los impares");
        IntStream.of(valores)
                .filter(val -> val % 2 != 0)
                .forEach(val -> System.out.printf("%d ", val));
        System.out.print("\nsumar impares: ");
        int suma = IntStream.of(valores)
                .filter(val -> val % 2 != 0)
                .sum();
        System.out.println(suma);
        System.out.print("Suma de valores mediante reduce: ");
        int suma2 = IntStream.of(valores)
                .filter(val -> val % 2 != 0)
                .reduce((a, b) -> a + b).getAsInt();
                //a es el valor acumulado, b es el valor del streaming
        //con valor inicial 0 (valor de identidad) no devuelve un Optional dado que hay un valor inicial.
        int suma3 = IntStream.of(valores)
                .filter(val -> val % 2 != 0)
                .reduce(0, (a, b) -> a + b);

        System.out.println(suma2 + "=" + suma3);


        int min = IntStream.of(valores)
                .filter(val -> val % 2 != 0)
                .reduce(Integer.MAX_VALUE, (acum, b) -> Math.min(acum,b));
        System.out.println(min);
        min = IntStream.of(valores)
                .filter(val -> val % 2 != 0)
                .min().getAsInt();
        System.out.println(min);


        int suma4 = IntStream.of(valores)
                .filter(val -> val % 2 != 0)
                .sum();

        List<Integer> numeros = List.of(1, 2, 3, 4, 5);
        numeros.stream()
                .filter(n -> {
                    System.out.println(" filter " + n);
                    return n % 2 == 0; // pares
                })
                .map(n -> {
                    System.out.println(" map " + n);
                    return n * 10;
                })
                .findFirst();

        for (Integer numero : numeros) { //.stream()
            if (numero % 2 == 0) { //.filter
                numero = numero * 10; //.map()
                break; //.findFirst()
            }

        }

        //
        int numero = IntStream.range(1, 800)
                .filter(n -> n % 7 == 0)
                .findFirst().orElse(-1);
        System.out.println("Primer múltiplo de 7"+numero);

        numero = IntStream.range(1, 800)
                .parallel()
                .filter(n -> n % 7 == 0)
                .findAny().orElse(-1);
        System.out.println("Primer múltiplo de 7 encontrado por un hilo paralelo: "+numero);
    }
}
