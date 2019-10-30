package pl.krepec.stockExchange.model;

public class UserDTO  {


    private Integer id;
    private String userName;
    private String password;
    private Double cash;
    private String role;


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
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

    public UserDTO(Integer id, String userName, String password, Double cash, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.cash = cash;
        this.role = role;
    }

    public UserDTO() {
    }





}

