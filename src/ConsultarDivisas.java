import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarDivisas {

    public Moneda consultarMoneda(String nombre){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        URI busqueda = URI.create("https://v6.exchangerate-api.com/v6/5a6c6fd870355a98e9b4768b/latest/"+nombre);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(busqueda).build();

        try {
            HttpResponse<String> response = null;
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());
            Rates moneda = gson.fromJson(response.body(), Rates.class);
           // System.out.println(moneda);
            return moneda.conversionRates();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("NO encontre ninguna moneda"+e.getMessage());
        }
    }
}