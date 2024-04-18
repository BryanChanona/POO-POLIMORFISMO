package org.bryan_chanona.instituto_descartes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.bryan_chanona.instituto_descartes.models.IDataBase;
import org.bryan_chanona.instituto_descartes.models.RegistroEstudiantes;

import java.io.IOException;


public class App extends Application {
    public static IDataBase baseDatos;
public static RegistroEstudiantes registro = new RegistroEstudiantes(baseDatos);

    public static RegistroEstudiantes getRegistro() {
        return registro;
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("controlDeRegistros-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}