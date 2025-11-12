package ejemplos.semana09.ejemploBasicoSerializacion;
import java.io.*;

public class TestSequentialObjectFile {
    public static void main(String[] args) throws IOException {
        // Escritura incremental
        try (SequentialObjectFile<Contacto> out =
                     new SequentialObjectFile<>("contactos.obj", SequentialObjectFile.Mode.APPEND)) {
            out.write(new Contacto(1, "Juan Segura", "juan@ubb.cl", "+56 9 1111 1111"));
            out.write(new Contacto(2, "Ana Zapata", "ana@ubb.cl", "+56 9 2222 2222"));
            out.write(new Contacto(3, "María Escalona", "maria@ubb.cl", "+56 9 3333 3333"));
        }

        // Lectura secuencial
        try (SequentialObjectFile<Contacto> in =
                     new SequentialObjectFile<>("contactos.obj", SequentialObjectFile.Mode.READ)) {
            Contacto c;
            System.out.println("Contactos leídos:");
            while ((c = in.read()) != null) {
                System.out.println(c);
            }
        }
    }
}
