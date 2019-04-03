package pl.krepec.stockExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.krepec.stockExchange.controller.UserController;
import pl.krepec.stockExchange.model.PortfolioDTO;
import pl.krepec.stockExchange.repository.UserRepository;
import pl.krepec.stockExchange.service.Json;
import pl.krepec.stockExchange.service.UserService;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.sql.SQLOutput;
import java.util.Scanner;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class App {


    public static void main(String[] args) throws IOException {



   // Desktop.getDesktop().open(new File("/home/jerzyn/Desktop/Java Projects/StockExchange/src/main/java/pl/krepec/stockExchange/view/index.html"));

    SpringApplication.run(App.class, args);


    }

}
