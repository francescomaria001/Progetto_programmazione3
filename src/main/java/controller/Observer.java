package controller;

/**
 * Interfaccia che definisce il comportamento di un observer.
 *
 * @param <T> Il tipo di dato che l'observer osserva
 */
public interface Observer<T> {

    /**
     * Metodo chiamato quando l'observable notifica l'observer con un messaggio.
     *
     * @param message Il messaggio notificato
     */
    void notify(String message);

}

