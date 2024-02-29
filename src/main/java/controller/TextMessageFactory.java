package controller;

import java.util.Date;
import java.util.List;

public class TextMessageFactory implements MessageFactory {
    /**
     * Crea un nuovo oggetto TextMessage con i dettagli specificati.
     *
     * @param sender    Il mittente del messaggio.
     * @param timestamp La data e l'ora di invio del messaggio.
     * @param content   Il contenuto del messaggio di testo.
     */
    @Override
    public Message createMessage(String sender, Date timestamp, String content) {
            return new TextMessage(sender, timestamp,  content);


    }

}
