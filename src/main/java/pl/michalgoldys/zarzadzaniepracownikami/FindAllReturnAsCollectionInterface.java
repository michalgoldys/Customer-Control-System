package pl.michalgoldys.zarzadzaniepracownikami;

import java.util.Collection;

public interface FindAllReturnAsCollectionInterface<T> {
    Collection<T> findAll();
}
