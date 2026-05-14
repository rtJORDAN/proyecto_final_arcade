public class Jugador {

    String nombre;
    int saldo;

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
}