package ejemplos.semana06.ejemploMVC.Farmacia.controlador;

import java.util.*;
import ejemplos.semana06.ejemploMVC.Farmacia.modelo.*;

//patron Singelton
public class ControladorFarmacia {
    private static ControladorFarmacia instance=null;
    private List<Laboratorio> laboratorios;
    private List<Medicamento> medicamentos;
    private ControladorFarmacia(){
        laboratorios=new ArrayList<>();
        medicamentos=new ArrayList<>();
    }
    public static ControladorFarmacia getInstance(){
        if(instance==null){
            instance=new ControladorFarmacia();
        }
        return instance;
    }

    public boolean creaMedicamento(String nombre, String tipo, int precio){
        Tipo[] tipos=Tipo.values();
        int t=-1;
        for (int i = 0; i < tipos.length; i++) {
            if(tipos[i].toString().equals((tipo.toUpperCase()))){
                t=i;
                break;
            }
        }
        if(t==-1){
            return false;
        }
        //Medicamento nuevo=new Medicamento(nombre, Tipo.valueOf(tipo.toUpperCase()), precio);
        Medicamento nuevo=new Medicamento(nombre, tipos[t], precio);
        if(medicamentos.contains(nuevo)){
            return false;
        }
        return medicamentos.add(nuevo);
    }
}
