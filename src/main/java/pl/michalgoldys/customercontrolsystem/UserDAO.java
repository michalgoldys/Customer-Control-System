package pl.michalgoldys.customercontrolsystem;

import org.springframework.data.repository.Repository;

import java.util.Collection;

@org.springframework.stereotype.Repository
public interface UserDAO extends Repository<User, Long> {

    Collection findAll();
    User findByusername(String username);
    void save (User user);
    void deleteByusername (String username);
}