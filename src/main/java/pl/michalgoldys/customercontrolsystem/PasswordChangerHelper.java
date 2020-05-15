package pl.michalgoldys.customercontrolsystem;

import org.springframework.stereotype.Component;

@Component
public class PasswordChangerHelper {

    private String oldPassword;
    private String newPassword;
    private String newPassword2;

    private User user;

    protected PasswordChangerHelper(){

    }

    public PasswordChangerHelper(String oldPassword, String newPassword, String newPassword2) {
        this.oldPassword = oldPassword;
        this.newPassword = newPassword;
        this.newPassword2 = newPassword2;
    }

    public String getOldPassword() {
        return oldPassword;
    }


    public String getNewPassword() {
        return newPassword;
    }

    public String getNewPassword2() {
        return newPassword2;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public void setNewPassword2(String newPassword2) {
        this.newPassword2 = newPassword2;
    }
}
