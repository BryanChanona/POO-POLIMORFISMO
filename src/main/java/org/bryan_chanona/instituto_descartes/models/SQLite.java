package org.bryan_chanona.instituto_descartes.models;


import java.util.ArrayList;

public class SQLite implements IDataBase{
    private ArrayList<Student> estudiantes;
    public SQLite(){
        estudiantes=new ArrayList<>();
    }


    @Override
    public boolean save(Student student) {
        return estudiantes.add(student);
    }
    public ArrayList<Student> getEstudiantes() {
        return estudiantes;
    }

    @Override
    public boolean update(Student student) {
        for (int i=0;i<estudiantes.size();i++){
            Student students = estudiantes.get(i);
            if (students.getNombreEstudiante().equals(student.getNombreEstudiante())){
                estudiantes.set(i,student);
                return true;
            }
        }
        return false;
    }
}
