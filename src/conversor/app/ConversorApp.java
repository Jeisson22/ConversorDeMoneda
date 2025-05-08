package conversor.app;


import conversor.logica.ConversorMoneda;
import conversor.api.ServicioApi;

import java.util.Scanner;

public class ConversorApp {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("\n=== Conversor de Monedas ===");
            System.out.println("1. USD -> ARS");
            System.out.println("2. USD -> BOB");
            System.out.println("3. USD -> BRL");
            System.out.println("4. USD -> CLP");
            System.out.println("5. USD -> COP");
            System.out.println("6. Salir");
            System.out.print("Elija una opción (1-6): ");
            opcion = scanner.nextLine();

            if (opcion.equals("6")) {
                System.out.println("¡Gracias por usar el conversor!");
                break;
            }

            if (!opcion.matches("[1-5]")) {
                System.out.println("Opción inválida, intente nuevamente.");
                continue;
            }

            System.out.print("Ingrese el monto en USD: ");
            double monto = scanner.nextDouble();
            scanner.nextLine(); // Limpiar buffer

            String destino = obtenerMoneda(opcion);
            double tasa = ServicioApi.obtenerTasa("USD", destino);
            double resultado = ConversorMoneda.convertir(monto, tasa);

            ConversorMoneda.mostrarResultado("USD", destino, monto, tasa, resultado);

        } while (!opcion.equals("6"));
    }

    private static String obtenerMoneda(String opcion) {
        return switch (opcion) {
            case "1" -> "ARS";
            case "2" -> "BOB";
            case "3" -> "BRL";
            case "4" -> "CLP";
            case "5" -> "COP";
            default -> "USD";
        };
    }
}
