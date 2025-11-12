package ejemplos.semana09.ejemploBasicoSerializacion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOContactos {
    private String filename;

    public IOContactos() {
        filename = "contactos.obj";
    }

    public IOContactos(String filename) {
        this.filename = filename;
    }

    public void saveContacto(Contacto contacto) {
        //serializamos el objeto.
        File file = new File(filename);
        //Crea el archivo si no existe, o lo abre para escritura al final (append mode)
        //try de recurso, cierra automáticamente oug
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file, file.exists()))) {
            out.writeObject(contacto);
            // out.close(); se invoca automáticamente por el bloque try..catch en caso ok, o exception
        } catch (IOException e) {
            System.err.println("error de escritura: " + e.getMessage());
        }
    }

    public Contacto readContacto(int id) {
        File file = new File(filename);
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    Contacto c = (Contacto) in.readObject();
                    if (c.getId() == id) {
                        return c;
                    }
                } catch (EOFException e) {
                    break; // fin de archivo, termina el while(true)
                } catch (ClassNotFoundException e) {
                    System.err.println("error de lectura del objeto: " + e.getMessage());
                    //nos saltamos los objetos que no se pueden leer por que no corresponde con la clase.
                }
            }
            // out.close(); se invoca automáticamente por el bloque try..catch en caso ok, o exception
        } catch (IOException e) {
            System.err.println("error de lectura: " + e.getMessage());
        }
        return null;
    }

    public void saveContactos(List<Contacto> contactos) {
        //guardo de uno en uno
        for (Contacto contacto : contactos) {
            saveContacto(contacto);
        }
    }

    //Lee todos los contactos del archivo y los retorna en una lista.
    public List<Contacto> readContactos() {
        List<Contacto> contactos = new ArrayList<>();
        //leer uno a uno los objetos contactos y los voy a almacenar dentro de la lista de contactos.
        File file = new File(filename);
        try (ObjectInput in = new ObjectInputStream(new FileInputStream(file))) {
            while (true) {
                try {
                    contactos.add((Contacto) in.readObject());
                } catch (EOFException e) {
                    break; // fin de archivo
                }
            }
            // out.close(); se invoca automáticamente por el bloque try..catch en caso ok, o exception
        } catch (StreamCorruptedException e) {
            //cuando se termina la lectura en while true;
            return contactos;
        } catch (IOException e) {
            System.err.println("error I/O: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return contactos;
    }
}
