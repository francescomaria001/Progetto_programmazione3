
package com.example.scene_;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.List;

/**
 * Classe controller per la vista Admin.
 */
public class AdminController {

    @FXML
    private TextField USerResearch;

    @FXML
    private ListView<String> UserSearch;

    @FXML
    private Button buttonDrop;

    @FXML
    private Button buttonCerca;

    // URL di connessione al database JDBC
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/twitter";

    // Nome utente del database
    private static final String DB_USER = "root";

    // Password del database
    private static final String DB_PASSWORD = "Matricola138";

    /**
     * Gestisce l'azione di ricerca.
     * Recupera i messaggi inviati dall'utente specificato dal database e li visualizza nella ListView.
     */
    @FXML
    void handleSearch() {
        String targetUsername = USerResearch.getText();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM messages WHERE SenderName = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, targetUsername);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    ObservableList<String> messageList = FXCollections.observableArrayList();
                    while (resultSet.next()) {
                        String messageContent = resultSet.getString("Content");
                        // Aggiunge il contenuto del messaggio alla lista
                        messageList.add(messageContent);
                    }
                    // Imposta la lista dei messaggi nella ListView
                    UserSearch.setItems(messageList);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gestisce l'azione di eliminazione.
     * Cancella l'utente specificato dal database insieme ai suoi messaggi.
     * Aggiorna la visualizzazione dei messaggi dopo l'eliminazione.
     */
    @FXML
    void handleDrop() {
        String targetUsername = USerResearch.getText();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String deleteUserQuery = "DELETE FROM users WHERE Username = ?";
            try (PreparedStatement deleteUserStatement = connection.prepareStatement(deleteUserQuery)) {
                deleteUserStatement.setString(1, targetUsername);
                deleteUserStatement.executeUpdate();
                System.out.println("Utente eliminato");
            }

            String deleteMessagesQuery = "DELETE FROM messages WHERE SenderName = ?";
            try (PreparedStatement deleteMessagesStatement = connection.prepareStatement(deleteMessagesQuery)) {
                deleteMessagesStatement.setString(1, targetUsername);
                deleteMessagesStatement.executeUpdate();
            }

            // Aggiorna la visualizzazione dei messaggi dopo l'eliminazione dell'utente
            handleSearch();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}





