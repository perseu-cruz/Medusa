package br.com.medusa.model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

@SuppressWarnings("unused")
public class Pessoa {

    //Atributos
    private  StringProperty nome;
    private  StringProperty sobrenome;
    private  StringProperty rua;
    private  StringProperty cidade;
    private  StringProperty cep;
    private  ObjectProperty<LocalDate> nasc;

    public Pessoa() {
    }

    public Pessoa(String nome, String sobrenome, String rua, String cidade, String cep, LocalDate idade) {
        this.nome = new SimpleStringProperty(nome);
        this.sobrenome = new SimpleStringProperty(sobrenome);

        this.rua = new SimpleStringProperty(rua);
        this.cidade = new SimpleStringProperty(cidade);
        this.cep = new SimpleStringProperty(cep);
        this.nasc = new SimpleObjectProperty<>(idade);
    }

    public String getNome() {
        return nome.get();
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public StringProperty nomeProperty() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome.get();
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome.set(sobrenome);
    }

    public StringProperty sobrenomeProperty() {
        return sobrenome;
    }

    public String getRua() {
        return rua.get();
    }

    public void setRua(String rua) {
        this.rua.set(rua);
    }

    public StringProperty ruaProperty() {
        return rua;
    }

    public String getCidade() {
        return cidade.get();
    }

    public void setCidade(String cidade) {
        this.cidade.set(cidade);
    }

    public StringProperty cidadeProperty() {
        return cidade;
    }

    public String getCep() {
        return cep.get();
    }

    public void setCep(String cep) {
        this.cep.set(cep);
    }

    public StringProperty cepProperty() {
        return cep;
    }

    public String getNasc() {
        return nasc.get().toString();
    }

    public void setNasc(LocalDate nasc) {
        this.nasc.set(nasc);
    }

    public ObjectProperty<LocalDate> nascProperty() {
        return nasc;
    }
}
