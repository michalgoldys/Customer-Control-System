package pl.michalgoldys.customercontrolsystem;

public enum UserRoles {
    ROLE_USER("User"), ROLE_ADMIN("Admin");

    String name;

    UserRoles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
