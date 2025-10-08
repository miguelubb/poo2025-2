package controles.control1;

public class Mascota {
    private String nombre;
    private int edad;
    private float peso;
    private TipoMascota tipo;
    private Sexo sexo;

    private static int nroMachosAdultos=0;

    public Mascota(String nombre, int edad, float peso, Sexo sexo, TipoMascota tipo) {
        this.nombre = nombre;
        this.edad = edad;
        this.peso = peso;
        this.sexo = sexo;
        this.tipo = tipo;
        if (esAdulto()){
            nroMachosAdultos++;
        }
    }
    public boolean esAdulto(){
        return switch(tipo){
            case AVE -> edad >=2;
            case PERRO -> edad >= 2;
            case GATO -> edad >= 1;
            case REPTIL -> edad >= 5;
        };
    }

    public float calculaDosisVacuna(){
        return peso * switch (tipo){
            case PERRO -> 5.0f;
            case GATO -> 4.0f;
            case AVE -> 1.0f;
            case REPTIL -> 0.5f;
        };
    }

    public String toString(){
        return nombre+", "+edad+", "+peso+", "+sexo+", "+tipo;
    }

    public static int getNroMachosAdultos(){
        return nroMachosAdultos;
    }

}
