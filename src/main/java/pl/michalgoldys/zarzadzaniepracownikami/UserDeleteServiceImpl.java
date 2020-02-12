package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDeleteServiceImpl implements DatabaseGenericDelete<String>{

    @Autowired
    private UserDAO userDAO;

    @Override
    public void delete(String username) {
        log.info("Service is about to delete user with username: " + username);
    }
}
