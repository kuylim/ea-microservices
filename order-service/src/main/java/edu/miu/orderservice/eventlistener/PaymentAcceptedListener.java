package edu.miu.orderservice.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * Author: Kuylim TITH
 * Date: 11/16/2022
 */
@Slf4j
@Component
public class PaymentAcceptedListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "checkout-product", durable = "true"),
            exchange = @Exchange(name = "payment-exchange", type = "fanout")
    ))
    public void paymentAcceptedListener(String payload) {
        log.info("Payload: {}", payload);
        if ("PAYMENT_ACCEPTED".equals(payload)) {
            log.info("Your order will ship shortly...");
        }
    }
}
