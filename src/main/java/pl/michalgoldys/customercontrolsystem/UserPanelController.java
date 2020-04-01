package pl.michalgoldys.customercontrolsystem;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class UserPanelController {

    @Autowired
    FindUsersReturnAsListServiceImpl findUsersReturnAsListService;

    @Autowired
    UserDeleteServiceImpl userDeleteService;

    @Autowired
    UserSaveServiceImpl userSaveService;

    @GetMapping(value = "/customer/userscontrolpanel")
    String userControlPanelView(Model model) {
        log.info("Getting users from service..");
        model.addAttribute("userList", findUsersReturnAsListService.findAll());
        return "userscontrolpanel.html";
    }

    @PostMapping(value = "/customer/userscontrolpanel/delete/{username}")
    String deleteSelectedUser(@PathVariable String username){
        log.info("About to delete user with username: " + username);
        userDeleteService.delete(username);
        return "redirect:/customer/userscontrolpanel";
    }

    @GetMapping(value = "/customer/userscontrolpanel/newuser")
    String addingNewUserForm(User user, UserAuthorities userAuthorities){
        return "newuser";
    }

    @PostMapping(value = "/customer/userscontrolpanel/newuser")
    String addingNewUser(User user, UserAuthorities userAuthorities){
        UserWrapper userWrapper = new UserWrapper(user, userAuthorities);
        userSaveService.save(userWrapper);
        return "redirect:/customer/userscontrolpanel";
    }

    @GetMapping(value = "/customer/userscontrolpanel/userdetails/{username}")
    String getUserDetails(@PathVariable String username){
        return "userdetails";
    }
}
