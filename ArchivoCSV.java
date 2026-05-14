import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoCSV {

    public static Jugador cargarJugador(String nombreBuscado) {

        try {
            BufferedReader br = new BufferedReader(new FileReader("jugadores.csv"));
            String linea = br.readLine();

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length >= 2) {
                    String nombre = datos[0].trim();
                    int saldo = Integer.parseInt(datos[1].trim());

                    if (nombre.equalsIgnoreCase(nombreBuscado)) {
                        br.close();
                        return new Jugador(nombre, saldo);
                    }
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No se pudo leer jugadores.csv.");
        }

        return new Jugador(nombreBuscado, 1000);
    }

    public static void guardarJugador(Jugador jugador) {

        String[] nombres = new String[100];
        int[] saldos = new int[100];
        int contador = 0;
        boolean encontrado = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader("jugadores.csv"));
            String linea = br.readLine();

            while ((linea = br.readLine()) != null && contador < 100) {
                String[] datos = linea.split(",");

                if (datos.length >= 2) {
                    nombres[contador] = datos[0].trim();
                    saldos[contador] = Integer.parseInt(datos[1].trim());

                    if (nombres[contador].equalsIgnoreCase(jugador.getNombre())) {
                        saldos[contador] = jugador.getSaldo();
                        encontrado = true;
                    }

                    contador++;
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No se pudo leer jugadores.csv para actualizar.");
        }

        if (!encontrado && contador < 100) {
            nombres[contador] = jugador.getNombre();
            saldos[contador] = jugador.getSaldo();
            contador++;
        }

        try {
            FileWriter fw = new FileWriter("jugadores.csv");

            fw.write("nombre,saldo\n");

            for (int i = 0; i < contador; i++) {
                fw.write(nombres[i] + "," + saldos[i] + "\n");
            }

            fw.close();

        } catch (IOException e) {
            System.out.println("No se pudo guardar jugadores.csv.");
        }
    }

    public static void mostrarRanking() {

        String[] nombres = new String[100];
        int[] saldos = new int[100];
        int contador = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader("jugadores.csv"));
            String linea = br.readLine();

            while ((linea = br.readLine()) != null && contador < 100) {
                String[] datos = linea.split(",");

                if (datos.length >= 2) {
                    nombres[contador] = datos[0].trim();
                    saldos[contador] = Integer.parseInt(datos[1].trim());
                    contador++;
                }
            }

            br.close();

        } catch (IOException e) {
            System.out.println("No se pudo leer el ranking.");
            return;
        }

        for (int i = 0; i < contador - 1; i++) {
            for (int j = 0; j < contador - 1 - i; j++) {
                if (saldos[j] < saldos[j + 1]) {

                    int tempSaldo = saldos[j];
                    saldos[j] = saldos[j + 1];
                    saldos[j + 1] = tempSaldo;

                    String tempNombre = nombres[j];
                    nombres[j] = nombres[j + 1];
                    nombres[j + 1] = tempNombre;
                }
            }
        }

        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║              RANKING               ║");
        System.out.println("╠════════════════════════════════════╣");

        if (contador == 0) {
            System.out.println("║      No hay jugadores aún          ║");
        } else {
            for (int i = 0; i < contador; i++) {
                String linea = "║ " + (i + 1) + ". " + nombres[i] + " - $" + saldos[i];

                while (linea.length() < 37) {
                    linea = linea + " ";
                }

                linea = linea + "║";
                System.out.println(linea);
            }
        }

        System.out.println("╚════════════════════════════════════╝");
    }
}