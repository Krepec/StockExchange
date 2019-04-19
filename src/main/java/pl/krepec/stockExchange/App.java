package pl.krepec.stockExchange;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories
public class App {


    public static void main(String[] args) throws IOException, InterruptedException {

        Desktop.getDesktop().open(new File("/home/jerzyn/Desktop/Java Projects/StockExchange/src/main/java/pl/krepec/stockExchange/view/index.html"));

        SpringApplication.run(App.class, args);


       /* Sql sql = new Sql();
        List<String> cash = sql.getDataFromDataBase("cash", "users");
        Double userCash = Double.valueOf(cash.get(0));

        Market market = new Market();

        String stockSymbol = "baba";
        Double latestPrice = 150.0;
        Double calculateCash = market.calculate(latestPrice, 10.0);
        System.out.println(calculateCash);
        userCash = market.shoping(userCash, calculateCash, Operation.BUY);
        System.out.println(userCash);
        double calc = market.calculate(120.0, 10.0);
        double dasd = market.shoping(userCash, calc, Operation.SELL);
        System.out.println(dasd);
*/

    }

}
