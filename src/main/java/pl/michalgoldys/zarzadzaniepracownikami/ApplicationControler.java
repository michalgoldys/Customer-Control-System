package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationControler {

	@GetMapping(value ="/StronaGlowna")
		public String strongaGlowa () {
		
		return "StronaGlowna";
	}
		
	
}
