package edu.miu.paymentservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Kuylim TITH
 * Date: 11/16/2022
 */
@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue checkoutQueue() {
        return new Queue("checkout-product", true);
    }

    @Bean
    public Queue orderQueue() {
        return new Queue("order-product", true);
    }

    @Bean
    public FanoutExchange paymentExchange() {
        return new FanoutExchange("payment-exchange");
    }

    @Bean
    public Binding paymentCheckoutExchangeBinding(Queue checkoutQueue, FanoutExchange paymentExchange) {
        return BindingBuilder.bind(checkoutQueue).to(paymentExchange);
    }

    @Bean
    public Binding paymentOrderExchangeBinding(Queue orderQueue, FanoutExchange paymentExchange) {
        return BindingBuilder.bind(orderQueue).to(paymentExchange);
    }

    @Bean
    ApplicationRunner runner(ConnectionFactory cf) {
        return args -> {
            boolean open = false;
            while (!open) {
                try {
                    cf.createConnection().close();
                    open = true;
                } catch (Exception e) {
                    Thread.sleep(5000);
                }
            }
        };
    }
}
