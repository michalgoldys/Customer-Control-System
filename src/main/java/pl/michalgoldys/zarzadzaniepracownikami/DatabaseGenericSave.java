package pl.michalgoldys.zarzadzaniepracownikami;

import javax.transaction.Transactional;

public interface DatabaseGenericSave<T> {
    @Transactional
    void save(T t);
}
