package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BCryptEncodeServiceImpl implements EncodeInterface {

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public String encode(String password) {
        log.info("Encoding password..");
        return bCryptPasswordEncoder.encode(password);
    }
}
