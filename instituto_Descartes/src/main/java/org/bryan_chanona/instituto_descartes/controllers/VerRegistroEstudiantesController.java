package org.bryan_chanona.instituto_descartes.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import org.bryan_chanona.instituto_descartes.models.MariaDB;
import org.bryan_chanona.instituto_descartes.models.MySQL;
import org.bryan_chanona.instituto_descartes.models.SQLite;
import org.bryan_chanona.instituto_descartes.models.Student;

public class VerRegistroEstudiantesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> baseDeDatos;

    @FXML
    private TableView<Student> mostrarTable;

    @FXML
    private TableColumn<Student, String> verMatricula;

    @FXML
    private TableColumn<Student, String> verNombre;

    @FXML
    void onMouseClickVerLista(MouseEvent event) {

    }
    @FXML
    void initialize() {
        baseDeDatos.getItems().addAll("MySQL","MariaDB","SQLite");
    }

}
