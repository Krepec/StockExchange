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
        return portfolioService.getPortfolioByStockBySymbol(stockSymbol);
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

    private Boolean checkExistingStockInPortfolio(Integer id, String stockSymbol) {
        PortfolioDTO portfolioDTO = portfolioService.getPortfolioByStockBySymbolAndId(stockSymbol, id);
        return portfolioDTO.getUserId().equals(id) && portfolioDTO.getStockSymbol().equals(stockSymbol);
    }

    private UserDTO getUser(Integer id) {
        return userService.findUserById(id);
    }


    public Double zapupy(Integer userId, Integer stockQuantity, Operation operation, String stockSymbol) {
        UserDTO userDTO = getUser(userId);
        Double userCash = userDTO.getCash();
        System.out.println("User name " + userDTO.getUserName() + " user cash " + userDTO.getCash() + " user id " + userDTO.getId());

        PortfolioDTO portfolioDTO = portfolioService.getPortfolioInfoFromUrl(stockSymbol);
        Double actualStockPrice = portfolioDTO.getStockCurrentPrice();
        System.out.println("Actula cash for symbol: " + stockSymbol + " is: " + portfolioDTO.getStockCurrentPrice());

        Double actulaStochCash = portfolioDTO.getStockCurrentPrice();
        System.out.println(actulaStochCash);
        System.out.println(stockQuantity);

        Double calculateCash = actulaStochCash * stockQuantity;
        switch (operation) {
            case BUY:
                if (calculateCash < userCash) {
                    System.out.println("Masz za mało pieniędzy do dokonania tego zakupu");
                } else if (checkExistingStockInPortfolio(userId, stockSymbol)) {
                    PortfolioDTO portfolioDTOtoUpdate = portfolioService.getPortfolioByStockBySymbolAndId(stockSymbol, userId);
                    System.out.println("portfolio id:" + portfolioDTO.getId());
                    Integer numberOfShares = portfolioDTOtoUpdate.getNumberOfShares();
                    Integer calculatenumberOfShares = numberOfShares + stockQuantity;
                    portfolioService.updatePortfolio(portfolioDTOtoUpdate.getId(), new UpdatePortfolioDetail(calculatenumberOfShares));
                    return userCash - calculateCash;
                } else {
                    portfolioService.addPortfolio(new PortfolioDTO(null, stockSymbol, stockQuantity, actualStockPrice, userId));

                }
            case SELL:

                return userCash - calculateCash;
        }

        return userCash;

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
                    if (checkExistingStockInPortfolio(id, stockSymbol)) {
                        Integer numberOfShares = portfolioDTO.getNumberOfShares();
                        System.out.println(numberOfShares);
                        Integer updatedNumberofShares = numberOfShares + quantity;
                        System.out.println("nuer sharsow" + updatedNumberofShares);
                        portfolioService.updatePortfolio(userDTO.getId(), new UpdatePortfolioDetail(updatedNumberofShares));
                        result = userDTO.getCash() - calculateStockPrice;
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


