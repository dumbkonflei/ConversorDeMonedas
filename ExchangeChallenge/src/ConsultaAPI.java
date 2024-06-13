import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public Monedas buscaTasa(String divisaCode, String divisaObjetive, double cantidad){
        String YourAPIKey = "cf67e9868f37f84d657fb035";
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/"+YourAPIKey+"/pair/"+divisaCode+"/"+divisaObjetive+"/"+cantidad);
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Monedas.class);
        }catch (Exception e){
            throw new RuntimeException("Moneda no válida");
        }
    }
}
