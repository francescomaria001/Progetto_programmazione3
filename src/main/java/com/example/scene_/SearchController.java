package com.example.scene_;

import controller.User;
import controller.DatabaseService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

/**
 * Controller per la schermata di ricerca degli utenti.
 */
public class SearchController {

    // Campo per l'elenco degli utenti visualizzato nella ListView
    @FXML
    private ListView<String> ListUser;

    // Campo per l'inserimento dell'ID di ricerca dell'utente
    @FXML
    private TextField searchid;

    // Riferimento al controller della schermata di chat
    private ChatController id;

    /**
     * Metodo chiamato all'avvio per inizializzare la schermata di ricerca.
     * Mostra l'elenco degli utenti nella ListView e gestisce il click sull'elenco.
     */
    @FXML
    public void initialize() {
        refreshUserList();

        // Gestisce il click sull'elenco degli utenti
        ListUser.setOnMouseClicked(event -> {
            if (event.getClickCount() == 1) {
                handleUserSelection();
            }
        });
    }

    /**
     * Gestisce il click sul pulsante di ricerca.
     * Cerca l'utente inserito e aggiorna l'elenco degli utenti visualizzati.
     */
    @FXML
    private void onSearchButtonClicked() {
        String usernameToSearch = searchid.getText();
        User searchedUser = DatabaseService.getUser(usernameToSearch);

        if (searchedUser != null) {
            ListUser.getItems().clear();
            ListUser.getItems().add(searchedUser.getUsername());
        } else {
            System.out.println("Utente non trovato.");
        }
    }

    /**
     * Gestisce la selezione di un utente dall'elenco.
     * Cambia la scena alla schermata di chat, passando il nome dell'utente selezionato.
     */
    private void handleUserSelection() {
        String selectedUsername = ListUser.getSelectionModel().getSelectedItem();
        if (selectedUsername != null) {
            changeScene("Chatt.fxml", selectedUsername);
        }
    }

    /**
     * Aggiorna l'elenco degli utenti nella ListView.
     */
    private void refreshUserList() {
        List<String> allUsers = DatabaseService.getAllUsers();
        ListUser.getItems().clear();
        ListUser.getItems().addAll(allUsers);
    }

    /**
     * Cambia la scena alla schermata di chat.
     * @param fxmlFile Il nome del file FXML della nuova scena
     * @param selectedUsername Il nome dell'utente selezionato
     */
    private void changeScene(String fxmlFile, String selectedUsername) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();

            // Ottieni il controller della nuova scena (ChatController)
            ChatController chatController = loader.getController();

            // Passa il nome dell'utente selezionato al ChatController
            chatController.setSelectedUser(selectedUsername);

            // Ottiene la scena corrente
            Scene currentScene = ListUser.getScene();

            // Imposta la nuova scena sulla finestra principale
            Stage primaryStage = (Stage) currentScene.getWindow();
            primaryStage.setScene(new Scene(root));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

