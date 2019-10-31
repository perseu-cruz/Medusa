package br.com.medusa.util;

import javafx.scene.control.Alert;

public class Dialog {



    public static void error(String message) {
        showAlertDialog(message, Alert.AlertType.ERROR);
    }

    public static void warning(String message) {
        showAlertDialog(message, Alert.AlertType.WARNING);
    }

    public static void info(String message) {
        showAlertDialog(message, Alert.AlertType.INFORMATION);
    }



    private static void showAlertDialog(String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        switch (alertType) {
            case WARNING:
                alert.setTitle("Aviso");
                alert.setHeaderText(message);
                alert.showAndWait();
                break;
            case ERROR:
                alert.setTitle("Erro");
                alert.setHeaderText(message);
                alert.showAndWait();
                break;
            case INFORMATION:
                alert.setTitle("Informação");
                alert.setHeaderText(message);
                alert.showAndWait();
                break;
        }

    }
}
