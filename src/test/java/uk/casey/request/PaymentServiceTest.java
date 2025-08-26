package uk.casey.request;

import org.junit.jupiter.api.Test;

class PaymentServiceTest {

    @Test
    void isBodyValid() {
        PaymentService paymentService = new PaymentService();
        assert paymentService.isBodyValid("valid body");
    }

    @Test
    void isBodyInvalid() {
        PaymentService paymentService = new PaymentService();
                assert !paymentService.isBodyValid("");
                assert !paymentService.isBodyValid(null);
    }
}
