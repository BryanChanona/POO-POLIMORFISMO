package org.bryan_chanona.instituto_descartes.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private final StringProperty nombreEstudiante;
    private final StringProperty matricula;

    public Student(String name, String matricula) {
        this.nombreEstudiante = new SimpleStringProperty(name);
        this.matricula = new SimpleStringProperty(matricula);
    }


    public void setMatricula(String matricula) {
        this.matricula.set(matricula);
    }

    public String getNombreEstudiante() {
        return nombreEstudiante.get();
    }

    public StringProperty nombreEstudianteProperty() {
        return nombreEstudiante;
    }

    public String getMatricula() {
        return matricula.get();
    }

    public StringProperty matriculaProperty() {
        return matricula;
    }

    @Override
    public String toString() {
        return "Student{" +
                "nombreEstudiante=" + nombreEstudiante +
                ", matricula=" + matricula +
                '}';
    }
}
