package org.bryan_chanona.instituto_descartes.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bryan_chanona.instituto_descartes.App;

public class ControlDeRegistroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    private Stage saveStage = new Stage();
    private Stage updateStage = new Stage();
    private Stage viewStage = new Stage();

    @FXML
    void onMouseClickSaveButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("registro-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        saveStage.setTitle("Guardar Estudiante");
        saveStage.setScene(scene);
        saveStage.show();
    }

    @FXML
    void onMouseClickUpdateButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("actualizar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        updateStage.setTitle("Actualizar Estudiante");
        updateStage.setScene(scene);
        updateStage.show();
    }

    @FXML
    void onMouseClickVerEstudiantesButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("verRegistroEstudiantes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        viewStage.setTitle("Ver Estudiantes");
        viewStage.setScene(scene);
        viewStage.show();
    }

    @FXML
    void initialize() {
    }

    @FXML
    void onMouseClieckedSalirButton(MouseEvent event) {
        System.exit(1);

    }
}
