package pl.michalgoldys.zarzadzaniepracownikami;

import javax.transaction.Transactional;

public interface DatabaseGenericDelete<T> {
    @Transactional
    void delete(T t);
}
