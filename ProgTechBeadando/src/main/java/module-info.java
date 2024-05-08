module com.example.progtechbeadando {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.progtechbeadando to javafx.fxml;
    exports com.example.progtechbeadando;
}