package ejemplos.semana10.MVC_Serializacion.persistencia;

import ejemplos.semana10.MVC_Serializacion.modelo.Contacto;

import java.io.*;

public class IOContacto {
    private static IOContacto instance=new  IOContacto();
    public static IOContacto getInstance(){
        return instance;
    }
    private IOContacto(){}

    private final String filename="src/ejemplos/semana10/MVC_Serializacion/persistencia/contactos.obj";

    public void save(Contacto[] contactos){
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            out.writeInt(contactos.length);
            for (Contacto contacto : contactos) {
                out.writeObject(contacto);
            }
            // out.close(); se invoca automáticamente por el bloque try..catch en caso ok, o exception
        } catch (IOException e) {
            System.err.println("error de escritura: " + e.getMessage());
        }
    }


    public Contacto[] load(){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            int length = in.readInt();
            Contacto[] contactos = new Contacto[length];
            for (int i = 0; i < length; i++) {
                contactos[i]=(Contacto)in.readObject();
            }
            return contactos;
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("error de lectura: " + e.getMessage());
        }
        return new Contacto[0];
    }
}
