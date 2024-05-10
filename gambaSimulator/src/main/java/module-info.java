module gambasim.gambasimulator {
    requires javafx.controls;
    requires javafx.fxml;


    opens gambasim.gambasimulator to javafx.fxml;
    exports gambasim.gambasimulator;
    exports gambasim.gambasimulator.CoinFlip;

}