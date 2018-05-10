package boot.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "history")
public class HistoryUser { //DE VERIFICAT/COMPLETAT

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "UserID")
    private Integer userId;

    @Column(name = "Diseases")
    private String diseases;

    @Column(name = "Symptoms")
    private String symptoms;

    @Column(name = "Date")
    private Date date;

    public Integer getID() {
        return id;
    }

    public Integer getUserID() {
        return userId;
    }

    public void setUserID(Integer userID) {
        userId = userID;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        diseases = diseases;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        symptoms = symptoms;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        date = date;
    }
}
