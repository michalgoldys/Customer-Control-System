package pl.michalgoldys.customercontrolsystem;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Entity(name = "USER_AUTHORITIES")
public class UserAuthorities {

    @Id
    @Column(name= "authority", length = 30)
    private String authority;

    @Autowired
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    public UserAuthorities() {
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
