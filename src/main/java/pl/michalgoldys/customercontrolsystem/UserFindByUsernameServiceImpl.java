package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserFindByUsernameServiceImpl implements FindByStringReturnAsTypeInterface<User>{

    @Autowired
    private UserDAO userDAO;

    @Override
    public User findBy(String username) {
        log.info("Getting user from database..");
        return userDAO.findByusername(username);
    }
}
