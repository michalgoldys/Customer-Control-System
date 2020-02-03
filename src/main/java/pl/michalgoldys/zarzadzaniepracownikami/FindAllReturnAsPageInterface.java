package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface FindAllReturnAsPageInterface<T> {
    Page<T> findAll(PageRequest pageRequest);
}
