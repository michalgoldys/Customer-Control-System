package pl.michalgoldys.zarzadzaniepracownikami;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

		@GetMapping(value="/index")
		private String indexPage(Model model, SimpleDateFormat simpleDateFormat) {
			
			model.addAttribute("serverTime", simpleDateFormat.format(new Date()));
			
			return "index";
		}
}
