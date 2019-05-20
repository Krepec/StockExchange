package pl.krepec.stockExchange.repository.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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
    private Double numberOfShares;

    @Column(name = "stock_current_price")
    private Double stockCurrentPrice;

    @NotNull
    @Column(name = "user_id")
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


    public PortfolioDAO(Integer id, String stockSymbol, Double numberOfShares, Double stockCurrentPrice, Integer userId) {
        this.id = id;
        this.stockSymbol = stockSymbol;
        this.numberOfShares = numberOfShares;
        this.stockCurrentPrice = stockCurrentPrice;
        this.userId = userId;
    }

    public PortfolioDAO() {
    }
}
