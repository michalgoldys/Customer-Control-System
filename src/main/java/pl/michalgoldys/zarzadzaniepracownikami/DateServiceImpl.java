package pl.michalgoldys.zarzadzaniepracownikami;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
@Service
public class DateServiceImpl implements DateInterface {

    @Override
    public String getCurrentDate() {

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.now();

        return dateTimeFormatter.format(localDate);
    }
}
