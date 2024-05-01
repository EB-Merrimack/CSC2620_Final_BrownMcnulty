module com.mycompany.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens com.mycompany.mavenproject1 to javafx.fxml;
    exports com.mycompany.mavenproject1;
}
