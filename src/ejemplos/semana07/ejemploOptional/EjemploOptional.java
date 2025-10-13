package ejemplos.semana07.ejemploOptional;
import java.util.*;
public class EjemploOptional {
    private static List<User> users = new ArrayList<>();
    private static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        users.add(new User("admin", "admin"));
        users.add(new User("juan", "12345"));
        users.add(new User("ana", "qwety"));
        System.out.println("Bienvenido al sistema");
        System.out.print("user:");
        String username=sc.next();
        System.out.print("password:");
        //como podríamos leer la contraseña sin mostrala en pantalla?
        String password=sc.next();
        Optional<User> user = findByUserName(username);

        if (user.isPresent()) {
            if(user.get().getPwd().equals(password)) {
                System.out.println("hola " + user.get().getName() + ", Bienvenido al sistema!");
            }else{
                System.out.println("Contraseña incorrecta!");
            }
        }else{
            System.out.println("nombre de usuario incorrecto o no existe");
        }

        //otra forma sin usar isPresent()
        //el método orElse retorna el objeto del Optional o bien
        //el objeto que se pasa el método orElse
        User emptyUsr=new User("","");
        if(user.orElse(emptyUsr).getPwd().equals(password)) {
            System.out.println("hola " + user.get().getName() + ", Bienvenido al sistema!");
        }else{
            System.out.println("Usuario o Contraseña incorrecta!");
        }

    }

    private static Optional<User> findByUserName(String username) {
        for (User user : users) {
            if(user.getName().equals(username)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}
