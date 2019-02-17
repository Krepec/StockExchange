package pl.krepec.stockExchange.model;

public class PortfolioDTO {

   private Integer id;

   private String stockSymbol;

   private Integer numberOfShares;

   private Double stockCurrentPrice;

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

    public Integer getNumberOfShares() {
        return numberOfShares;
    }

    public void setNumberOfShares(Integer numberOfShares) {
        this.numberOfShares = numberOfShares;
    }

    public Double getStockCurrentPrice() {
        return stockCurrentPrice;
    }

    public void setStockCurrentPrice(Double stockCurrentPrice) {
        this.stockCurrentPrice = stockCurrentPrice;
    }

    public PortfolioDTO(Integer id, String stockSymbol, Integer numberOfShares, Double stockCurrentPrice) {
        this.id = id;
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.stockCurrentPrice = stockCurrentPrice;
    }

    public PortfolioDTO() {
    }
}
