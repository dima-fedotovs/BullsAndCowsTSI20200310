module tsi.javacourses {
    requires javafx.controls;
    requires javafx.fxml;

    opens tsi.javacourses to javafx.fxml;
    exports tsi.javacourses;
}