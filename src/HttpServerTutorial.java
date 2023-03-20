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
      switch (exchange.getRequestURI().getPath()) {
        case "/status" -> {
          switch (exchange.getRequestMethod()) {
            case "GET" -> handleStatusRequest(exchange);
            default -> handleNotFound(exchange);
          }
        }
        case "/start-game" -> {
          switch (exchange.getRequestMethod()) {
            case "POST" -> handleStartGameRequest(exchange);
            default -> handleNotFound(exchange);
          }
        }
        case "/guess" -> {
          switch (exchange.getRequestMethod()) {
            case "POST" -> handleGuessRequest(exchange);
            default -> handleNotFound(exchange);
          }
        }
        case "/end-game" -> {
          switch (exchange.getRequestMethod()) {
            case "POST" -> handleEndGameRequest(exchange);
            default -> handleNotFound(exchange);
          }
        }
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
