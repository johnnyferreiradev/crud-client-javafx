/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledevendasifce.controller;

import controledevendasifce.model.DAO.ClienteDAO;
import controledevendasifce.model.domain.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Johnny
 */
public class FXMLFormClienteController implements Initializable {

    @FXML
    private TextField txtCPF;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtTelefone;
    
    Cliente cliente;
    Stage stage;
    boolean flagConfirmacao = false;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isFlagConfirmacao() {
        return flagConfirmacao;
    }

    public void setFlagConfirmacao(boolean flagConfirmacao) {
        this.flagConfirmacao = flagConfirmacao;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void handleConfirmar() {
        
        this.cliente = new Cliente();
        this.cliente.setNome(this.txtNome.getText().toString());
        this.cliente.setCpf(this.txtCPF.getText().toString());
        this.cliente.setTelefone(this.txtTelefone.getText().toString());
        
        ClienteDAO clienteDAO = ClienteDAO.singleton();
        
        clienteDAO.insertClientes(cliente);
        
        setFlagConfirmacao(true);
        getStage().close();
    }
    
    @FXML
    public void handleCacelar() {
        setFlagConfirmacao(false);
        getStage().close();
    }
    
    
}
