package Taxi.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ${BIM} on 28.07.2016.
 */
@Entity
@Table(name = "taxiOrders")
public class Order {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "orderId", nullable = false)
    private int orderId;

    @Column(name = "streetFrom")
    private String streetFrom;
    @Column(name = "houseFrom")
    private String houseFrom;
    @Column(name = "blockFrom")
    private String blockFrom;
    @Column(name = "notes")
    private String notes;
    @Column(name = "streetTo")
    private String streetTo;
    @Column(name = "houseTo")
    private String houseTo;
    @Column(name = "blockTo")
    private String blockTo;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "fioOrder")
    private String fioOrder;

    @ManyToOne(cascade = CascadeType.ALL)
    @Fetch(value = FetchMode.SELECT)
    @JoinColumn(name = "ClientID")
    private Clients clients;

    @Column(name = "taxiId")
    private int taxiId;
    @Column(name = "orderDate")
    private Date orderDate;
    @Column(name = "price")
    private Integer price;

    public float getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int id) {
        this.orderId = id;
    }

    public String getStreetFrom() {
        return streetFrom;
    }

    public void setStreetFrom(String streetFrom) {
        this.streetFrom = streetFrom;
    }

    public String getBlockFrom() {
        return blockFrom;
    }

    public void setBlockFrom(String blockFrom) {
        this.blockFrom = blockFrom;
    }

    public String getHouseFrom() {
        return houseFrom;
    }

    public void setHouseFrom(String houseFrom) {
        this.houseFrom = houseFrom;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getHouseTo() {
        return houseTo;
    }

    public void setHouseTo(String houseTo) {
        this.houseTo = houseTo;
    }

    public String getStreetTo() {
        return streetTo;
    }

    public void setStreetTo(String streetTo) {
        this.streetTo = streetTo;
    }

    public String getBlockTo() {
        return blockTo;
    }

    public void setBlockTo(String blockTo) {
        this.blockTo = blockTo;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getFioOrder() {
        return fioOrder;
    }

    public void setFioOrder(String fioOrder) {
        this.fioOrder = fioOrder;
    }

    public Clients getClientsId() {
        return clients;
    }

    public void setClientsId(Clients cid) {
        this.clients = cid;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTaxiId() {
        return taxiId;
    }

    public void setTaxiId(int taxiId) {
        this.taxiId = taxiId;
    }


   /* @Override
    public String toString() {
        return "Order{" +
                "id='" + orderId + '\'' +
                ", streetFrom='" + streetFrom + '\'' +
                ", houseFrom='" + houseFrom + '\'' +
                ", blockFrom='" + blockFrom + '\'' +
                ", notes='" + notes + '\'' +
                ", streetTo='" + streetTo + '\'' +
                ", houseTo='" + houseTo + '\'' +
                ", blockTo='" + blockTo + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", fioOrder='" + fioOrder + '\'' +
                ", cid=" + clients +
                ", taxiId=" + taxiId +
                ", orderDate=" + orderDate +
                ", price=" + price +
                '}';
    }*/
}