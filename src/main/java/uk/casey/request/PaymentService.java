package uk.casey.request;

public class PaymentService {

    public boolean isBodyValid(String body) {
        return body != null && !body.isEmpty();
    }
}
