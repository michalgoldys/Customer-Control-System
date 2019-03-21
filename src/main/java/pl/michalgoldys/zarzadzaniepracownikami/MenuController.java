package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {

		@GetMapping(value="/index")
		private String indexPage() {
			
			return "index";
		}
}
