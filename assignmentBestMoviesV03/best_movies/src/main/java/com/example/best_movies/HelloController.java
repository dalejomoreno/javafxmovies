package com.example.best_movies;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;

public class HelloController {

    // Connector to interact with the database
    @FXML
    private DatabaseConnector dbConnector = new DatabaseConnector();

    // Reference to the table view in the FXML file
    @FXML
    private TableView<Movies> moviesTable;

    // Table columns defined in the FXML file
    @FXML
    private TableColumn<Movies, Integer> idColumn;
    @FXML
    private TableColumn<Movies, String> videoColumn;
    @FXML
    private TableColumn<Movies, Integer> release_yearColumn;
    @FXML
    private TableColumn<Movies, String> genreColumn;
    @FXML
    private TableColumn<Movies, Integer> languageColumn;
    @FXML
    private TableColumn<Movies, String> budgetColumn;
    @FXML
    private TableColumn<Movies, Integer> box_officeColumn;

    @FXML
    private void initialize() {
        // Set up cell value factories to populate the table columns
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        videoColumn.setCellValueFactory(new PropertyValueFactory<>("movie"));
        release_yearColumn.setCellValueFactory(new PropertyValueFactory<>("release_year"));
        genreColumn.setCellValueFactory(new PropertyValueFactory<>("genre"));
        languageColumn.setCellValueFactory(new PropertyValueFactory<>("language"));
        budgetColumn.setCellValueFactory(new PropertyValueFactory<>("budget"));
        box_officeColumn.setCellValueFactory(new PropertyValueFactory<>("box_office"));

        // Retrieve data from the database and set it to the table
        Movies movies = new Movies();
        ObservableList<Movies> items = movies.getMoviesFromDatabase();
        this.moviesTable.setItems(items);
    }

    // Methods to handle button events

    @FXML
    public void tableViewButton(ActionEvent actionEvent) throws IOException {
        // Load the table view scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tableview.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void moneyRaisedButton(ActionEvent actionEvent) throws IOException {
        // Load the YouTube views scene
        FXMLLoader loader = new FXMLLoader(getClass().getResource("budget.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void genreViewButton(ActionEvent actionEvent) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("genreview.fxml"));
        Scene scene = new Scene(loader.load());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
