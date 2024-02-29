
/**
 * La classe ChatController controlla le funzionalità di un'interfaccia di chat.
 * Gestisce l'invio di messaggi, il seguire/non seguire gli utenti e l'aggiornamento della chat.
 */
package com.example.scene_;

import controller.*;
import javafx.fxml.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * La classe ChatController controlla le funzionalità di un'interfaccia di chat.
 * Gestisce l'invio di messaggi, il seguire/non seguire gli utenti e l'aggiornamento della chat.
 */
public class ChatController {

    /** L'AnchorPane per la casella di input dei messaggi. */
    @FXML
    public AnchorPane MessageInputBox;

    /** Il TextArea per visualizzare i messaggi della chat. */
    @FXML
    private TextArea ChatBox;

    /** Il TextField per inserire i messaggi. */
    @FXML
    private TextField MessageInputTextField;

    /** Il pulsante per inviare i messaggi. */
    @FXML
    private Button SendButton;

    /** Il pulsante per seguire/non seguire gli utenti. */
    @FXML
    private Button followButton;

    /** L'utente selezionato per l'interazione. */
    protected String selectedUser;

    /** L'utente loggato. */
    private String loggedInUser;

    /** La factory per creare i messaggi. */
    MessageFactory messageFactory = new TextMessageFactory();

    /** L'URL JDBC per la connessione al database. */
    private static final String JDBC_URL = "jdbc:mysql://127.0.0.1:3306/twitter";

    /** Lo username del database. */
    private static final String DB_USER = "root";

    /** La password del database. */
    private static final String DB_PASSWORD = "Matricola138";

    /** L'osservatore per la casella di chat. */
    ChatBoxObserver chatBoxObserver;

    /**
     * Inizializza il controller.
     */
    public void initialize() {
        loggedInUser = UserContext.getInstance().getLoggedInUser();
        chatBoxObserver = new ChatBoxObserver(ChatBox);
    }

    /**
     * Gestisce l'azione quando viene cliccato il pulsante di invio.
     */
    @FXML
    private void handleSendButton() {
        String messageText = MessageInputTextField.getText();
        Date timestamp = new Date();
        Message message = messageFactory.createMessage(loggedInUser, timestamp, messageText);
        System.out.println("Invio del messaggio: " + message.getContent());
        MessageInputTextField.clear();
    System.out.print(timestamp);
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO messages (idmessages, content, senderName, time) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, new Random().nextInt());
                preparedStatement.setString(2, message.getContent());
                preparedStatement.setString(3, loggedInUser);
                preparedStatement.setString(4, String.valueOf(message.getTimestamp()));
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        notifyObserver(loggedInUser + ": " + messageText);
    }

    /**
     * Imposta l'utente selezionato.
     * @param selectedUser L'utente selezionato da impostare.
     */
    public void setSelectedUser(String selectedUser) {
        this.selectedUser = selectedUser;
    }

    /**
     * Gestisce l'azione quando viene cliccato il pulsante di seguire/non seguire.
     */
    @FXML
    private void handleFollowButton() {
        String userToFollow = selectedUser;
        String loggedInUser = UserContext.getInstance().getLoggedInUser();

        if (loggedInUser != null) {
            User currentUser = DatabaseService.getUser(loggedInUser);
            if (currentUser != null && userToFollow != null) {
                if (followButton.getText().equals("Segui")) {
                    currentUser.followUser(userToFollow);
                    followButton.setText("Non Seguire");
                    System.out.print("Hai seguito l'utente");
                } else {
                    currentUser.unfollowUser(userToFollow);
                    followButton.setText("Segui");
                    System.out.print("Hai smesso di seguire l'utente");
                }
            } else {
                System.out.println("Errore: utente corrente o utente da seguire non trovato.");
            }
        } else {
            System.out.println("Errore: nessun utente loggato.");
        }
    }

    /**
     * Notifica l'osservatore con il messaggio fornito.
     * @param message Il messaggio da notificare all'osservatore.
     */
    private void notifyObserver(String message) {
        chatBoxObserver.notify(message);
    }
}


