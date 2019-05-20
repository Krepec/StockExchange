package pl.krepec.stockExchange.model;

public class PortfolioDTO {

   private Integer id;
   private String stockSymbol;
   private Double numberOfShares;
   private Double stockCurrentPrice;
   private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStockSymbol() {
        return stockSymbol;
    }

    public void setStockSymbol(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    public Double getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Double numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Double getStockCurrentPrice() {
        return stockCurrentPrice;
    }

    public void setStockCurrentPrice(Double stockCurrentPrice) {
        this.stockCurrentPrice = stockCurrentPrice;
    }

    public PortfolioDTO(Integer id, String stockSymbol, Double numberOfShares, Double stockCurrentPrice, Integer userId) {
        this.id = id;
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.stockCurrentPrice = stockCurrentPrice;
        this.userId = userId;
    }

    public PortfolioDTO(String stockSymbol, Double stockCurrentPrice) {
        this.stockSymbol = stockSymbol;
        this.stockCurrentPrice = stockCurrentPrice;
    }

    public PortfolioDTO() {
    }

    @Override
    public String toString() {
        return "Stock Symbol: " + stockSymbol + "\nLatest Price: " + stockCurrentPrice;
    }
}
