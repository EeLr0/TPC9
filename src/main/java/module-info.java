module com.example.tpc9 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.sql;
    requires mysql.connector.java;


    opens com.example.tpc9 to javafx.fxml;
    exports com.example.tpc9;
}