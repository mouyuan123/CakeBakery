module com.mycompany.cakebakery {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.cakebakery to javafx.fxml;
    exports com.mycompany.cakebakery;
    requires javafx.graphics;
    requires javafx.media;
}
