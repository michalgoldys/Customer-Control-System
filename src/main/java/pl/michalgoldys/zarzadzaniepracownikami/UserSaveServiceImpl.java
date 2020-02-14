package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class UserSaveServiceImpl implements DatabaseGenericSave<UserWrapper> {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private BCryptEncodeServiceImpl bCryptEncodeService;

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void save(UserWrapper userWrapper) {

        User user = new User();
        UserAuthorities userAuthorities = userWrapper.getUserAuthorities();

        user.setUsername(userWrapper.getUser().getUsername());
        user.setPassword(bCryptEncodeService.encode(userWrapper.getUser().getPassword()));
        user.setEnabled(userWrapper.getUser().getEnabled());

        List<UserAuthorities> userAuthorities1 = new ArrayList<>();
        userAuthorities1.add(userAuthorities);

        user.setUserAuthoritiesList(userAuthorities1);
        userAuthorities.setUser(user);

        log.info("About to save new user as username: " + user.getUsername());
        userDAO.save(user);
    }
}
