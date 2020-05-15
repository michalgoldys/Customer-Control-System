package pl.michalgoldys.customercontrolsystem;

public interface Validator<T, A> {
    Boolean validate(T t, A A);
}
