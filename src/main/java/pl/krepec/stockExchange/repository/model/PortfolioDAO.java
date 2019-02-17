package pl.krepec.stockExchange.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "portfolio")
public class PortfolioDAO {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "stock_symbol")
    private String stockSymbol;

    @Column(name = "number_of_shares")
    private Integer numberOfShares;

    @Column(name = "stock_current_price")
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


    public PortfolioDAO(Integer id, String stockSymbol, Integer numberOfShares, Double stockCurrentPrice) {
        this.id = id;
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.stockCurrentPrice = stockCurrentPrice;
    }

    public PortfolioDAO() {
    }
}
