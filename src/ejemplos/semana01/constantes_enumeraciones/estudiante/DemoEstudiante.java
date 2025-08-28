package ejemplos.semana01.constantes_enumeraciones.estudiante;

import java.util.Scanner;

public class DemoEstudiante {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Estudiante laura=new Estudiante("11.111.111-1",
                "Laura Diaz");
        System.out.println(laura);
        System.out.println("Ingrese un estado para el estudiante:");
        //se podría hacer con un menú de los estados, el usuario selecciona
        //un estado del menú (un número) y luego con un switch se guarda el estado apropiado
        String nuevoEstado=sc.next();
        laura.setEstado(EstadoEstudiante.valueOf(nuevoEstado.toUpperCase()));
        System.out.println(laura);

        /*Estudiante pepe=new Estudiante("11.111.111-1", "José");
        Estudiante juan=new Estudiante("22.222.222-2", "Juan");
        System.out.println(pepe);
        System.out.println(juan);
        System.out.println("asignando email a estudiantes");
        pepe.setEmail("pepe@alumnos.ubiobio.cl");
        juan.setEmail("juan@alumnos.ubiobio.cl");
        System.out.println(pepe);
        System.out.println(juan);
        System.out.println("comparando los estudiantes si son iguales");
        if(pepe.toEquals(juan)){
            System.out.println("son iguales");
        }else{
            System.out.println("son distintos");
        }*/
    }
}
