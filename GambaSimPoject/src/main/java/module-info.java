module gambasim.gambasimpoject {
    requires javafx.controls;
    requires javafx.fxml;


    opens gambasim.gambasimpoject to javafx.fxml;
    exports gambasim.gambasimpoject;
}