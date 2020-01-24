package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.data.repository.Repository;

@org.springframework.stereotype.Repository
public interface UserDAO extends Repository<User, Long> {

    User findByusername(String username);
    void save (User user);
}
