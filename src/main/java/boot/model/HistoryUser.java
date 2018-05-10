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
    private Integer userid;

    @Column(name = "Diseases")
    private String diseases;

    @Column(name = "Symptoms")
    private String symptoms;

    @Column(name = "Date")
    private Date date;

    public Integer getId() {
        return id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
