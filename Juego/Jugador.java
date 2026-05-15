public class Jugador implements Comparable<Jugador> {

    private String nombre;
    private int saldo;

    public Jugador(String nombre, int saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void sumarSaldo(int cantidad) {
        saldo = saldo + cantidad;
    }

    public void restarSaldo(int cantidad) {
        saldo = saldo - cantidad;
    }

    @Override
    public int compareTo(Jugador otro) {
        // Ordena de mayor a menor saldo
        return Integer.compare(otro.getSaldo(), this.saldo);
    }
}