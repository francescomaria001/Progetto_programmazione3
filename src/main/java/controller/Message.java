package controller;

import java.util.Date;
import java.util.List;

/**
 * Questa classe rappresenta un messaggio generico.
 */
public abstract class Message {

    // Nome dell'utente mittente del messaggio
    protected String sender;

    // Testo del messaggio
    private String text;

    // Timestamp del messaggio
    private Date timestamp;

    /**
     * Costruttore della classe Message.
     * @param sender Il nome dell'utente mittente del messaggio
     * @param timestamp Il timestamp del messaggio
     * @param text Il testo del messaggio
     */
    public Message(String sender, Date timestamp, String text) {
        this.sender = sender;
        this.text = text;
        this.timestamp = timestamp;
    }

    /**
     * Restituisce il contenuto del messaggio.
     * @return Il testo del messaggio
     */
    public String getContent() {
        return text;
    }

    /**
     * Restituisce il mittente del messaggio.
     * @return Il nome dell'utente mittente
     */
    public String getSender() {
        return sender;
    }

    /**
     * Restituisce il timestamp del messaggio.
     * @return Il timestamp del messaggio
     */
    public Date getTimestamp() {
        return timestamp;
    }
}


