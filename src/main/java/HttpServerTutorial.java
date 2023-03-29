import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.time.Instant;

import static java.lang.Math.round;

public class HttpServerTutorial {

  private static Integer number = null;

  public static void main(String[] args) throws IOException {
    InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
    HttpServer httpServer = HttpServer.create(addr, 0);
    httpServer.createContext("/", new RequestHandler());
    httpServer.start();
    System.out.println("Server started, listening at: " + addr);
  }

  private static class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) {
      try {
        doHandle(exchange);
      } catch (Exception e) {
        e.printStackTrace(System.out);
        try {
          exchange.sendResponseHeaders(500, 0);
        } catch (IOException ignore) {
        }
      } finally {
        try {
          exchange.sendResponseHeaders(200, 0);
        } catch (IOException ignore) {
        }
        System.out.println(exchange.getRequestMethod() + " " + exchange.getRequestURI() + " -> " + exchange.getResponseCode());
        exchange.close();
      }
    }

    private void doHandle(HttpExchange exchange) throws IOException {
      String methodAndPath = exchange.getRequestMethod() + " " + exchange.getRequestURI().getPath();
      switch (methodAndPath) {
        case "GET /status" -> handleStatusRequest(exchange);
        case "POST /start-game" -> handleStartGameRequest(exchange);
        case "POST /guess" -> handleGuessRequest(exchange);
        case "POST /end-game" -> handleEndGameRequest(exchange);
        default -> handleNotFound(exchange);
      }
    }

    private void handleStartGameRequest(HttpExchange exchange) throws IOException {
      if (number != null) {
        exchange.sendResponseHeaders(400, 0);
        try (OutputStream responseBody = exchange.getResponseBody()) {
          responseBody.write("Game already started".getBytes());
        }
      } else {
        number = (int) round(Math.random()*100);
        exchange.sendResponseHeaders(200, 0);
      }
    }

    private void handleGuessRequest(HttpExchange exchange) throws IOException {
    }

    private void handleEndGameRequest(HttpExchange exchange) throws IOException {
    }

    void handleStatusRequest(HttpExchange exchange) throws IOException {
      String response = Instant.now().toString();

      exchange.sendResponseHeaders(200, response.length());

      try (OutputStream responseBody = exchange.getResponseBody()) {
        responseBody.write(response.getBytes());
      }
    }

    void handleNotFound(HttpExchange exchange) throws IOException {
      exchange.sendResponseHeaders(404, 0);
      exchange.close();
    }
  }
}
