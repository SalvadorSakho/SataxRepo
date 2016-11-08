package Taxi.domain;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by ${BIM} on 25.07.2016.
 */
@Entity
@Table(name = "taxiClients")
public class Clients {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "clientId", nullable = false)
    private Integer ClientID;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String pass;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "fio")
    private String fio;

    @OneToMany(mappedBy = "clients")
    private Set<Order> ordersSet;

    public Clients() {
    }

    public Integer getClientID() {
        return ClientID;
    }

    public void setClientID(Integer unicId) {
        this.ClientID = unicId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Set<Order> getOrdersSet() {
        return ordersSet;
    }

    public void setOrdersSet(Set<Order> ordersSet) {
        this.ordersSet = ordersSet;
    }

    public Clients(Set<Order> ordersSet, String login, String pass, String phoneNumber, String email, String fio) {
        this.ordersSet = ordersSet;
        this.login = login;
        this.pass = pass;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.fio = fio;
    }

  /*  @Override
    public String toString() {
        return "Clients{" +
                "unicId=" + ClientID +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", fio='" + fio + '\'' +
                ", ordersSet=" + ordersSet +
                '}';
    }*/
}
