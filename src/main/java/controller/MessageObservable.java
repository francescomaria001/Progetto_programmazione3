package controller;

import controller.Observable;
import controller.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe rappresenta un oggetto osservabile che può essere monitorato da vari observer.
 */
public class MessageObservable implements Observable {

    /** Lista degli observer registrati per questo oggetto osservabile. */
    protected List<Observer> observers = new ArrayList<>();

    /**
     * Aggiunge un observer alla lista degli osservatori.
     *
     * @param observer L'observer da aggiungere
     */
    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Rimuove un observer dalla lista degli osservatori.
     *
     * @param observer L'observer da rimuovere
     */
    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Notifica tutti gli osservatori registrati con un messaggio specificato.
     *
     * @param message Il messaggio da notificare agli osservatori
     */
    @Override
    public void notifyObservers(String message) {
        // Notifica tutti gli observer registrati
        for (Observer observer : observers) {
            observer.notify(message);
        }
    }
}

