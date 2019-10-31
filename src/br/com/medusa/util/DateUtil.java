package br.com.medusa.util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

public class DateUtil {

    private static final String PATTERN = "dd/MM/yyyy";

    public static LocalDate stringToDate(String date){
        if (date.trim().isEmpty()){
            throw new IllegalArgumentException("Data inválida");
        }
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(PATTERN, Locale.forLanguageTag("pt-BR"));
        try {
            return LocalDate.parse(date, dtf);
        } catch (DateTimeParseException e){
            throw new IllegalArgumentException("Data inválida");
        }

    }

    public static String dateToString(LocalDate localDate){
        return localDate.format(DateTimeFormatter.ofPattern(PATTERN));
    }

    public static boolean isValid(String value){
        try {
        LocalDate.parse(value, DateTimeFormatter.ofPattern(PATTERN, Locale.forLanguageTag("pt-BR")));
        return true;
        } catch (DateTimeParseException e){ return false;
        }

    }


}
