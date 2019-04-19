package pl.krepec.stockExchange.repository.model;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserDAO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "cash")
    private Double cash;

    public Integer getId() {
        return id;
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

    public UserDAO(String userName, String password, Double cash) {
        this.userName = userName;
        this.password = password;
        this.cash = 10000.0;
    }

    public UserDAO(Integer id, String userName, String password, Double cash) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.cash = 10000.0;
    }

    public UserDAO() {
    }


}

