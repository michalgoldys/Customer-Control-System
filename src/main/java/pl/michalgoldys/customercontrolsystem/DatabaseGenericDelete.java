package pl.michalgoldys.customercontrolsystem;

import javax.transaction.Transactional;

public interface DatabaseGenericDelete<T> {
    @Transactional
    void delete(T t);
}
