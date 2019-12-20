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
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Johnny
 */
public class FXMLCadastroClienteController implements Initializable {

    @FXML
    private Button btnCreate;
    
    @FXML
    private Button btnEdit;
    
    @FXML
    private Button btnDelete;
    
    @FXML
    private TableView<Cliente> tabelaCliente;

    @FXML
    private TableColumn<Cliente, String> tblColCPF;

    @FXML
    private TableColumn<Cliente, String> tblColNome;

    @FXML
    private TableColumn<Cliente, String> tblColTelefone;
    
    List<Cliente> listCliente;
    ObservableList<Cliente> observableList;
    
    @FXML
    private void handleFormCliente() throws IOException {
        FXMLLoader fxml = new FXMLLoader();
        fxml.setLocation(FXMLFormClienteController.class.getResource("/controledevendasifce/view/FXMLFormCliente.fxml"));
        AnchorPane anchoPane = (AnchorPane) fxml.load();
        
        Scene scene = new Scene(anchoPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        
        FXMLFormClienteController controller = fxml.getController();
        controller.setCliente(null);
        controller.setStage(stage);
        
        stage.showAndWait();
        
        if(controller.isFlagConfirmacao()) {
            loadClientes();
        }
        /*
        Parent root = FXMLLoader.load(getClass().getResource("/controledevendasifce/view/FXMLFormCliente.fxml"));
        
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setIconified(false);
        stage.setTitle("Formulário para cadastro de cliente");
        stage.show();
        */
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadClientes();
    }    
    
    public void loadClientes() {
        tblColNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblColCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tblColTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        ClienteDAO clienteDAO = ClienteDAO.singleton();
        observableList = FXCollections.observableArrayList(clienteDAO.loadClientes());
        tabelaCliente.refresh();
        tabelaCliente.setItems(observableList);
    }
    
}
