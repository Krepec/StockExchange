package pl.krepec.stockExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class App {


    public static void main(String[] args) {

        SpringApplication.run(new Object[]{App.class, UserRepository.class, UserService.class, UserController.class}, args);
    }
}
