package br.com.medusa.util;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;

public class Formatter {

    public static void datePicker(DatePicker object) {
        object.getEditor().setOnKeyTyped((KeyEvent evt) -> {
            if (!"0123456789".contains(evt.getCharacter())) {
                evt.consume();
            }
            if (evt.getCharacter().trim().length() == 0) {
                switch (object.getEditor().getText().length()) {
                    case 3:
                        object.getEditor().setText(object.getEditor().getText().substring(0, 2));
                        object.getEditor().positionCaret(object.getEditor().getText().length());
                        break;
                    case 6:
                        object.getEditor().setText(object.getEditor().getText().substring(0, 5));
                        object.getEditor().positionCaret(object.getEditor().getText().length());
                        break;
                }

            } else {
                if (object.getEditor().getText().length() == 10) {
                    evt.consume();
                }

                if (object.getEditor().getText().length() == 2 || object.getEditor().getText().length() == 5) {
                    object.getEditor().setText(object.getEditor().getText() + "/");
                    object.getEditor().positionCaret(object.getEditor().getText().length());
                }

            }
        });

    }


    public static void cep(TextField object) {
        object.setOnKeyTyped((KeyEvent event) -> {
            if (!"0123456789".contains(event.getCharacter())) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) {

                if (object.getText().length() == 6) {
                    object.setText(object.getText().substring(0, 5));
                    object.positionCaret(object.getText().length());
                }

            } else {
                switch (object.getText().length()) {
                    case 9:
                        event.consume();
                        break;
                    case 5:
                        object.setText(object.getText() + "-");
                        object.positionCaret(object.getText().length());
                        break;

                }
            }
        });


    }


    public static void textFieldUpperCase(TextField object) {
        object.setTextFormatter(new TextFormatter<>((f) -> {
            f.setText(f.getText().toUpperCase());
            return f;
        }));
    }

    public static void textFieldUpperCase(TextField... textFields) {
        for (int i = 0; i < textFields.length; i++) {
            textFieldUpperCase(textFields[i]);
        }

    }


}
