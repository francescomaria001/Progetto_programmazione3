
package com.example.scene_;

import java.sql.Statement;
import controller.DatabaseService;
import controller.User;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

import controller.UserContext;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
/**
 * Controller per la schermata di login dell'applicazione.
 */
public class LoginController {

    // Elementi dell'interfaccia utente per il login utente
    @FXML
    private TextField UserName;
    @FXML
    private TextField UserPassword;
    @FXML
    private Button ButtonUser;

    // Elementi dell'interfaccia utente per il login admin
    @FXML
    private TextField AdminName;
    @FXML
    private TextField AdminPassword;
    @FXML
    private Button ButtonAdmin;

    // Elementi dell'interfaccia utente per la registrazione
    @FXML
    private Button ButtonRegister;

    // Informazioni per la connessione al database
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/twitter";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Matricola138";

    // Controller per la schermata di chat
    protected ChatController controller= new ChatController();

    /**
     * Costruttore vuoto della classe.
     */
    public LoginController() {
    }

    /**
     * Gestisce il click del pulsante di login utente.
     * Verifica le credenziali nel database e reindirizza alla schermata di ricerca se il login ha successo.
     * @param event L'evento di click del pulsante
     * @throws IOException Se si verifica un errore durante il caricamento della nuova scena
     */
    @FXML
    void handleLogin(ActionEvent event) throws IOException {
        System.out.println("Login button clicked");
        String enteredUsername = this.UserName.getText();
        String enteredPassword = this.UserPassword.getText();

        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT * FROM users WHERE Username = '"+enteredUsername+"' AND Password = '"+enteredPassword+"'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                System.out.println("logged "+ rs.getString("Username"));

                UserContext.getInstance().setLoggedInUser(enteredUsername);

                changeScene(event,"Search.fxml");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Gestisce il click del pulsante di login admin.
     * Verifica le credenziali nel database e reindirizza alla schermata di amministrazione se il login ha successo.
     * @param event L'evento di click del pulsante
     * @throws IOException Se si verifica un errore durante il caricamento della nuova scena
     */
    @FXML
    void handleAdminLogin(ActionEvent event) throws IOException {
        String enteredAdminName = this.AdminName.getText();
        String enteredAdminPassword = this.AdminPassword.getText();
        try {
            Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
            String query = "SELECT * FROM admin WHERE AdminName = '"+enteredAdminName+"' AND AdminPassword = '"+enteredAdminPassword+"'";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                System.out.println("logged "+ rs.getString("AdminName"));
                changeScene(event,"AdminPage.fxml");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Gestisce il click del pulsante di registrazione.
     * Reindirizza alla schermata di registrazione.
     * @param event L'evento di click del pulsante
     * @throws IOException Se si verifica un errore durante il caricamento della nuova scena
     */
    public void handleRegister(ActionEvent event) throws IOException {
        this.changeScene(event, "Register.fxml");
    }

    /**
     * Cambia la scena dell'applicazione.
     * @param event L'evento di click del pulsante
     * @param scena Il nome del file FXML della nuova scena
     * @throws IOException Se si verifica un errore durante il caricamento della nuova scena
     */
    public void changeScene(ActionEvent event, String scena) throws IOException {
        Parent root = FXMLLoader.load((URL)Objects.requireNonNull(this.getClass().getResource(scena)));
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
