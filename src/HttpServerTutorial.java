import com.sun.net.httpserver.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.time.Instant;

public class HttpServerTutorial {
  public static void main(String[] args) throws IOException {
    InetSocketAddress addr = new InetSocketAddress("localhost", 5555);
    HttpServer httpServer = HttpServer.create(addr, 0);
    httpServer.createContext("/", new RequestHandler());
    httpServer.start();
    System.out.println("Server started, listening at: " + addr);
  }

  private static class RequestHandler implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
      String methodAndPath = exchange.getRequestMethod() + " " + exchange.getRequestURI().getPath();
      switch (methodAndPath) {
        case "GET /status" -> handleStatusRequest(exchange);
        case "POST /start-game" -> handleStartGameRequest(exchange);
        case "POST /guess" -> handleGuessRequest(exchange);
        case "POST /end-game" -> handleEndGameRequest(exchange);
        default -> handleNotFound(exchange);
      }
      System.out.println(exchange.getRequestMethod() + " " + exchange.getRequestURI() + " " + exchange.getResponseCode());
    }

    private void handleStartGameRequest(HttpExchange exchange) throws IOException {
      exchange.sendResponseHeaders(500, 0);
      exchange.close();
    }

    private void handleGuessRequest(HttpExchange exchange) throws IOException {
      exchange.sendResponseHeaders(500, 0);
      exchange.close();
    }

    private void handleEndGameRequest(HttpExchange exchange) throws IOException {
      exchange.sendResponseHeaders(500, 0);
      exchange.close();
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
