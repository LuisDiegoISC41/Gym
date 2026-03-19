module gimnasio {
    requires javafx.controls;
    requires javafx.fxml;

    opens gimnasio to javafx.fxml;
    exports gimnasio;
}
