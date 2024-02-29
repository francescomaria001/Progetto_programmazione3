package controller;

import java.util.Date;
import java.util.List;

/**
 * Rappresenta un messaggio di testo.
 */
public class TextMessage extends Message {

    /**
     * Crea un nuovo oggetto TextMessage con i dettagli specificati.
     *
     * @param sender    Il mittente del messaggio
     * @param timestamp La data e l'ora di invio del messaggio
     * @param content   Il contenuto del messaggio di testo
     */
    public TextMessage(String sender, Date timestamp, String content) {
        super(sender, timestamp, content);
    }
}


