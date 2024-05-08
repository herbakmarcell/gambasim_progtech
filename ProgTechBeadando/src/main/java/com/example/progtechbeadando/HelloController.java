package com.example.progtechbeadando;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onRouletteButtonClick() {
        welcomeText.setText("Roulette");
    }
    @FXML
    protected void onBlackJackButtonClick() {
        welcomeText.setText("Black Jack");
    }

}