import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public final class ListSports {
    public static void main(String[] args) throws Exception {
        var apiKey = System.getenv("SPORTSFOUNDRY_API_KEY");
        if (apiKey == null || apiKey.isBlank()) {
            throw new IllegalStateException("SPORTSFOUNDRY_API_KEY is required");
        }

        var request = HttpRequest.newBuilder()
                .uri(URI.create("https://sportsfoundry.app/api/v1/sports"))
                .header("X-API-Key", apiKey)
                .GET()
                .build();

        var response = HttpClient.newHttpClient()
                .send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() / 100 != 2) {
            throw new IllegalStateException("SportsFoundry request failed: " + response.statusCode() + " " + response.body());
        }

        System.out.println(response.body());
    }
}
