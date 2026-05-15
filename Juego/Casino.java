public class Casino {

    static String[] simbolos = {"7", "$", "X", "*", "#", "@"};

    public static void jugar(Jugador jugador) {
        mostrarTitulo();
        System.out.println("\n                Jugador: " + jugador.getNombre());
        System.out.println("                Saldo actual: $" + jugador.getSaldo());

        int apuesta = ConsoleInput.leerEntero("\n                Ingrese apuesta: $");

        if (apuesta <= 0) {
            System.out.println("                La apuesta debe ser mayor que 0.");
            return;
        }

        if (apuesta > jugador.getSaldo()) {
            System.out.println("                No tienes saldo suficiente.");
            return;
        }

        boolean amuletoActivo = activarAmuleto(jugador, apuesta);

        if (amuletoActivo) {
            mostrarAmuleto();
        }

        jugador.restarSaldo(apuesta);

        System.out.println("\n                Girando tragamonedas...");
        animacionGiro();

        String[][] matriz;
        if (amuletoActivo) {
            matriz = generarMatrizConAmuleto();
        } else {
            matriz = generarMatriz();
        }

        System.out.println("\n                Resultado final:");
        mostrarMatriz(matriz);

        int premio = calcularPremio(matriz, apuesta);

        if (amuletoActivo && premio > 0) {
            premio = premio * 2;
            System.out.println("\n                ¡El amuleto DUPLICÓ tu premio!");
        }

        if (premio > 0) {
            mostrarVictoria(premio);
            jugador.sumarSaldo(premio);
        } else {
            mostrarDerrota();
        }

        System.out.println("\n                Saldo actualizado: $" + jugador.getSaldo());
        ArchivoCSV.guardarJugador(jugador);
    }

    public static boolean activarAmuleto(Jugador jugador, int apuesta) {
        return jugador.getNombre().equalsIgnoreCase("LUCKY") || apuesta == 777;
    }

    public static void mostrarAmuleto() {
        System.out.println("\n                   _");
        System.out.println("                 _(_)_");
        System.out.println("                (_)@(_)");
        System.out.println("                  (_)\\");
        System.out.println("                      \\");
        System.out.println("          ╔════════════════════════╗");
        System.out.println("          ║    AMULETO ACTIVADO    ║");
        System.out.println("          ║   PREMIO GARANTIZADO   ║");
        System.out.println("          ╚════════════════════════╝");
    }

    public static void mostrarVictoria(int premio) {
        System.out.println("\n");
        System.out.println("                  ___________ ");
        System.out.println("                 '._==_==_=_.'");
        System.out.println("                 .-\\:      /-.");
        System.out.println("                | (|:.     |) |");
        System.out.println("                 '-|:.     |-'");
        System.out.println("                   \\::.    / ");
        System.out.println("                    '::. .'  ");
        System.out.println("                      ) (    ");
        System.out.println("                    _.' '._  ");
        System.out.println("                   `\"\"\"\"\"\"\"` ");
        System.out.println("          ╔════════════════════════╗");
        System.out.println("          ║      ¡ GANASTE !       ║");
        System.out.println("          ║      Premio: $" + premio);
        System.out.println("          ╚════════════════════════╝");
    }

    public static void mostrarDerrota() {
        System.out.println("\n");
        System.out.println("                   .---. ");
        System.out.println("                  /     \\");
        System.out.println("                 | () () |");
        System.out.println("                  \\  ^  / ");
        System.out.println("                   ||||| ");
        System.out.println("                   ||||| ");
        System.out.println("          ╔════════════════════════╗");
        System.out.println("          ║     SIN PREMIO...      ║");
        System.out.println("          ║  Mejor suerte la prox  ║");
        System.out.println("          ╚════════════════════════╝");
    }

    public static void mostrarTitulo() {
        System.out.println("\n");
        System.out.println("  ___________.__             .____                 __           ");
        System.out.println("  \\__    ___/|  |__   ____   |    |    __ __  ____ |  | _____.__.");
        System.out.println("    |    |   |  |  \\_/ __ \\  |    |   |  |  \\/ ___\\|  |/ <   |  |");
        System.out.println("    |    |   |   Y  \\  ___/  |    |___|  |  \\  \\___|    < \\___  |");
        System.out.println("    |____|   |___|  /\\___  > |_______ \\____/ \\___  >__|_ \\/ ____|");
        System.out.println("                  \\/     \\/          \\/          \\/     \\/\\/     ");
        System.out.println("     _____                               .___       ");
        System.out.println("    /  _  \\_______  ____ _____     ____  |   | ____ ");
        System.out.println("   /  /_\\  \\_  __ \\/ ___\\\\__  \\  _/ ___\\ |   |/ __ \\");
        System.out.println("  /    |    \\  | \\/\\  \\___ / __ \\_\\  \\___ |   \\  ___/");
        System.out.println("  \\____|__  /__|    \\___  >____  /\\___  >|___|\\___  >");
        System.out.println("          \\/            \\/     \\/     \\/          \\/ ");
        System.out.println("                                                            (Slots 3x3)");
    }

    public static void animacionGiro() {
        for (int i = 0; i < 6; i++) {
            String[][] temporal = generarMatriz();
            mostrarMatriz(temporal);
            esperar();
        }
    }

    public static void esperar() {
        try {
            Thread.sleep(300);
        } catch (Exception e) {
            System.out.println("Error en la animación.");
        }
    }

    public static String[][] generarMatriz() {
        String[][] matriz = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int posicion = (int)(Math.random() * simbolos.length);
                matriz[i][j] = simbolos[posicion];
            }
        }
        return matriz;
    }

    public static String[][] generarMatrizConAmuleto() {
        String[][] matriz = generarMatriz();
        int filaGanadora = (int)(Math.random() * 3);
        int simboloGanador = (int)(Math.random() * simbolos.length);

        matriz[filaGanadora][0] = simbolos[simboloGanador];
        matriz[filaGanadora][1] = simbolos[simboloGanador];
        matriz[filaGanadora][2] = simbolos[simboloGanador];
        return matriz;
    }

    public static void mostrarMatriz(String[][] matriz) {
        System.out.println();
        System.out.println("               ._________________________.");
        System.out.println("               | _______________________ |");
        System.out.println("               | I  " + matriz[0][0] + "  |  " + matriz[0][1] + "  |  " + matriz[0][2] + "  I | ( )");
        System.out.println("               | I_____|_____|_____I |  | ");
        System.out.println("               | I  " + matriz[1][0] + "  |  " + matriz[1][1] + "  |  " + matriz[1][2] + "  I |  | ");
        System.out.println("               | I_____|_____|_____I |  | ");
        System.out.println("               | I  " + matriz[2][0] + "  |  " + matriz[2][1] + "  |  " + matriz[2][2] + "  I |  | ");
        System.out.println("               | I_____|_____|_____I |  O ");
        System.out.println("               |_________________________|");
        System.out.println("                   [__]           [__]    ");
    }

    public static int calcularPremio(String[][] matriz, int apuesta) {
        int premioTotal = 0;

        // Revisar filas
        for (int i = 0; i < 3; i++) {
            if (matriz[i][0].equals(matriz[i][1]) && matriz[i][1].equals(matriz[i][2])) {
                premioTotal += apuesta * obtenerMultiplicador(matriz[i][0]);
            }
        }

        // Revisar diagonales
        if (matriz[0][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][2])) {
            premioTotal += apuesta * obtenerMultiplicador(matriz[0][0]);
        }

        if (matriz[0][2].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][0])) {
            premioTotal += apuesta * obtenerMultiplicador(matriz[0][2]);
        }

        return premioTotal;
    }
    
    private static int obtenerMultiplicador(String simbolo) {
        switch (simbolo) {
            case "7": return 10;
            case "$": return 8;
            case "X": return 5;
            case "*": return 3;
            case "#": return 2;
            case "@": return 1;
            default: return 1;
        }
    }
}