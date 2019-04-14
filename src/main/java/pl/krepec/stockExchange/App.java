package pl.krepec.stockExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.io.IOException;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class App {


    public static void main(String[] args) throws IOException, InterruptedException {

       // Desktop.getDesktop().open(new File("/home/jerzyn/Desktop/Java Projects/StockExchange/src/main/java/pl/krepec/stockExchange/view/index.html"));

        SpringApplication.run(App.class, args);



    }

}
