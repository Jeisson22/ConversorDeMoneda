package conversor.api;



import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ServicioApi {

    private static final String API_KEY = "7a69cdc7a844d2baccf1a684"; // Tu clave real

    public static double obtenerTasa(String origen, String destino) {
        try {
            String url = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/" + origen;

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject tasas = json.getAsJsonObject("conversion_rates");
            return tasas.get(destino).getAsDouble();

        } catch (Exception e) {
            System.out.println("Error al obtener la tasa: " + e.getMessage());
            return 1.0;
        }
    }
}
