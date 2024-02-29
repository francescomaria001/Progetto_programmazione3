package controller;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta un utente nel sistema.
 */
public class User {
    private String username;
    private List<String> followers;
    private List<String> messagesReceived;

    /**
     * Crea un nuovo oggetto User con il nome utente specificato.
     *
     * @param username Il nome utente dell'utente.
     */
    public User(String username) {
        this.username = username;
        this.followers = new ArrayList<>();
        this.messagesReceived = new ArrayList<>();
    }

    /**
     * Restituisce il nome utente dell'utente.
     *
     * @return Il nome utente dell'utente.
     */
    public String getUsername() {
        return username;
    }

    /**
     * Restituisce la lista dei follower dell'utente.
     *
     * @return La lista dei follower dell'utente.
     */
    public List<String> getFollowers() {
        return followers;
    }

    /**
     * Restituisce la lista dei messaggi ricevuti dall'utente.
     *
     * @return La lista dei messaggi ricevuti dall'utente.
     */
    public List<String> getMessagesReceived() {
        return messagesReceived;
    }

    /**
     * Segue un altro utente aggiungendolo alla lista dei follower.
     *
     * @param userToFollow Il nome utente dell'utente da seguire.
     */
    public void followUser(String userToFollow) {
        if (!followers.contains(userToFollow)) {
            followers.add(userToFollow);
        }
    }

    /**
     * Smette di seguire un altro utente rimuovendolo dalla lista dei follower.
     *
     * @param userToUnfollow Il nome utente dell'utente da smettere di seguire.
     */
    public void unfollowUser(String userToUnfollow) {
        followers.remove(userToUnfollow);
    }
}


