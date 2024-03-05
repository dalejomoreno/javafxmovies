module com.example.assigm_artist {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.best_movies to javafx.fxml;
    exports com.example.best_movies;
}