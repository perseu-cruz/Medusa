package br.com.medusa.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;

public class Root {

    @FXML
    private void sair(){
        Platform.exit();
    }
}
