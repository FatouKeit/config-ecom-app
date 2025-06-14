package org.example.customerservice;

import org.example.customerservice.config.CustomerConfigParams;
import org.example.customerservice.entities.Customer;
import org.example.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder()
                            .name("Fatou KEITA").email("fatoukeita@gmail.com")
                    .build());

            customerRepository.save(Customer.builder()
                    .name("Aminata DIALLO").email("aminatadiallo@gmail.com")
                    .build());

            customerRepository.save(Customer.builder()
                    .name("Cisma CISSE").email("cismacisse@gmail.com")
                    .build());

            customerRepository.findAll().forEach(c->{
                System.out.println("==============");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("==============");
            });
        };



    }

}
