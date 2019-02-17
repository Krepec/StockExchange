package pl.krepec.stockExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.krepec.stockExchange.controller.UserController;
import pl.krepec.stockExchange.repository.UserRepository;
import pl.krepec.stockExchange.service.UserService;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class App {


    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }
}
