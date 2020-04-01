package pl.michalgoldys.customercontrolsystem;

import javax.transaction.Transactional;

public interface DatabaseGenericUpdate<T> {
    @Transactional
    void update(T t);
}
