package boot.model;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "privilege")
    private int privilege;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getPrivilege() {
        return privilege;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPrivilege(int privilege) {
        this.privilege = privilege;
    }
}
