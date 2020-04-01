package pl.michalgoldys.customercontrolsystem;

import javax.transaction.Transactional;

public interface DatabaseGenericSave<T> {
    @Transactional
    void save(T t);
}
