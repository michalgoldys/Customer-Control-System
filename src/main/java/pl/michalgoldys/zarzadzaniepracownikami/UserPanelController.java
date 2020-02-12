package pl.michalgoldys.zarzadzaniepracownikami;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class UserPanelController {

    @Autowired
    FindUsersReturnAsListServiceImpl findUsersReturnAsListService;

    @GetMapping(value = "/customer/userscontrolpanel")
    String userControlPanelView(Model model) {
        log.info("Getting users from service..");
        model.addAttribute("userList", findUsersReturnAsListService.findAll());
        return "userscontrolpanel.html";
    }
}
