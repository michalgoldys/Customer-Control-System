package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PasswordChangerHelperService implements Validator<PasswordChangerHelper, User>{

    @Autowired
    BCryptEncodeServiceImpl bCryptEncodeService;

    @Autowired
    private UserFindByUsernameServiceImpl findByUsernameService;

    @Override
    public Boolean validate(PasswordChangerHelper passwordChangerHelper, User user) {

        log.info("Checking matching passwords..");

        User oldUser = findByUsernameService.findBy(user.getUsername());

        return (passwordChangerHelper.getNewPassword().equals(passwordChangerHelper.getNewPassword2()) &&
                bCryptEncodeService.encode().matches(passwordChangerHelper.getOldPassword(),oldUser.getPassword()));
    }
}