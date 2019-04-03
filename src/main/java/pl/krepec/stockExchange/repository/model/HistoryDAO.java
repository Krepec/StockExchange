package pl.krepec.stockExchange.repository.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class HistoryDAO {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "operation")
    private String operation;

    @Column(name = "stock_symbol")
    private String stockSymbol;

    @Column(name = "stock_price")
    private Double stockPrice;

    @Column(name = "operation_date")
    private Date operationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getStock_symbol() {
        return stockSymbol;
    }

    public void setStock_symbol(String stock_symbol) {
        this.stockSymbol = stock_symbol;
    }

    public Double getStock_price() {
        return stockPrice;
    }

    public void setStock_price(Double stock_price) {
        this.stockPrice = stock_price;
    }

    public Date getOperation_date() {
        return operationDate;
    }

    public void setOperation_date(Date operation_date) {
        this.operationDate = operation_date;
    }

    public HistoryDAO() {

    }

    public HistoryDAO(int id, String operation, String stock_symbol, Double stock_price, Date operation_date) {
        this.id = id;
        this.operation = operation;
        this.stockSymbol = stock_symbol;
        this.stockPrice = stock_price;
        this.operationDate = operation_date;
    }


}
