package uk.casey.request;

import uk.casey.models.PaymentRequest;
import java.math.BigDecimal;

public class PaymentService {

    public boolean paymentRequestBodyIsValid(PaymentRequest request) {
        return request != null
                && request.getAmount() != null
                && request.getAmount().compareTo(BigDecimal.ZERO) > 0
                && request.getPaymentType() != null && !request.getPaymentType().trim().isEmpty()
                && request.getCurrency() != null && !request.getCurrency().trim().isEmpty();
    }
}
