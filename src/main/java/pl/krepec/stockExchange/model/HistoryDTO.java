package pl.krepec.stockExchange.model;

import java.util.Date;

public class HistoryDTO {

    private int id;
    private String operation;
    private String stock_symbol;
    private Double stock_price;
    private Date operation_date;

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
        return stock_symbol;
    }

    public void setStock_symbol(String stock_symbol) {
        this.stock_symbol = stock_symbol;
    }

    public Double getStock_price() {
        return stock_price;
    }

    public void setStock_price(Double stock_price) {
        this.stock_price = stock_price;
    }

    public Date getOperation_date() {
        return operation_date;
    }

    public void setOperation_date(Date operation_date) {
        this.operation_date = operation_date;
    }

    public HistoryDTO(){

    }

    public HistoryDTO(int id, String operation, String stock_symbol, Double stock_price, Date operation_date) {
        this.id = id;
        this.operation = operation;
        this.stock_symbol = stock_symbol;
        this.stock_price = stock_price;
        this.operation_date = operation_date;
    }


}
