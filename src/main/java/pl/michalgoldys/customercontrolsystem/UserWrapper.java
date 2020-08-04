package pl.michalgoldys.customercontrolsystem;

public class UserWrapper {

    private final User user;
    private final UserAuthorities userAuthorities;

    public UserWrapper(User user, UserAuthorities userAuthorities) {
        this.user = user;
        this.userAuthorities = userAuthorities;
    }

    public User getUser() {
        return user;
    }

    public UserAuthorities getUserAuthorities() {
        return userAuthorities;
    }
}
