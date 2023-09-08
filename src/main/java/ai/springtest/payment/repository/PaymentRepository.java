package ai.springtest.payment.repository;

import ai.springtest.payment.domain.Payment;
import java.util.HashMap;
import java.util.Map;

public class PaymentRepository {

    private final Map<Long, Payment> persistence = new HashMap<>();
    private Long sequence = 1L;

    public void save(final Payment payment) {
        payment.assignId(++sequence);
        persistence.put(payment.getId(), payment);
    }
}
