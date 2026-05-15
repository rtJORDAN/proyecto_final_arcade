public class Main {

    public static void main(String[] args) {

        System.out.println("\n");
        System.out.println("     _   _   _  ___  _   __ __   _      __   ___  ___   __   ___   ___ ");
        System.out.println("    | | | | | |/ __|| | / / \\ \\ / /    /  \\ | _ \\/ __| /  \\ |   \\ | __|");
        System.out.println("    | |_| |_| | (__ | |/ /   \\ V /    | () ||   / (__ | () || |) || _| ");
        System.out.println("    |___|\\___/ \\___||_|\\_\\    |_|      \\__/ |_|_\\\\___| \\__/ |___/ |___|");
        System.out.println("\n");

        String nombre = ConsoleInput.leerTexto("  >> Ingresa tu nombre para comenzar: ");

        if (nombre.trim().isEmpty()) {
            nombre = "Jugador";
        }

        Jugador jugador = ArchivoCSV.cargarJugador(nombre);

        int opcion = 0;

        while (opcion != 4) {
            System.out.println("\n");
            System.out.println("        ╔════════════════════════════════╗");
            System.out.println("        ║        MENU PRINCIPAL          ║");
            System.out.println("        ╠════════════════════════════════╣");
            System.out.println("        ║                                ║");
            System.out.println("        ║   [1] Jugar Tragamonedas       ║");
            System.out.println("        ║   [2] Ver mi Saldo             ║");
            System.out.println("        ║   [3] Salón de la Fama         ║");
            System.out.println("        ║   [4] Salir y Guardar          ║");
            System.out.println("        ║                                ║");
            System.out.println("        ╚════════════════════════════════╝");

            opcion = ConsoleInput.leerEntero("  >> Seleccione una opción: ");

            if (opcion == 1) {
                Casino.jugar(jugador);
            } else if (opcion == 2) {
                System.out.println("\n  --------------------------------------");
                System.out.println("  [👤] Jugador: " + jugador.getNombre());
                System.out.println("  [💰] Saldo actual: $" + jugador.getSaldo());
                System.out.println("  --------------------------------------");
            } else if (opcion == 3) {
                ArchivoCSV.mostrarRanking();
            } else if (opcion == 4) {
                ArchivoCSV.guardarJugador(jugador);
                System.out.println("\n  ¡Datos guardados! Gracias por jugar en The Lucky Arcade.");
                System.out.println("  Vuelve pronto...");
            } else {
                System.out.println("  Opción inválida. Intente de nuevo.");
            }
        }
    }
}