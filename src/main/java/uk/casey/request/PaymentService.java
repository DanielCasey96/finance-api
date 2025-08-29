package uk.casey.request;

import uk.casey.models.PaymentRequest;

import java.math.BigDecimal;

public class PaymentService {

    public boolean isBodyValid(String body) {
        return body != null && !body.isEmpty();
    }

    public boolean paymentAmountIsValid(PaymentRequest request) {
        return request != null
                && request.getAmount() != null
                && request.getAmount().compareTo(BigDecimal.ZERO) > 0;
    }
}
