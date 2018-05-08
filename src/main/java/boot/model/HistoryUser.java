package boot.model;

import javax.persistence.*;

@Entity
@Table(name = "history")
public class HistoryUser { //DE VERIFICAT/COMPLETAT

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int ID;

    @Column(name = "UserID")
    private String UserID;

    @Column(name = "Diseases")
    private String Diseases;

    @Column(name = "Symptoms")
    private String Symptoms;

    @Column(name = "Date")
    private java.util.Date Date;


    public String getUserID() {
        return UserID;
    }

    public String getDiseases() {
        return Diseases;
    }

    public String getSymptoms() {
        return Symptoms;
    }

    public java.util.Date getDate() {
        return Date;
    }

    //POATE MAI TEREBUIE NISTE SETTERE?

}
