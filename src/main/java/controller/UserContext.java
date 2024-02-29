package controller;

/**
 * Questa classe gestisce il contesto dell'utente attualmente loggato.
 * È implementata come un singleton.
 */
public class UserContext {
    private static UserContext instance;
    private String loggedInUser;

    /**
     * Costruttore privato per evitare l'istanziazione diretta dell'oggetto.
     */
    private UserContext() {}

    /**
     * Restituisce l'istanza corrente del contesto utente.
     * Se non esiste, ne crea una nuova.
     *
     * @return L'istanza corrente del contesto utente.
     */
    public static synchronized UserContext getInstance() {
        if (instance == null) {
            instance = new UserContext();
        }
        return instance;
    }

    /**
     * Restituisce l'utente attualmente loggato.
     *
     * @return Il nome dell'utente attualmente loggato.
     */
    public String getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Imposta l'utente attualmente loggato.
     *
     * @param loggedInUser Il nome dell'utente da impostare come attualmente loggato.
     */
    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
}

