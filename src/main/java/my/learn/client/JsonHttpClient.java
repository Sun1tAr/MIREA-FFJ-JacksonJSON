package my.learn.client;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


public class JsonHttpClient {

    private final String CURRENCY_URL = "https://www.cbr-xml-daily.ru/daily_json.js";

    public String getCurrencies() {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(URI.create(CURRENCY_URL))
                .GET()
                .build();

        HttpResponse<String> response = null;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.err.println(e.getMessage());
        }

        if (response != null) {
            return response.body();
        } else {
            return "{}";
        }
    }

}
