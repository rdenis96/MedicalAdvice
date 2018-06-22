package boot.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "history")
public class HistoryUser { //DE VERIFICAT/COMPLETAT

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Integer id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Diseases")
    private String diseases;

    @Column(name = "Symptoms")
    private String symptoms;

    @Column(name = "Date")
    private Date date;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userid) {
        this.username = userid;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public Date  getDate() {
        return date;
    }

    public void setDate(Date  date) {
        this.date = date;
    }
}
