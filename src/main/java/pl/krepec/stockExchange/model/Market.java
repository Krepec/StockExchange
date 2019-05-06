package pl.krepec.stockExchange.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.krepec.stockExchange.service.PortfolioService;

@Component
public class Market {

    @Autowired
    private PortfolioService portfolioService;

    private PortfolioDTO getStockInfo(String stockSymbol){
        return portfolioService.getStockInfoFromURL(stockSymbol);
    }

    private Double calculate(Double stockPrice, Double quantity) {
        return stockPrice * quantity;

    }

        public Double shopping(Double userCash, Double stockPrice, Double quantity, Operation operation) {
        Double calculateStockPrice = calculate(stockPrice, quantity);
        Double result = null;
        switch (operation) {
            case SELL:
                result = userCash + calculateStockPrice;
                return result;

            case BUY:
                result = userCash - calculateStockPrice;
                return result;

    }

            return result;
        }
}
    /*  public Double getUserAccount(String userName, String password){
        UserDTO userDTO = userService.findByUserNameAndPassword(userName, password);
        return userDTO.getCash();







    public Double shoping(Double userCash, Double calculateCash,  Operation operation){
        Double result = null;
        switch (operation){
            case BUY:
                result = userCash - calculateCash;
                return result;
            case SELL:
                result = userCash + calculateCash;
                return result;
        }
        return result ;

    }



}
*/