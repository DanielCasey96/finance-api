package uk.casey.request;

import com.sun.net.httpserver.HttpServer;

import java.net.InetSocketAddress;

public class PaymentController {

    private HttpServer httpServer;

    public PaymentController() throws Exception {
        httpServer = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
        httpServer.createContext("/payment", new PaymentHandler());
        httpServer.setExecutor(null);
        httpServer.start();
    }
}
