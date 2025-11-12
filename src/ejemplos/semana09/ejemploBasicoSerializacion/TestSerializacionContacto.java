package ejemplos.semana09.ejemploBasicoSerializacion;

public class TestSerializacionContacto {
    public static void main(String[] args) {
        //aquí se cran contactos y se guardan en disco.
        Contacto juan=new Contacto(1, "Juan Segura", "juan.segura@ubb.cl", "+56 9 1111 1111");
        Contacto ana= new Contacto(2, "Ana Zapata", "ana.zapata@ubb.cl", "+56 9 2222 2222");
        Contacto maria= new Contacto(3, "María Escalona", "maria.escalona@ubb.cl", "+56 9 3333 3333");
        //IOContacto no es singleton, debo crearlo
        IOContactos ioContacto = new IOContactos();
        System.out.println("Mis contactos");
        System.out.println(juan);
        System.out.println(ana);
        System.out.println(maria);
        //guardando los contactos.
        ioContacto.saveContacto(juan);
        ioContacto.saveContacto(ana);
        ioContacto.saveContacto(maria);
        //simular que apago el compudar...
        juan=null;
        ana=null;
        maria=null;
        //leyendo los contactos del disco
        juan=ioContacto.readContacto(1);
        ana=ioContacto.readContacto(2);
        maria=ioContacto.readContacto(3);
        System.out.println("Mis contactos");
        System.out.println(juan);
        //la ectura de estos objetos da null, null.
        //esto porque cada vez que se abre para escritura un archivo de objetos, guarda una cabecera al inicio.
        //si se abre de modo append, pone la cabecera en cada apertura. Por eso falla.
        System.out.println(ana);
        System.out.println(maria);


    }
}
