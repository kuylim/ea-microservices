package edu.miu.paymentservice.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: Kuylim TITH
 * Date: 11/16/2022
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final RabbitTemplate template;

    @GetMapping
    public String paymentAccepted() {
        template.convertAndSend("payment-exchange", "", "PAYMENT_ACCEPTED");
        return "Your payment accepted";
    }
}
