package conversor.logica;

public class ConversorMoneda {
    public static double convertir(double monto, double tasaConversion) {
        return monto * tasaConversion;
    }

    public static void mostrarResultado(String origen, String destino, double monto, double tasa, double resultado) {
        System.out.printf("%.2f %s = %.2f %s (tasa: %.4f)%n",
                monto, origen, resultado, destino, tasa);
    }
}
