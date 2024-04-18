package org.bryan_chanona.instituto_descartes.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.bryan_chanona.instituto_descartes.App;
import org.bryan_chanona.instituto_descartes.models.RegistroEstudiantes;
import org.bryan_chanona.instituto_descartes.models.SQLite;
import org.bryan_chanona.instituto_descartes.models.Student;

public class ActualizarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Student> dataTable;

    @FXML
    private TableColumn<Student, String> matriculaAlumno;

    @FXML
    private TextField nombreActualizado;

    @FXML
    private TextField matriculaEstudiante;

    @FXML
    private TableColumn<Student, String> nombreAlumno;
    private RegistroEstudiantes registro = App.getRegistro();

    @FXML
    void onMouseClickActualizarButton(MouseEvent event) {
        String name = nombreActualizado.getText();
        String matricula = matriculaEstudiante.getText();

        if (name.isEmpty()  || matricula.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Rellene los campos correctamente.");
            alert.showAndWait();
        } else {
            boolean estudianteEncontrado = false;
            for (Student student : dataTable.getItems()) {
                if (name.equals(student.getNombreEstudiante())) {
                    student.setMatricula(matricula);
                    registro.update(student);
                    estudianteEncontrado = true;
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Matricula del estudiante actualizada con exito.");
                    alert.showAndWait();

                    nombreActualizado.clear();
                    matriculaEstudiante.clear();

                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("No exite el estudiante , no se puede actualizar.");
                    alert.showAndWait();
                    nombreActualizado.clear();
                    matriculaEstudiante.clear();


                }

            }
            if (estudianteEncontrado) {
                dataTable.getItems().clear();
                dataTable.getItems().addAll(registro.getMySQL().getEstudiantes());
            }

        }
    }

    @FXML
    void onMouseClickVerListaButton(MouseEvent event) {
        dataTable.getItems().clear();

        if (registro != null && registro.getMySQL() != null && registro.getMySQL().getEstudiantes() != null) {
            dataTable.getItems().addAll(registro.getMySQL().getEstudiantes());
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("La lista se encuentra vacia.");
            alert.showAndWait();
        }
    }

    @FXML
    void onMouseClickSalirButton(MouseEvent event) {
        Stage stage = (Stage) dataTable.getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize() {
        nombreAlumno.setCellValueFactory(cellData -> cellData.getValue().nombreEstudianteProperty());
        matriculaAlumno.setCellValueFactory(cellData -> cellData.getValue().matriculaProperty());
    }

}
