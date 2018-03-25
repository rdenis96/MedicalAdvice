package boot.model;

import javax.persistence.*;

@Entity
@Table(name = "Diseases")
public class Disease {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;
    @Column(name = "NAME")
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
}
