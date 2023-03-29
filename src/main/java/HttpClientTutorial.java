import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClientTutorial {

  public static void main(String[] args) throws IOException, InterruptedException {
    URI HTTP_SERVER_URI = URI.create("http://localhost:5555/status");
    HttpClient httpClient = HttpClient.newHttpClient();
    HttpRequest request = HttpRequest.newBuilder()
        .GET()
        .uri(HTTP_SERVER_URI)
        .build();
    System.out.println("Sending: " + request);
    HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println("Received: " + response);
    System.out.println(response.body());
  }
}
