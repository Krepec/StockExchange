package pl.krepec.stockExchange.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.krepec.stockExchange.service.HistoryService;
import pl.krepec.stockExchange.service.PortfolioService;
import pl.krepec.stockExchange.service.UserService;

@Component
public class Market {

    @Autowired
    private UserService userService;
    @Autowired
    private HistoryService historyService;
    @Autowired
    private PortfolioService portfolioService;



    public Double getUserAccount(String userName, String password){
        UserDTO userDTO = userService.findByUserNameAndPassword(userName, password);
        return userDTO.getCash();
    }

    public Double calculate(Double stockPrice, Double quantity) {
        return stockPrice * quantity;
    }

    public PortfolioDTO getStockInfo(String stockSymbol){
       return portfolioService.getStockInfoFromURL(stockSymbol);
    }

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
