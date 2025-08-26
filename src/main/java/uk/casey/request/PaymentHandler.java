package uk.casey.request;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.InputStream;

public class PaymentHandler implements HttpHandler {

    public void handle(HttpExchange exchange) throws IOException {
        if ("POST".equals(exchange.getRequestMethod())) {
            InputStream requestBody = exchange.getRequestBody();
            StringBuilder body = new StringBuilder();
            int ch;
            while ((ch = requestBody.read()) != -1) {
                body.append((char) ch);
            }
            PaymentService paymentService = new PaymentService();
            if (!paymentService.isBodyValid(body.toString())) {
                exchange.sendResponseHeaders(400, -1); // Bad Request
                return;
            }
            System.out.println("Received payment data: " + body.toString());
            String response = "Payment processed";
            exchange.sendResponseHeaders(200, response.length());
            exchange.getResponseBody().write(response.getBytes());
            exchange.getResponseBody().close();
        } else {
            exchange.sendResponseHeaders(405, -1); // Method Not Allowed
        }
    }
}
