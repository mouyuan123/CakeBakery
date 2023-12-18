package com.mycompany.cakebakery;

import java.io.IOException;
import javafx.fxml.FXML;

public class SecondaryController {

    @FXML
    private void switchToPrimary() throws IOException {
        CakeBakeryApplication.setRoot("primary");
    }
}