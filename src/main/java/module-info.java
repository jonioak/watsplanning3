module com.example.watsplanning3 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.watsplanning3 to javafx.fxml;
    exports com.example.watsplanning3;
}