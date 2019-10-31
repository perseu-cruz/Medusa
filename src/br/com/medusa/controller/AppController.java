package br.com.medusa.controller;

import br.com.medusa.main.App;
import br.com.medusa.model.Pessoa;
import br.com.medusa.util.DateUtil;
import br.com.medusa.util.Dialog;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class AppController {

    private static Pessoa pessoa;
    @FXML
    private TableView<Pessoa> pessoaTable;
    @FXML
    private TableColumn<Pessoa, String> nomeColuna;
    @FXML
    private TableColumn<Pessoa, String> sobrenomeColuna;
    @FXML
    private Label lbnome;
    @FXML
    private Label lbsobrenome;
    @FXML
    private Label lbrua;
    @FXML
    private Label lbcidade;
    @FXML
    private Label lbcep;
    @FXML
    private Label lbnasc;

    //Define se alguma linha da tabela pessoaTable foi seleciona
    private boolean isRowSelected = false;

    @FXML
    void editar() {
            try {
        if (!isRowSelected) {
            Dialog.error("Nenhuma pessoa selecionada");
        } else {
            PessoaController.update(pessoa);
                App.changeParent("PessoaView");
        }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @FXML
    void novo() {
        try {
            App.changeParent("PessoaView");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void excluir(ActionEvent event) {
        event.consume();
        if (event.isConsumed()) {
            int index = pessoaTable.getSelectionModel().getSelectedIndex();
            if (isRowSelected) {
                pessoaTable.getItems().remove(index);
                isRowSelected = false;
                pessoaTable.refresh();
                limparLabels();
            } else {
                Dialog.error("Nehuma pessoa foi selecionada");
            }
        }
    }

    @FXML
    void initialize() {
        initTable();
        showSelectedRow();
    }


    /**
     * Popula a tabela com os dados recebidos da obsevable list
     *
     * @author elton
     * @version 0.0.1
     * @since 15/10/2019
     */
    private void initTable() {

        pessoaTable.setItems(App.getPessoaObservableList());

        //Icializa as colunas com os dados
        nomeColuna.setCellValueFactory(e -> e.getValue().nomeProperty());
        sobrenomeColuna.setCellValueFactory(e -> e.getValue().sobrenomeProperty());
    }

    /**
     * Mostra os dados de acordo com a linha selecionada na tabela
     */
    private void showSelectedRow() {
        pessoaTable.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            int index = pessoaTable.getSelectionModel().getSelectedIndex();
            if (index >= 0) {
                isRowSelected = true;
                pessoa = pessoaTable.getItems().get(index);
                lbnome.setText(pessoa.getNome());
                lbsobrenome.setText(pessoa.getSobrenome());
                lbrua.setText(pessoa.getRua());
                lbcidade.setText(pessoa.getCidade());
                lbcep.setText(pessoa.getCep());
                lbnasc.setText(DateUtil.dateToString(pessoa.nascProperty().get()));
            }
        });
    }

    private void limparLabels() {
        lbnome.setText("");
        lbsobrenome.setText("");
        lbrua.setText("");
        lbcidade.setText("");
        lbcep.setText("");
        lbnasc.setText("");
    }
}
