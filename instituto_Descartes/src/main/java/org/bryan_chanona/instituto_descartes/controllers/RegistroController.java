package org.bryan_chanona.instituto_descartes.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.bryan_chanona.instituto_descartes.App;
import org.bryan_chanona.instituto_descartes.models.RegistroEstudiantes;
import org.bryan_chanona.instituto_descartes.models.Student;

public class RegistroController {

    @FXML
    private TextField matriculaEstudiante;

    @FXML
    private TextField nombreEstudiante;

    private RegistroEstudiantes registro = App.getRegistro();

    @FXML
    void onMouseClickAgregarEstudianteButton(MouseEvent event) {
        if (registro != null) {
            String name = nombreEstudiante.getText();
            String matricula = matriculaEstudiante.getText();
            Student student = new Student(name,matricula);

            try {
                if (registro.getSqLite() != null) {
                    registro.getSqLite().save(student);
                    System.out.println("Estudiante guardado exitosamente en todas las bases de datos.");
                }
                if (registro.getMariaDB() != null) {
                    registro.getMariaDB().save(student);
                    System.out.println("Estudiante guardado exitosamente en todas las bases de datos.");
                }
                if (registro.getMySQL() != null) {
                    registro.getMySQL().save(student);
                    System.out.println("Estudiante guardado exitosamente en todas las bases de datos.");
                }


            } catch (Exception e) {
                System.err.println("Error al guardar el estudiante: " + e.getMessage());
            }
        } else {

            System.err.println("La instancia de Registro no ha sido inicializada correctamente.");
        }
    }
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

    }


