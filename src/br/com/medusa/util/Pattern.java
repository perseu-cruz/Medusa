package br.com.medusa.util;

import br.com.medusa.converter.DataConverter;
import javafx.scene.control.DatePicker;

public class Pattern {

    public static void datePickerBrazil(DatePicker datePicker){
        DataConverter.apply(datePicker);
        Formatter.datePicker(datePicker);
        datePicker.setPromptText("dd/mm/aaaa");
    }

}
