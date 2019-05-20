package pl.krepec.stockExchange.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.krepec.stockExchange.service.PortfolioService;
import pl.krepec.stockExchange.service.UserService;

@Component
public class Market {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    private PortfolioDTO getStockInfo(String stockSymbol){
        return portfolioService.getStockInfoFromURL(stockSymbol);
    }

    private Double calculate(Double stockPrice, Double quantity) {
        return stockPrice * quantity;

    }

    private UserDTO getUser(Integer id){
        return userService.findUserById(id);
    }

        public Double shopping(Integer id, Double quantity, Operation operation, String stockSymbol) {
        UserDTO userDTO = getUser(id);
        PortfolioDTO portfolioDTO = getStockInfo(stockSymbol);
        Double stockPrice = portfolioDTO.getStockCurrentPrice();

        Double calculateStockPrice = calculate(stockPrice, quantity);
        Double result = null;
        switch (operation) {
            case SELL:
                result = userDTO.getCash() + calculateStockPrice;
                return result;
            case BUY:
                result = userDTO.getCash() - calculateStockPrice;
                portfolioService.addPortfolio(new PortfolioDTO(null, stockSymbol, quantity,stockPrice, id));
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