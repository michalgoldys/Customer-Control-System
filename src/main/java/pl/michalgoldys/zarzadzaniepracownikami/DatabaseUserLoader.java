package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.tools.jar.CommandLine;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Configuration
public class DatabaseUserLoader {

    @Autowired
    UserDAO userDAO;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    CommandLineRunner databaseInitializer() {
        return args ->{

            if(!Optional.ofNullable(userDAO.findByusername("admin")).isPresent()) {
                User user = new User();
                UserAuthorities userAuthorities = new UserAuthorities();

                user.setUsername("admin");
                user.setEnabled(true);
                user.setPassword(passwordEncoder.encode("admin1234"));

                userAuthorities.setAuthority("ROLE_ADMIN");

                List<UserAuthorities> userAuthoritiesList = new ArrayList<UserAuthorities>();
                userAuthoritiesList.add(userAuthorities);

                user.setUserAuthoritiesList(userAuthoritiesList);
                userAuthorities.setUser(user);

                userDAO.save(user);
            };
        };
    }
}

