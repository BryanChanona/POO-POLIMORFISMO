package org.bryan_chanona.instituto_descartes.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
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
        String nombreAgregado = nombreEstudiante.getText().trim();
        String matriculaAgregada = matriculaEstudiante.getText().trim();

        if (nombreAgregado.isEmpty() || matriculaAgregada.isEmpty()) {
            showAlert("Rellene los campos correctamente.");
        } else {
            try {
                if (registro != null) {
                    // Verificar si el estudiante ya existe en SQLite
                    boolean estudianteRepetido = registro.getSqLite().getEstudiantes()
                            .stream()
                            .anyMatch(estudiante -> estudiante.getNombreEstudiante().equals(nombreAgregado)
                                    && estudiante.getMatricula().equals(matriculaAgregada));

                    if (estudianteRepetido) {
                        showAlert("No se permiten agregar alumnos duplicados.");
                    } else {
                        // Crear nuevo estudiante
                        Student student = new Student(nombreAgregado, matriculaAgregada);

                        // Guardar en la base de datos SQLite si está disponible
                        if (registro.getSqLite() != null) {
                            registro.getSqLite().save(student);
                            System.out.println("Estudiante guardado exitosamente en SQLite.");
                        }

                        // Guardar en la base de datos MariaDB si está disponible
                        if (registro.getMariaDB() != null) {
                            registro.getMariaDB().save(student);
                            System.out.println("Estudiante guardado exitosamente en MariaDB.");
                        }

                        // Guardar en la base de datos MySQL si está disponible
                        if (registro.getMySQL() != null) {
                            registro.getMySQL().save(student);
                            System.out.println("Estudiante guardado exitosamente en MySQL.");
                        }

                        // Mostrar mensaje de éxito
                        showAlert("Estudiante guardado exitosamente.");
                        nombreEstudiante.clear();
                        matriculaEstudiante.clear();
                    }
                } else {
                    System.err.println("La instancia de Registro no ha sido inicializada correctamente.");
                }
            } catch (Exception e) {
                System.err.println("Error al guardar el estudiante: " + e.getMessage());
                showAlert("Error al guardar el estudiante. Por favor, inténtelo de nuevo.");
            }
        }
    }

    @FXML
    void onMouseClickSalirButton(MouseEvent event) {
        Stage stage = (Stage) matriculaEstudiante.getScene().getWindow();
        stage.close();
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
