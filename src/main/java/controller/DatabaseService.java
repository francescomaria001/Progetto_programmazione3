package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe fornisce servizi di accesso al database per la gestione degli utenti.
 */
public class DatabaseService {

    // URL di connessione al database
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/twitter";
    // Nome utente del database
    private static final String DB_USER = "root";
    // Password del database
    private static final String DB_PASSWORD = "Matricola138";

    /**
     * Verifica se un utente è valido nel sistema.
     * @param username Il nome utente da verificare
     * @param password La password associata all'utente
     * @return true se l'utente è valido, altrimenti false
     */
    public static boolean isValidUser(String username, String password) {
        // Implementazione attualmente vuota
        return false;
    }

    /**
     * Ottiene un oggetto User dal database dato un nome utente.
     * @param username Il nome utente dell'utente da ottenere
     * @return Un oggetto User corrispondente al nome utente specificato, o null se non trovato
     */
    public static User getUser(String username) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE Username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);

                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        return new User(resultSet.getString("Username"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Ottiene una lista di tutti gli utenti dal database.
     * @return Una lista di nomi utente di tutti gli utenti nel database
     */
    public static List<String> getAllUsers() {
        List<String> allUsers = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT Username FROM users";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    while (resultSet.next()) {
                        String username = resultSet.getString("Username");
                        allUsers.add(username);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allUsers;
    }
}


