public class Main {

    public static void main(String[] args) {

        System.out.println("╔════════════════════════════╗");
        System.out.println("║      THE LUCKY ARCADE      ║");
        System.out.println("╚════════════════════════════╝");

        String nombre = ConsoleInput.leerTexto("Ingresa tu nombre: ");

        if (nombre.trim().isEmpty()) {
            nombre = "Jugador";
        }

        Jugador jugador = ArchivoCSV.cargarJugador(nombre);

        int opcion = 0;

        while (opcion != 4) {

            System.out.println("\n╔════════════════════════════╗");
            System.out.println("║            MENÚ            ║");
            System.out.println("╠════════════════════════════╣");
            System.out.println("║ 1. Jugar tragamonedas      ║");
            System.out.println("║ 2. Ver saldo               ║");
            System.out.println("║ 3. Ranking                 ║");
            System.out.println("║ 4. Salir                   ║");
            System.out.println("╚════════════════════════════╝");

            opcion = ConsoleInput.leerEntero("Seleccione una opción: ");

            if (opcion == 1) {
                Casino.jugar(jugador);
            } else if (opcion == 2) {
                System.out.println("\nJugador: " + jugador.getNombre());
                System.out.println("Saldo: " + jugador.getSaldo());
            } else if (opcion == 3) {
                ArchivoCSV.mostrarRanking();
            } else if (opcion == 4) {
                ArchivoCSV.guardarJugador(jugador);
                System.out.println("\nDatos guardados. Gracias por jugar.");
            } else {
                System.out.println("Opción inválida.");
            }
        }
    }
}