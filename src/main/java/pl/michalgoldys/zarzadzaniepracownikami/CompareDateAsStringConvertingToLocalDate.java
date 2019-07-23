package pl.michalgoldys.zarzadzaniepracownikami;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;

public class CompareDateAsStringConvertingToLocalDate implements Comparator<String> {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	@Override
	public int compare(String o1, String o2) {
		return LocalDate.parse(o1, formatter).compareTo(LocalDate.parse(o2, formatter));
	}
}