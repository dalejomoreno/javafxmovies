package com.example.best_movies;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movies {
    private Integer id;
    private String movie;
    private Integer release_year;
    private String genre;
    private String language;
    private Integer budget;
    private Integer box_office;

    // Default constructor
    public Movies() {
    }

    // Parameterized constructor
    public Movies(Integer id, String movie, Integer release_year, String genre, String language, Integer budget, Integer box_office) {
        this.id = id;
        this.movie = movie;
        this.release_year = release_year;
        this.genre = genre;
        this.language = language;
        this.budget = budget;
        this.box_office = box_office;
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public Integer getRelease_year() {
        return release_year;
    }

    public void setRelease_year(Integer release_year) {
        this.release_year = release_year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getBudget() {
        return budget;
    }

    public void setBudget(Integer budget) {
        this.budget = budget;
    }

    public Integer getBox_office() {
        return box_office;
    }

    public void setBox_office(Integer box_office) {
        this.box_office = box_office;
    }

    // Database connection and data retrieval
    DatabaseConnector dbConnector = new DatabaseConnector();

    // Method to retrieve movies' data from the database
    public ObservableList<Movies> getMoviesFromDatabase() {
        ObservableList<Movies> moviesList = FXCollections.observableArrayList();

        try {
            // Establishing a database connection
            Connection connection = dbConnector.connect();
            String SQL = "SELECT * FROM movies";
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery(SQL);

            // Iterating through the result set and adding movies to the list
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String movie = resultSet.getString("movie");
                Integer release_year = resultSet.getInt("release_year");
                String genre = resultSet.getString("genre");
                String language = resultSet.getString("language");
                Integer budget = resultSet.getInt("budget");
                Integer box_office = resultSet.getInt("box_office");

                Movies movieEntry = new Movies(id, movie, release_year, genre, language, budget, box_office);
                moviesList.add(movieEntry);
            }

            // Closing resources
            stmt.close();
            resultSet.close();
            connection.close();
        } catch (SQLException e) {
            // Handling database errors
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Database Error");
            alert.setContentText("Error retrieving data from the database: " + e.getMessage());
            alert.showAndWait();
        }

        return moviesList;
    }
}
