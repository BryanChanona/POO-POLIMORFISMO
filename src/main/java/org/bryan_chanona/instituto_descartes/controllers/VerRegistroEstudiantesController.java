package org.bryan_chanona.instituto_descartes.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bryan_chanona.instituto_descartes.App;
import org.bryan_chanona.instituto_descartes.models.*;

public class VerRegistroEstudiantesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;


    @FXML
    private TableView<Student> mostrarTable;

    @FXML
    private TableColumn<Student, String> verMatricula;

    @FXML
    private TableColumn<Student, String> verNombre;

    private RegistroEstudiantes control = App.getRegistro();
    @FXML
    void onMouseClickVerLista(MouseEvent event) {
        MySQL mySQL = new MySQL();
        SQLite sqLite = new SQLite();
        MariaDB mariaDB = new MariaDB();
        mostrarTable.getItems().clear();
        if (control.getMySQL() != null && !control.getMySQL().getEstudiantes().isEmpty()) {
            mostrarTable.getItems().addAll(control.getMySQL().getEstudiantes());

        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("No hay datos para mostrar en la tabla");
            alert.showAndWait();
            return;

        }


    }
    @FXML
    void onMouseClickSalirButton(MouseEvent event) {
        Stage stage = (Stage) mostrarTable.getScene().getWindow();
        stage.close();

    }
    @FXML
    void initialize() {

        verMatricula.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());
        verNombre.setCellValueFactory(cellData -> cellData.getValue().nombreEstudianteProperty());
    }

}
