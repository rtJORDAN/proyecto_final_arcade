import java.util.Scanner;

public class ConsoleInput {

    static Scanner sc = new Scanner(System.in);

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Entrada inválida. Ingresa un número.");
            }
        }
    }

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return sc.nextLine();
    }
}