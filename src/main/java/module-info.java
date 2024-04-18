module org.bryan_chanona.instituto_descartes {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.bryan_chanona.instituto_descartes to javafx.fxml;
    exports org.bryan_chanona.instituto_descartes;
    exports org.bryan_chanona.instituto_descartes.controllers;
    opens org.bryan_chanona.instituto_descartes.controllers to javafx.fxml;
}