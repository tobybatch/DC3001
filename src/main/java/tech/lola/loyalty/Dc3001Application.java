package tech.lola.loyalty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import tech.lola.loyalty.otares.service.CustomerService;

@SpringBootApplication
@Configuration
public class Dc3001Application {

	public static void main(String[] args) {
		SpringApplication.run(Dc3001Application.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
	   return builder.build();
	}
	
    @Bean
    public CustomerService getCustomerService(){
        return new CustomerService();
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
