package org.example.customerservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "customer.params")
public record CustomerConfigParams(int x, int y) {

}
