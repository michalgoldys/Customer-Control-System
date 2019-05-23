package pl.michalgoldys.zarzadzaniepracownikami;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

@Service
public class CustomerService {

		public String getCurrentDate() {
			Date currentDate = new Date();
		      SimpleDateFormat ft = 
		      new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
		      
			return (ft.format(currentDate));
		}
}
