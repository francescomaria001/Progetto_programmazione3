package com.example.scene_;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.Random;

/**
 * Controller per la schermata di registrazione dell'applicazione.
 */
public class RegistrationController {

    // Campo per l'inserimento della password durante la registrazione
    public TextField passwordRegister;

    // Campo per l'inserimento dell'username durante la registrazione
    @FXML
    private TextField UserRegister;

    // Campo per l'inserimento della password durante la registrazione
    @FXML
    private PasswordField PasswordRegister;

    // Pulsante per avviare la registrazione
    @FXML
    private Button BottonLOg;

    // Informazioni per la connessione al database
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/twitter";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Matricola138";

    /**
     * Gestisce il click del pulsante per la registrazione di un nuovo utente.
     * Effettua la registrazione nel database e reindirizza alla schermata di ricerca se la registrazione ha successo.
     * @param event L'evento di click del pulsante
     */
    @FXML
    void handleRegistration(ActionEvent event) {
        String username = UserRegister.getText();
        String password = passwordRegister.getText();

        if (isValid(username, password)) {
            try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
                String query = "INSERT INTO users (UserId, Username, Password) VALUES (?, ?, ?)";
                try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                    preparedStatement.setInt(1, new Random().nextInt());
                    preparedStatement.setString(2, username);
                    preparedStatement.setString(3, password);

                    int rowsAffected = preparedStatement.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Registrazione avvenuta con successo");
                        changeScene(event, "login.fxml");
                    } else {
                        System.out.println("Errore durante la registrazione");
                    }
                }
            } catch (SQLException | IOException ex) {
                ex.printStackTrace();
                throw new RuntimeException(ex);
            }
        } else {
            System.out.println("Username o password non validi");
        }
    }

    /**
     * Verifica se l'username e la password inseriti sono validi per la registrazione.
     * @param username L'username inserito
     * @param password La password inserita
     * @return true se l'username e la password sono validi, altrimenti false
     */
    private boolean isValid(String username, String password) {
        return !username.isEmpty() && !password.isEmpty();
    }

    /**
     * Cambia la scena dell'applicazione.
     * @param event L'evento di click del pulsante
     * @param scena Il nome del file FXML della nuova scena
     * @throws IOException Se si verifica un errore durante il caricamento della nuova scena
     */
    public void changeScene(ActionEvent event, String scena) throws IOException {
        Parent root = (Parent)FXMLLoader.load((URL) Objects.requireNonNull(this.getClass().getResource(scena)));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}



