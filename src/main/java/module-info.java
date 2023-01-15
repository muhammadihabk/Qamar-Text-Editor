module QamarKeez {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    opens com.example to javafx.fxml;
    exports com.example;
}