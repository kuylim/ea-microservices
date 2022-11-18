package edu.miu.productservice.config;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Author: Kuylim TITH
 * Date: 11/13/2022
 */
@Configuration
public class BeanConfiguration {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public KeycloakSpringBootConfigResolver keycloakConfigResolver(){
        return new KeycloakSpringBootConfigResolver();
    }

}
