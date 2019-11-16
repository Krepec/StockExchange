package pl.krepec.stockExchange.repository.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Collections;

@Entity
@Table(name = "users")
public class UserDAO implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String userName;

    @Column(name = "password")
    private String password;

    @NotNull
    @Column(name = "cash")
    private Double cash;

    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }



    public Integer getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(role));
    }



    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }



    public Double getCash() {
        return cash;
    }

    public void setCash(Double cash) {
        this.cash = cash;
    }

/*    public UserDAO(String userName, String password, Double cash) {
        this.userName = userName;
        this.password = password;
        this.cash = 10000.0;
    }

    public UserDAO(Integer id, String userName, String password, Double cash) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.cash = 10000.0;
    }*/

    public UserDAO(Integer id, String userName, String password, Double cash, String role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.cash = 10000.0;
        this.role = role;
    }


    public UserDAO() {
    }

    @Override
    public String toString() {
        return "hasło: " + password + " login: " + userName + " rola: "+ role;
    }

}

