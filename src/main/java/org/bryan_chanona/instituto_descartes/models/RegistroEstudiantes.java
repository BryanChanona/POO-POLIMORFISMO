package org.bryan_chanona.instituto_descartes.models;


import java.util.ArrayList;

public class RegistroEstudiantes {
    private ArrayList<IDataBase> listaEstudiantes=new ArrayList<>();
    private IDataBase baseDeDatos;
    private MySQL mySQL;
    private  MariaDB mariaDB;
    private SQLite sqLite;
    public RegistroEstudiantes(IDataBase baseDeDatos1){
        this.baseDeDatos=baseDeDatos;
        mySQL=new MySQL();
        mariaDB=new MariaDB();
        sqLite=new SQLite();

        listaEstudiantes.add(mySQL);
        listaEstudiantes.add(mariaDB);
        listaEstudiantes.add(sqLite);

    }

    public void save(Student student){
        for (IDataBase baseDeDatos1:listaEstudiantes){
            baseDeDatos1.save(student);
        }
    }
    public void update(Student student){
        for (IDataBase iBaseDeDatos:listaEstudiantes){
            iBaseDeDatos.update(student);
        }
    }


    public MySQL getMySQL() {
        return mySQL;
    }

    public MariaDB getMariaDB() {
        return mariaDB;
    }

    public SQLite getSqLite() {
        return sqLite;
    }

    public ArrayList<IDataBase> getListaEstudiantes() {
        return listaEstudiantes;
    }
}
