package controller;
import controller.Message;

import java.util.Date;
import java.util.List;

/**
 * Questa interfaccia rappresenta una fabbrica per la creazione di oggetti di tipo Message.
 * Le classi che implementano questa interfaccia devono fornire un metodo per creare un nuovo messaggio.
 */
public interface MessageFactory {

    /**
     * Crea un nuovo oggetto Message con i dati specificati.
     *
     * @param sender    Il mittente del messaggio
     * @param timestamp Il timestamp del messaggio
     * @param content   Il contenuto del messaggio
     * @return Un nuovo oggetto Message creato con i dati forniti
     */
    Message createMessage(String sender, Date timestamp, String content);
}
