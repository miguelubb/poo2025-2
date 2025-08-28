package ejemplos.semana01.constantes_enumeraciones.estudiante;

public class Estudiante {
    private String rut;
    private String nombre;
    private String email;
    private EstadoEstudiante estado;

    public Estudiante(String rut, String nombre){
        this.rut=rut;
        this.nombre=nombre;
        email="-";
        estado=EstadoEstudiante.NO_VIGENTE;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public void setEstado(EstadoEstudiante estado){
        this.estado=estado;
    }
    public String toString(){
        return rut+", "+nombre+", "+email+", "+estado;
    }
    public String getNombre(){
        return nombre;
    }
    public boolean toEquals(Estudiante otro){
        return this.rut.equals(otro.rut);
    }

}
