public class Casino {

    static String[] simbolos = {"7", "$", "X", "*", "#", "@"};

    public static void jugar(Jugador jugador) {

        mostrarTitulo();

        System.out.println("Jugador: " + jugador.getNombre());
        System.out.println("Saldo actual: $" + jugador.getSaldo());

        int apuesta = ConsoleInput.leerEntero("\nIngrese apuesta: $");

        if (apuesta <= 0) {
            System.out.println("La apuesta debe ser mayor que 0.");
            return;
        }

        if (apuesta > jugador.getSaldo()) {
            System.out.println("No tienes saldo suficiente.");
            return;
        }

        boolean amuletoActivo = activarAmuleto(jugador, apuesta);

        if (amuletoActivo) {
            mostrarAmuleto();
        }

        jugador.restarSaldo(apuesta);

        System.out.println("\nGirando tragamonedas...");
        animacionGiro();

        String[][] matriz;

        if (amuletoActivo) {
            matriz = generarMatrizConAmuleto();
        } else {
            matriz = generarMatriz();
        }

        System.out.println("\nResultado final:");
        mostrarMatriz(matriz);

        int premio = calcularPremio(matriz, apuesta);

        if (amuletoActivo && premio > 0) {
            premio = premio * 2;
            System.out.println("\nEl amuleto duplicó tu premio.");
        }

        if (premio > 0) {
            System.out.println("\n╔════════════════════════════╗");
            System.out.println("║          ¡GANASTE!         ║");
            System.out.println("╚════════════════════════════╝");
            System.out.println("Premio ganado: $" + premio);
            jugador.sumarSaldo(premio);
        } else {
            System.out.println("\n╔════════════════════════════╗");
            System.out.println("║        SIN PREMIO          ║");
            System.out.println("╚════════════════════════════╝");
            System.out.println("Mejor suerte en el próximo giro.");
        }

        System.out.println("\nSaldo actualizado: $" + jugador.getSaldo());

        ArchivoCSV.guardarJugador(jugador);
    }

    public static boolean activarAmuleto(Jugador jugador, int apuesta) {
        if (jugador.getNombre().equalsIgnoreCase("LUCKY")) {
            return true;
        }

        if (apuesta == 777) {
            return true;
        }

        return false;
    }

    public static void mostrarAmuleto() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║        AMULETO ACTIVADO            ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║  La suerte está de tu lado         ║");
        System.out.println("║  Si ganas, tu premio se duplica    ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    public static void mostrarTitulo() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║          THE LUCKY ARCADE          ║");
        System.out.println("╠════════════════════════════════════╣");
        System.out.println("║              SLOTS 3x3             ║");
        System.out.println("╚════════════════════════════════════╝");
    }

    public static void animacionGiro() {

        for (int i = 0; i < 5; i++) {
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

        System.out.println("╔═════╦═════╦═════╗");

        for (int i = 0; i < 3; i++) {
            System.out.println("║  " + matriz[i][0] + "  ║  " + matriz[i][1] + "  ║  " + matriz[i][2] + "  ║");

            if (i < 2) {
                System.out.println("╠═════╬═════╬═════╣");
            }
        }

        System.out.println("╚═════╩═════╩═════╝");
    }

    public static int calcularPremio(String[][] matriz, int apuesta) {

        int lineas = 0;

        for (int i = 0; i < 3; i++) {
            if (matriz[i][0].equals(matriz[i][1]) && matriz[i][1].equals(matriz[i][2])) {
                lineas++;
            }
        }

        if (matriz[0][0].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][2])) {
            lineas++;
        }

        if (matriz[0][2].equals(matriz[1][1]) && matriz[1][1].equals(matriz[2][0])) {
            lineas++;
        }

        if (lineas == 0) {
            return 0;
        }

        return apuesta * lineas * 2;
    }
}