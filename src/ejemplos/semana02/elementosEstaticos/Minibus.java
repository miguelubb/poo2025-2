package ejemplos.semana02.elementosEstaticos;

public class Minibus {
    private String licensePlate;
    private int seatsNumber;
    private int occupiedSeatsNumber;
    private State state;
    private static int tiketValue = 500;

    public Minibus(String licensePlate, int seatsNumber) {
        this.licensePlate = licensePlate;
        this.seatsNumber = seatsNumber;
        occupiedSeatsNumber = 0;
        state = State.IN_SERVICE;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public int getOccupiedSeatsNumber() {
        return occupiedSeatsNumber;
    }

    public State getState() {
        return state;
    }

    public static int getTiketValue() {
        return tiketValue;
    }

    public static void setTiketValue(int tiketValue) {
        Minibus.tiketValue = tiketValue;
    }

    public void setState(State state) {
        this.state = state;
        if (state != State.IN_SERVICE) {
            occupiedSeatsNumber = 0;
        }
    }

    public boolean takeSeat(int seats) {
        int available = seatsNumber - occupiedSeatsNumber;
        if (state == State.IN_SERVICE && seats <= available) {
            occupiedSeatsNumber += seats;
            return true;
        }
        return false;
    }

    public boolean releaseSeat(int seats) {
        if (state == State.IN_SERVICE && seats <= tiketValue) {
            occupiedSeatsNumber -= seats;
            return true;
        }
        return false;
    }
}
