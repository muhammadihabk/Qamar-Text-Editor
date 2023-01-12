module Qamar {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
    
    // opens com.example to javafx.fxml, javafx.graphics;
    opens com.example to javafx.fxml;
    exports com.example;
}