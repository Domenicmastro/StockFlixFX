module com.example.stockflixfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.stockflixfx to javafx.fxml;
    exports com.example.stockflixfx;
}