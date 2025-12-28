module ec.edu.espoch.arbolfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens ec.edu.espoch.arbolfx to javafx.fxml;
    opens ec.edu.espoch.arbolfx.controller to javafx.fxml;
    exports ec.edu.espoch.arbolfx.controller;
    exports ec.edu.espoch.arbolfx.model;
    exports ec.edu.espoch.arbolfx.view;
    exports ec.edu.espoch.arbolfx;
}
