import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArchivoCSV {

    private static final String ARCHIVO = "jugadores.csv";

    private static List<Jugador> leerTodos() {
        List<Jugador> lista = new ArrayList<>();
        File file = new File(ARCHIVO);

        // Si es el primer inicio y el archivo no existe, no mostramos error
        if (!file.exists()) {
            return lista;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea = br.readLine(); // Saltar la cabecera "nombre,saldo"

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length >= 2) {
                    String nombre = datos[0].trim();
                    try {
                        int saldo = Integer.parseInt(datos[1].trim());
                        lista.add(new Jugador(nombre, saldo));
                    } catch (NumberFormatException e) {
                        // Ignorar líneas con formato inválido
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer " + ARCHIVO);
        }

        return lista;
    }

    public static Jugador cargarJugador(String nombreBuscado) {
        List<Jugador> jugadores = leerTodos();

        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(nombreBuscado)) {
                return j;
            }
        }

        // Si no existe, creamos un jugador nuevo con saldo inicial de 1000
        return new Jugador(nombreBuscado, 1000);
    }

    public static void guardarJugador(Jugador jugador) {
        List<Jugador> jugadores = leerTodos();
        boolean encontrado = false;

        for (Jugador j : jugadores) {
            if (j.getNombre().equalsIgnoreCase(jugador.getNombre())) {
                j.setSaldo(jugador.getSaldo());
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            jugadores.add(jugador);
        }

        try (FileWriter fw = new FileWriter(ARCHIVO)) {
            fw.write("nombre,saldo\n");

            for (Jugador j : jugadores) {
                fw.write(j.getNombre() + "," + j.getSaldo() + "\n");
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar la información en " + ARCHIVO);
        }
    }

    public static void mostrarRanking() {
        List<Jugador> jugadores = leerTodos();

        System.out.println("\n");
        System.out.println("                 ___________      ");
        System.out.println("                '._==_==_=_.'     ");
        System.out.println("                .-\\:      /-.    ");
        System.out.println("               | (|:.     |) |    ");
        System.out.println("                '-|:.     |-'     ");
        System.out.println("                  \\::.    /      ");
        System.out.println("                   '::. .'        ");
        System.out.println("                     ) (          ");
        System.out.println("                   _.' '._        ");
        System.out.println("                  `\"\"\"\"\"\"\"`       ");

        System.out.println("       ╔════════════════════════════════════╗");
        System.out.println("       ║        SALÓN DE LA FAMA            ║");
        System.out.println("       ╠════════════════════════════════════╣");

        if (jugadores.isEmpty()) {
            System.out.println("       ║      No hay jugadores aún.         ║");
            System.out.println("       ║    ¡Sé el primero en jugar!        ║");
        } else {
            // Ordenamos la lista de mayor a menor saldo gracias al Comparable en Jugador
            Collections.sort(jugadores);

            int limite = Math.min(jugadores.size(), 10); // Mostrar solo el Top 10

            for (int i = 0; i < limite; i++) {
                Jugador j = jugadores.get(i);
                
                String linea = "       ║ " + (i + 1) + ". " + j.getNombre() + " - $" + j.getSaldo();
                
                // Rellenar con espacios para que el borde derecho cuadre
                while (linea.length() < 43) {
                    linea += " ";
                }
                linea += "║";
                
                System.out.println(linea);
            }
        }

        System.out.println("       ╚════════════════════════════════════╝\n");
    }
}