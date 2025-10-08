package controles.control1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class ClinicaVetApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\r\n|[\t;\n\r\u2028\u2029\u0085]");
        List<Mascota> mascotas = new ArrayList<>();
        System.out.println("Ingrese el total de mascotas a ingresar:");
        int n = sc.nextInt();
        String nombre, tipo, sexo;
        int edad;
        float peso;
        for (int i = 0; i < n; i++) {
            System.out.print("Nombre: ");
            nombre = sc.next();
            System.out.print("Edad:");
            edad = sc.nextInt();
            System.out.print("Peso:");
            peso = sc.nextFloat();
            System.out.println("Tipo:");
            tipo = sc.next();
            System.out.print("Sexo:");
            sexo = sc.next();
            Mascota nueva = new Mascota(nombre, edad, peso, Sexo.valueOf(sexo), TipoMascota.valueOf(tipo));
            mascotas.add(nueva);
        }
        int cont = 0;
        for (Mascota mascota : mascotas) {
            if (!mascota.esAdulto()) {
                cont++;
            }
        }
        System.out.println("Mascotas adultas: " + Mascota.getNroMachosAdultos());
        System.out.println("Mascotas no adultas: " + cont);
        int mlTotal = 0;
        for (Mascota mascota : mascotas) {
            mlTotal += mascota.calculaDosisVacuna();
        }
        int frascos = (int) (Math.ceil(mlTotal / 10.0));
        System.out.println("Total de frascos de 10ml: " + frascos);
        LocalDate fechaActual = LocalDate.now();
        String fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy").format(fechaActual);
        System.out.println("Listado de mascotas --- fecha: " + fecha);
        System.out.println("nombre, edad, peso, tipo, sexo");
        for (Mascota mascota : mascotas) {
            System.out.println(mascota);
        }
    }
}
