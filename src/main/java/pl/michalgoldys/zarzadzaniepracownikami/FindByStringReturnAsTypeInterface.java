package pl.michalgoldys.zarzadzaniepracownikami;

import javax.transaction.Transactional;

public interface FindByStringReturnAsTypeInterface<T> {
    @Transactional
    T findBy(String string);
}