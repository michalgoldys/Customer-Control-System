package pl.michalgoldys.zarzadzaniepracownikami;

import java.text.SimpleDateFormat;
import java.util.Date;

public interface TimeInterface {
	
	default String getCurrentDateAsString() {
		Date currentDate = new Date();
	      SimpleDateFormat ft = 
	      new SimpleDateFormat ("dd.MM.yyyy hh:mm:ss");
	      
		return (ft.format(currentDate));
	}
}
