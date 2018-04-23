package boot.model;

//import javax.persistence.*;

//@Entity
//@Table(name = "Symptoms")
public class Symptom {

    //@Id
  //  @GeneratedValue
   // @Column(name = "ID")
    private int id;
    //@Column(name = "NAME")
    private String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symptom(String name) {
        this.name = name;
    }
}
