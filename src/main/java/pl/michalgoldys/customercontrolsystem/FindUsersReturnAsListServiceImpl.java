package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Slf4j
public class FindUsersReturnAsListServiceImpl implements FindAllReturnAsCollectionInterface<User> {

    @Autowired
    UserDAO userDAO;

    @Override
    public Collection<User> findAll() {
        log.info("Getting users from DAO, database..");
        Collection<User> users = new ArrayList<User>(userDAO.findAll());
        return users;
    }
}
