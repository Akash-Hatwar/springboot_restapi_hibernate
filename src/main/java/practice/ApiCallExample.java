package practice;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpHeaders;
import java.util.Map;

public class ApiCallExample {
    public static void main(String[] args) {
        try {
            // Define the API endpoint URL
            String urlString = "https://partnersV1.pinbot.ai/v3/cta/111266881902966/messages";

            // JSON payload for the request body
            String jsonPayload = "{\n" +
                    "    \"to\": \"917447393410\",\n" +
                    "    \"type\": \"template\",\n" +
                    "    \"template\": {\n" +
                    "        \"language\": {\n" +
                    "            \"code\": \"en_US\"\n" +
                    "        },\n" +
                    "        \"name\": \"test_112524\",\n" +
                    "        \"components\": [\n" +
                    "            {\n" +
                    "                \"type\": \"BUTTON\",\n" +
                    "                \"sub_type\": \"URL\",\n" +
                    "                \"index\": \"0\",\n" +
                    "                \"parameters\": [\n" +
                    "                    {\n" +
                    "                        \"type\": \"PAYLOAD\",\n" +
                    "                        \"payload\": \"https://www.bajajfinserv.in/webform/emicard/login?utm_source=Expartner&utm_medium=Digi&utm_campaign=wb23oct\"\n" +
                    "                    }\n" +
                    "                ]\n" +
                    "            }\n" +
                    "        ]\n" +
                    "    },\n" +
                    "    \"messaging_product\": \"whatsapp\"\n" +
                    "}";

            // Create an HTTP client
            HttpClient client = HttpClient.newHttpClient();

            // Create an HTTP request with headers and body
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlString))
                    .header("apikey", "d543e7c3-37a2-11ef-b1d4-02c8a5e042bd")
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload)) // Set request body
                    .build();

            // Send the request and get the response
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // Print the response code and body
            System.out.println("Response Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






