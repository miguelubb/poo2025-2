package ejemplos.semana02.elementosEstaticos;

public class DemoMinibus {
    public static void main(String[] args) {
        Minibus A=new Minibus("AJ4536",24);
        Minibus B=new Minibus("GZ9812",20);

        System.out.printf("|%10s | %10s | %20s|%n","PATENTE","OCUPADOS", "ESTADO");
        System.out.println("================================================");
        System.out.printf("|%10s | %,10d | %20s|%n", A.getLicensePlate(), A.getOccupiedSeatsNumber(), A.getState());
        System.out.printf("|%10s | %,10d | %20s|%n",B.getLicensePlate(), B.getOccupiedSeatsNumber(), B.getState());
        System.out.print("Tomando 10 asientos del bus 1...");

        if(A.takeSeat(10)){
            System.out.println("éxito");
        }else{
            System.out.println("fracaso");
        }
        System.out.println("Cambiando el precio del pasaje a 480...");
        Minibus.setTiketValue(480);
        System.out.print("Devolviendo 5 asientos del segundo bus...");
        if(B.takeSeat(5)){
            System.out.println("éxito");
        }else{
            System.out.println("fracaso");
        }
        System.out.println("Dando de baja el bus 2...");
        B.setState(State.DECOMMISSIONED);
        System.out.print("Devolviendo 3 asientos del primer bus...");
        if(A.releaseSeat(3)){
            System.out.println("éxito");
        }else{
            System.out.println("fracaso");
        }

        System.out.println("Estado de los buses...");
        System.out.printf("%10s %10s %20s%n","PATENTE","OCUPADOS", "ESTADO");
        System.out.printf("%10s %10d %20s%n",A.getLicensePlate(), A.getOccupiedSeatsNumber(), A.getState());
        System.out.printf("%10s %10d %20s%n",B.getLicensePlate(), B.getOccupiedSeatsNumber(), B.getState());

        System.out.printf("%nValor del pasaje: $%,d%n",Minibus.getTiketValue());
    }
}
