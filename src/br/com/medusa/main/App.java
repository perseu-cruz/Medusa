package br.com.medusa.main;

import br.com.medusa.model.Pessoa;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static final String PATCH_FXML = "../view/";
    //Lista observavel onde será armazenado os objetos pessoa
    private static ObservableList<Pessoa> pessoaObservableList = FXCollections.observableArrayList();

    //Container raiz
    private static BorderPane pane;

    @Override
    public void start(Stage primaryStage) throws Exception {
        pane = (BorderPane) loadFXML("root");
        changeParent("AppView");
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Muda a para outra cena de a cordo com o parametro passado
     * @param parent que carrega o arquivo fxml
     * @throws IOException lançada se o arquivo não for encotrado
     */
    public static void changeParent(String parent) throws IOException {
        pane.setCenter(loadFXML(parent));
    }

    /**
     * Carrega o arquivo fxml correspondente ao parametro informado e retorna um container
     * @param fxml nome do arquivo a ser invocado
     * @return Pane
     * @throws IOException se o arquivo não for encontrado
     */
    private static Pane loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(PATCH_FXML+fxml + ".fxml"));
        return fxmlLoader.load();
    }
    

    /**
     *  Recebe uma lista de objetos observáveis do tipo Pessoa
     * @return ObservableList
     */
    public static ObservableList<Pessoa> getPessoaObservableList() {
        return pessoaObservableList;
    }
}