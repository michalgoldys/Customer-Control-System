package pl.michalgoldys.customercontrolsystem;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.transaction.Transactional;

public interface FindAllReturnAsPageInterface<T> {
    @Transactional
    Page<T> findAll(PageRequest pageRequest);
}
