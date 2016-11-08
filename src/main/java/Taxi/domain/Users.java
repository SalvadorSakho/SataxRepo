package Taxi.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by ${BIM} on 02.09.2016.
 */
@Entity
@Table(name = "taxiUsers")
public class Users {

    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private int id;
    @Column(name = "userName")
    private String userName;
    @Column(name = "userPassword")
    private String userPassword;
    @Column(name = "userLogin")
    private String userLogin;
    @Column(name = "workStar")
    private Date workStar;
    @Column(name = "workEnd")
    private Date workEnd;
    @Column(name = "userBirth")
    private Date userBirth;
    @Column(name = "userPosition")
    private int userPosition;

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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public Date getWorkStar() {
        return workStar;
    }

    public void setWorkStar(Date workStar) {
        this.workStar = workStar;
    }

    public Date getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(Date workEnd) {
        this.workEnd = workEnd;
    }

    public Date getUserBirth() {
        return userBirth;
    }

    public void setUserBirth(Date userBirth) {
        this.userBirth = userBirth;
    }

    public int getUserPosition() {
        return userPosition;
    }

    public void setUserPosition(int userPosition) {
        this.userPosition = userPosition;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userLogin='" + userLogin + '\'' +
                ", workStar=" + workStar +
                ", workEnd=" + workEnd +
                ", userBirth=" + userBirth +
                ", userPosition=" + userPosition +
                '}';
    }
}
