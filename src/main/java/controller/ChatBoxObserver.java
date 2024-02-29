package controller;

import javafx.scene.control.TextArea;

/**
 * Questa classe rappresenta un osservatore per la chat box.
 * Si occupa di aggiornare la chat box con nuovi messaggi.
 */
public class ChatBoxObserver implements Observer {

    // Area di testo della chat
    protected TextArea chatBox;

    /**
     * Costruttore per il ChatBoxObserver.
     * @param chatBox L'area di testo della chat da osservare
     */
    public ChatBoxObserver(TextArea chatBox) {
        this.chatBox = chatBox;
    }

    /**
     * Metodo di aggiornamento per l'osservatore.
     * Non utilizzato in questa implementazione.
     * @param data I dati dell'aggiornamento
     */
    @Override
    public void update(Object data) {
        // Non utilizzato in questa implementazione
    }

    /**
     * Notifica l'osservatore con un nuovo messaggio.
     * Aggiorna la chat box con il messaggio ricevuto.
     * @param message Il messaggio da aggiungere alla chat box
     */
    @Override
    public void notify(String message) {
        // Aggiorna la chat box con il nuovo messaggio
        chatBox.appendText(message + "\n");
    }

    /**
     * Metodo di aggiornamento per l'osservatore.
     * Non utilizzato in questa implementazione.
     * @param message Il messaggio di aggiornamento
     */
    @Override
    public void update(String message) {
        // Non utilizzato in questa implementazione
    }
}

