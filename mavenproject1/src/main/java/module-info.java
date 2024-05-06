module com.mycompany.mavenproject1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.json;

    opens com.mycompany.mavenproject1 to javafx.fxml;
    exports com.mycompany.mavenproject1;
}
