package org.bryan_chanona.instituto_descartes.models;

import java.util.ArrayList;

public class MariaDB implements IDataBase {
    private ArrayList<Student> estudiantes;

    public MariaDB() {
        estudiantes = new ArrayList<>();
    }

    @Override
    public boolean save(Student student) {
        return estudiantes.add(student);
    }

    @Override
    public boolean update(Student student) {
        for (int i = 0; i < estudiantes.size(); i++) {
            Student existingStudent = estudiantes.get(i);
            if (existingStudent.getNombreEstudiante().equals(student.getNombreEstudiante())) {
                estudiantes.set(i, student);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getEstudiantes() {
        return estudiantes;
    }
}
