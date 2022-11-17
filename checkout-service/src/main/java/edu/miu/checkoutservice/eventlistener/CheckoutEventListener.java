package edu.miu.checkoutservice.eventlistener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Author: Kuylim TITH
 * Date: 11/16/2022
 */
@Slf4j
@Component
public class CheckoutEventListener {
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "order-product", durable = "true"),
            exchange = @Exchange(name = "payment-exchange", type = "fanout")
    ))
    public void paymentAcceptedListener(String payload) {
        log.info("Payload: {}", payload);
        if ("PAYMENT_ACCEPTED".equals(payload)) {
            log.info("Products checkout successfully...");
        }
    }
}
