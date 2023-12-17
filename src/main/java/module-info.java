module com.mycompany.cakebakery {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;

    opens com.mycompany.cakebakery to javafx.fxml;
    opens com.mycompany.cakebakery.Models to javafx.base;
    exports com.mycompany.cakebakery;
    
}
