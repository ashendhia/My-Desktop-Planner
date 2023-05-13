module tp.javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens tp.javafx to javafx.fxml;
    exports tp.javafx;
    exports tp.javafx.controllers;
    opens tp.javafx.controllers to javafx.fxml;
}