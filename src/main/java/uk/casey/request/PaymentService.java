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

    public boolean processPayment(PaymentRequest request) {

        try {
            return savePayemntToDatabase(request);
        } catch (Exception e) {
            System.out.println("Error processing payment: " + e.getMessage());
            return false;
        }
    }

    public boolean savePayemntToDatabase(PaymentRequest request) {
        //TODO add DB integration
        System.out.println("I saved the payment to the database");
        return true;
    }
}
