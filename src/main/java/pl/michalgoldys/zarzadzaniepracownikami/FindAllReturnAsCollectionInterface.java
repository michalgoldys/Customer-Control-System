package pl.michalgoldys.zarzadzaniepracownikami;

import javax.transaction.Transactional;
import java.util.Collection;

public interface FindAllReturnAsCollectionInterface<T> {
    @Transactional
    Collection<T> findAll();
}
