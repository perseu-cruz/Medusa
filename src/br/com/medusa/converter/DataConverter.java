package br.com.medusa.converter;

import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataConverter {

    private static final String PATTERN_BR = "dd/MM/yyyy";

    public static void apply(DatePicker object, String pattern) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate localDate) {
                if (localDate != null) {
                    return formatter.format(localDate);
                }
                else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String s) {
                if (s != null && !s.isEmpty()){
                    return LocalDate.parse(s,formatter);
                }
                else {
                    return null;
                }
            }
        };
        object.setConverter(converter);
    }

    public static void apply(DatePicker object) {
          apply(object,PATTERN_BR);
    }





}
