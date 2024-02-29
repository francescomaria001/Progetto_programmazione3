package controller;

/**
 * Interfaccia che definisce il comportamento di un observer.
 *
 * @param <T> Il tipo di dato che l'observer osserva
 */
public interface Observer<T> {

    /**
     * Metodo chiamato quando l'observable notifica l'observer con un aggiornamento.
     *
     * @param data I dati aggiornati
     */
    void update(T data);

    /**
     * Metodo chiamato quando l'observable notifica l'observer con un messaggio.
     *
     * @param message Il messaggio notificato
     */
    void notify(String message);

    /**
     * Metodo chiamato quando l'observable notifica l'observer con un aggiornamento di tipo stringa.
     *
     * @param message L'aggiornamento sotto forma di stringa
     */
    void update(String message);
}

