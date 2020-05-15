package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserUpdateServiceImpl implements DatabaseGenericUpdate<User>{

    @Override
    public void update(User user) {
        log.info("Updating user");
    }
}