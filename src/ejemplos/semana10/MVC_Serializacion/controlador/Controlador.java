package ejemplos.semana10.MVC_Serializacion.controlador;
import ejemplos.semana10.MVC_Serializacion.modelo.Contacto;
import ejemplos.semana10.MVC_Serializacion.persistencia.IOContacto;
import java.util.ArrayList;

public class Controlador {
    private static Controlador instancia=new Controlador();
    private Controlador(){}

    public static Controlador getInstancia() {
        return instancia;
    }

    private ArrayList<Contacto> contactos=new ArrayList();

    public boolean agregarContacto(int id, String nombre, String email, String telefono) {
        Contacto  contacto=new Contacto(id, nombre, email, telefono);
        if(!contactos.contains(contacto)){
            return contactos.add(contacto);
        }else{
            return false;
        }
    }
    public boolean eliminarContacto(int id){
        Contacto c=findByID(id);
        if(c!=null){
            return contactos.remove(c);
        }
        return false;
    }

    public boolean modificarContacto(int id, String nombre, String email, String telefono){
        Contacto c=findByID(id);
        if(c==null){
            return false;
        }
        //el id nunca cambia!
        //c es una referencia la objeto que está en la lista
        c.setNombre(nombre);
        c.setEmail(email);
        c.setTelefono(telefono);
        return true;
    }
    private Contacto findByID(int id) {
        for (Contacto contacto : contactos) {
            if(contacto.getId()==id){
                return contacto;
            }
        }
        return null;
    }
    public String[] buscarContacto(int id){
        Contacto c=findByID(id);
        if(c!=null){
            return c.toStringArray();
        }
        return new String[]{"","","",""};
    }
    public void save(){
        IOContacto.getInstance().save(contactos.toArray(new Contacto[contactos.size()]));
    }
    public void load(){
        Contacto[] contactos_input=IOContacto.getInstance().load();
        contactos.clear();
        for(Contacto contacto:contactos_input){
            contactos.add(contacto);
        }
    }
    public String[][] listadoContactos(){
        String[][] resultado=new String[contactos.size()][];
        for(Contacto contacto:contactos){
            resultado[0]=contacto.toStringArray();
        }
        return resultado;
    }
}
