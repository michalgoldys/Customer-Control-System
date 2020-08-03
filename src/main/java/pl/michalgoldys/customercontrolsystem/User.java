package pl.michalgoldys.customercontrolsystem;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity(name="USER")
public class User {

    @Id
    @Column(name = "username", unique = true, nullable = false, length = 30)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "enabled", nullable = false)
    private Boolean enabled;

    public User() {
    }

    @Autowired
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    List<UserAuthorities> userAuthoritiesList;

    public List<UserAuthorities> getUserAuthoritiesList() {
        return userAuthoritiesList;
    }

    public void setUserAuthoritiesList(List<UserAuthorities> userAuthoritiesList) {
        this.userAuthoritiesList = userAuthoritiesList;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", userAuthoritiesList=" + userAuthoritiesList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(username, user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username);
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}
