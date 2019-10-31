package br.com.medusa.controller;

import br.com.medusa.main.App;
import br.com.medusa.model.Pessoa;
import br.com.medusa.util.DateUtil;
import br.com.medusa.util.Dialog;
import br.com.medusa.util.Formatter;
import br.com.medusa.util.Pattern;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class PessoaController {

    private static Pessoa object;
    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfSobrenome;
    @FXML
    private TextField tfRua;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfCep;
    @FXML
    private DatePicker dpNasc;
    @FXML
    private Label labelTitle;

    public static void update(Pessoa pessoa) {
        object = pessoa;
    }


    @FXML
    void cancelar() {
        try {
            App.changeParent("AppView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void confirmar() {
        if (validate()) {
            try {
                if (this.object == null) {
                    App.getPessoaObservableList().add(new Pessoa(tfNome.getText(), tfSobrenome.getText(), tfRua.getText(), tfCidade.getText(), tfCep.getText(), (DateUtil.stringToDate(dpNasc.getEditor().getText()))));
                } else {
                    this.object.setNome(tfNome.getText().trim());
                    this.object.setSobrenome(tfSobrenome.getText().trim());
                    this.object.setRua(tfRua.getText().trim());
                    this.object.setCidade(tfCidade.getText().trim());
                    this.object.setCep(tfCep.getText().trim());
                    this.object.setNasc(DateUtil.stringToDate(dpNasc.getEditor().getText()));
                }
                try {
                    App.changeParent("AppView");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (IllegalArgumentException e) {
                Dialog.error(e.getMessage());
            }
        }
    }


    @FXML
    void initialize() {
        Pattern.datePickerBrazil(this.dpNasc);
        Formatter.textFieldUpperCase(this.tfNome, this.tfSobrenome, this.tfRua, this.tfCidade);
        Formatter.cep(this.tfCep);
        if (this.object == null) {
            this.tfNome.setText("");
            this.tfSobrenome.setText("");
            this.tfRua.setText("");
            this.tfCidade.setText("");
            this.tfCep.setText("");
            this.dpNasc.getEditor().setText("");
        } else {
            this.labelTitle.setText("ALTERAR");
            this.tfNome.setText(object.getNome());
            this.tfSobrenome.setText(object.getSobrenome());
            this.tfRua.setText(object.getRua());
            this.tfCidade.setText(object.getCidade());
            this.tfCep.setText(object.getCep());
            this.dpNasc.getEditor().textProperty().setValue(DateUtil.dateToString(this.object.nascProperty().get()));
        }
    }


    private boolean validate() {
        if (this.tfNome.getText().trim().isEmpty()) {
            Dialog.info("Por favor, digite o nome!");
            this.tfNome.requestFocus();
        } else if (this.tfSobrenome.getText().trim().isEmpty()) {
            Dialog.info("Por favor, digite o sobrenome!");
            this.tfSobrenome.requestFocus();
        } else if (this.tfRua.getText().trim().isEmpty()) {
            Dialog.info("Por favor, digite a rua!");
            this.tfRua.requestFocus();
        } else if (this.tfCidade.getText().trim().isEmpty()) {
            Dialog.info("Por favor, digite a cidade!");
            this.tfCidade.requestFocus();
        } else if (this.tfCep.getText().trim().isEmpty()) {
            Dialog.info("Por favor, digite a CEP!");
            this.tfCep.requestFocus();
        } else if (!DateUtil.isValid(this.dpNasc.getEditor().getText())) {
            Dialog.info("Por favor, digite uma data válida!");
            this.dpNasc.getEditor().requestFocus();
        } else {
            return true;

        }
        return false;

    }

}
