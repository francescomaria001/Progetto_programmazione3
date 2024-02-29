package controller;

/**
 * Interfaccia che definisce un oggetto osservabile che può essere monitorato da vari observer.
 */
interface Observable {

    /**
     * Aggiunge un observer alla lista degli osservatori.
     *
     * @param observer L'observer da aggiungere
     */
    void addObserver(Observer observer);

    /**
     * Rimuove un observer dalla lista degli osservatori.
     *
     * @param observer L'observer da rimuovere
     */
    void removeObserver(Observer observer);

    /**
     * Notifica tutti gli osservatori registrati con un messaggio specificato.
     *
     * @param message Il messaggio da notificare agli osservatori
     */
    void notifyObservers(String message);
}

