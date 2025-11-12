package ejemplos.semana09.ejemploBasicoSerializacion;

import java.io.*;
import java.nio.file.*;

    /**
     * Clase genérica para lectura y escritura secuencial de objetos serializables.
     *
     * <p>Permite abrir un archivo en tres modos:
     * <ul>
     *     <li>{@code WRITE}: crea un nuevo archivo, sobrescribiendo si ya existe.</li>
     *     <li>{@code APPEND}: agrega objetos al final sin corromper el flujo binario.</li>
     *     <li>{@code READ}: lee los objetos secuencialmente hasta el fin de archivo.</li>
     * </ul>
     *
     * <p>Ejemplo de uso:
     * <pre>{@code
     * try (SequentialObjectFile<Contacto> out =
     *          new SequentialObjectFile<>("contactos.obj", Mode.APPEND)) {
     *     out.write(new Contacto(1, "Juan", "juan@ubb.cl", "+56 9 1111 1111"));
     * }
     *
     * try (SequentialObjectFile<Contacto> in =
     *          new SequentialObjectFile<>("contactos.obj", Mode.READ)) {
     *     Contacto c;
     *     while ((c = in.read()) != null) {
     *         System.out.println(c);
     *     }
     * }
     * }</pre>
     *
     * @param <T> tipo de objeto que implementa Serializable
     */
    public class SequentialObjectFile<T extends Serializable> implements AutoCloseable {

        /** Modo de apertura del archivo */
        public enum Mode { WRITE, APPEND, READ }

        private final Path path;
        private final Mode mode;
        private ObjectOutputStream oos;
        private ObjectInputStream ois;

        /**
         * Crea o abre un archivo secuencial de objetos.
         *
         * @param filename nombre del archivo
         * @param mode modo de apertura: WRITE, APPEND o READ
         * @throws IOException si ocurre un error de E/S
         */
        public SequentialObjectFile(String filename, Mode mode) throws IOException {
            this.path = Paths.get(filename);
            this.mode = mode;
            open();
        }

        /** Configura el flujo según el modo de apertura */
        private void open() throws IOException {
            switch (mode) {
                case WRITE -> {
                    // Crea un nuevo archivo y escribe cabecera
                    oos = new ObjectOutputStream(Files.newOutputStream(
                            path, StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING));
                }
                case APPEND -> {
                    boolean exists = Files.exists(path);
                    OutputStream os = Files.newOutputStream(path,
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                    // Si el archivo ya existía, no escribir cabecera
                    oos = exists ? new AppendableObjectOutputStream(os)
                            : new ObjectOutputStream(os);
                }
                case READ -> {
                    if (!Files.exists(path))
                        throw new FileNotFoundException("Archivo no encontrado: " + path);
                    ois = new ObjectInputStream(Files.newInputStream(path));
                }
            }
        }

        /**
         * Escribe un objeto en el archivo (modo WRITE o APPEND).
         *
         * @param obj objeto a escribir
         * @throws IOException si el archivo no está en modo escritura o hay un error de E/S
         */
        public void write(T obj) throws IOException {
            if (oos == null)
                throw new IllegalStateException("El archivo no está abierto en modo escritura.");
            oos.writeObject(obj);
        }

        /**
         * Lee el siguiente objeto del archivo o retorna {@code null} al llegar al final.
         *
         * @return siguiente objeto, o {@code null} si se alcanzó el fin del archivo
         */
        @SuppressWarnings("unchecked")
        public T read() {
            if (ois == null)
                throw new IllegalStateException("El archivo no está abierto en modo lectura.");
            try {
                return (T) ois.readObject();
            } catch (EOFException e) {
                return null; // fin de archivo
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException("Error al leer objeto: " + e.getMessage(), e);
            }
        }

        /** Cierra el flujo automáticamente (usado por try-with-resources). */
        @Override
        public void close() throws IOException {
            if (oos != null) oos.close();
            if (ois != null) ois.close();
        }

        /**
         * Subclase interna que omite la cabecera del flujo cuando el archivo ya existe.
         * Evita la corrupción del archivo al escribir en modo APPEND.
         */
        private static class AppendableObjectOutputStream extends ObjectOutputStream {
            public AppendableObjectOutputStream(OutputStream out) throws IOException {
                super(out);
            }
            @Override
            protected void writeStreamHeader() throws IOException {
                // Evita escribir una nueva cabecera en archivos existentes
                reset();
            }
        }
    }


