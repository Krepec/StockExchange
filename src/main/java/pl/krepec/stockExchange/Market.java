package pl.krepec.stockExchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.krepec.stockExchange.model.PortfolioDTO;
import pl.krepec.stockExchange.model.UserDTO;
import pl.krepec.stockExchange.repository.requests.UpdatePortfolioDetail;
import pl.krepec.stockExchange.service.PortfolioService;
import pl.krepec.stockExchange.service.UserService;

@Component
public class Market {

    @Autowired
    private PortfolioService portfolioService;

    @Autowired
    private UserService userService;

    private PortfolioDTO getStockInfo(String stockSymbol) {
        return portfolioService.getPortfolioInfoFromUrl(stockSymbol);
    }

    private Double calculate(Double stockPrice, Integer quantity) {
        return stockPrice * quantity;

    }

    private void updatePortfolio(Integer id, Integer quantity, Operation operation, String stockSymbol) {
        PortfolioDTO stockInfoFromURL = getStockInfo(stockSymbol);
        Double stockPrice = stockInfoFromURL.getStockCurrentPrice();
        PortfolioDTO portfolioDTO = portfolioService.getPortfolioByStockBySymbol(stockSymbol);

        if (portfolioDTO.getStockSymbol().equals(stockSymbol)) {
            Integer numberOfShares = portfolioDTO.getNumberOfShares();
            switch (operation) {
                case BUY:
                    Integer result = numberOfShares + quantity;
                case SELL:
            }

            portfolioService.addPortfolio(new PortfolioDTO(null, stockSymbol, quantity, stockPrice, id));
        }


    }

    private Boolean checkExistingStockInPortfolio(String stockSymbol) {
        PortfolioDTO portfolioDTO = portfolioService.getPortfolioByStockBySymbol(stockSymbol);
        return portfolioDTO.getStockSymbol().equals(stockSymbol);
    }

    private UserDTO getUser(Integer id) {
        return userService.findUserById(id);
    }

    public Double shopping(Integer id, Integer quantity, Operation operation, String stockSymbol) {
        UserDTO userDTO = getUser(id);
        PortfolioDTO portfolioDTO = getStockInfo(stockSymbol);
        Double stockPrice = portfolioDTO.getStockCurrentPrice();
        Double calculateStockPrice = calculate(stockPrice, quantity);
        Double result;
        switch (operation) {
            case SELL:
                result = userDTO.getCash() + calculateStockPrice;
                return result;
            case BUY:
                if (userDTO.getCash() < calculateStockPrice) {
                    System.out.println("Masz za mało pieniędzy do dokonania tego zakupu");
                } else {
                    if (checkExistingStockInPortfolio(stockSymbol)) {
                        Integer numberOfShares = portfolioDTO.getNumberOfShares();
                        Integer updatedNumberofShares = numberOfShares + quantity;
                        result = userDTO.getCash() - calculateStockPrice;
                        portfolioService.updatePortfolio(userDTO.getId(), new UpdatePortfolioDetail(updatedNumberofShares));
                        return result;
                    } else {
                        portfolioService.addPortfolio(new PortfolioDTO(null, stockSymbol, quantity, stockPrice, id));
                        result = userDTO.getCash() - calculateStockPrice;
                        return result;
                    }
                }

        }

        return result = userDTO.getCash();
    }
}
