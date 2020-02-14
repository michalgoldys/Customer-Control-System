package pl.michalgoldys.zarzadzaniepracownikami;

public class UserWrapper {

    private User user;
    private UserAuthorities userAuthorities;

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
