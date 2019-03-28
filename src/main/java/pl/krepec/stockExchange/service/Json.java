package pl.krepec.stockExchange.service;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;
import pl.krepec.stockExchange.model.PortfolioDTO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

@Component
public class Json {

    private JSONParser jsonParser = new JSONParser();

    public String readUrl(String urlString) {
        String result = "";

        try {

            URL url = new URL(urlString);
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                result = line;
            }

            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    public PortfolioDTO parseJson(String jsonString) {

        String symbol = "";
        Double latestPrice = 0.0;
        PortfolioDTO stockInfo = null;

        try {
            JSONObject jsonObject = (JSONObject) jsonParser.parse(jsonString);
            String stockSymbol = (String) jsonObject.get("symbol");
            Double stockLatestPrice = (Double) jsonObject.get("latestPrice");
            symbol = stockSymbol;
            latestPrice = stockLatestPrice;
            stockInfo = new PortfolioDTO(symbol, latestPrice);

            return stockInfo;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return stockInfo;

    }

}