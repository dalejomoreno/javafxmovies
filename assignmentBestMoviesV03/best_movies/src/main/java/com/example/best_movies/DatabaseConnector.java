package com.example.best_movies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {
    // Database connection parameters
    private static final String URL = "jdbc:mysql://localhost:3306/movies";
    private static final String USER = "root";
    private static final String PASS = "";

    // Method to establish a connection to the database
    public Connection connect() {
        try {
            // Establishing a connection using DriverManager
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            // Handling connection errors
            throw new RuntimeException("Error connecting to the database", e);
        }
    }
}
