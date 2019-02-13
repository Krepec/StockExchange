package pl.krepec.stockExchange;

import org.springframework.boot.autoconfigure.SpringBootApplication;


public class UserDTO {


    private int id;
    private String userName;
    private String password;
    private Double cash;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

    public UserDTO(String userName, String password, Double cash) {
        this.userName = userName;
        this.password = password;
        this.cash = 10000.0;
    }

    public UserDTO(Integer id, String userName, String password, Double cash) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.cash = 10000.0;
    }

    public UserDTO() {
    }


}
