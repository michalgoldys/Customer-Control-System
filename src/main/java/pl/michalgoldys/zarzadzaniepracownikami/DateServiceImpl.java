package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Component
public class DateServiceImpl implements DateInterface {

    @Override
    public String getCurrentDate() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();

        return dateTimeFormatter.format(localDate);
    }
}
