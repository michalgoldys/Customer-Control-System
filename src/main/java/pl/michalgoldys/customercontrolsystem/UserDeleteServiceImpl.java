package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Slf4j
public class UserDeleteServiceImpl implements DatabaseGenericDelete<String>{

    @Autowired
    private UserDAO userDAO;

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Transactional
    public void delete(String username) {
        log.info("Service is about to delete user with username: " + username);
        userDAO.deleteByusername(username);
    }
}
