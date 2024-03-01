---
title: Twitter
author: Luisi Francescomaria
---

# Introduzione

git Twitter è un progetto universitario di Programmazione 3 che consiste in un microbloddigng
    sviluppato su JavaFX con Scene Builder.

## Traccia

     Si vuole sviluppare un sistema per la gestione di un servizio di microblogging (Twitter). Twitter è un servizio di social networking che fornisce agli utenti, attraverso l’omonima piattaforma, una pagina personale aggiornabile tramite messaggi di testo con lunghezza massima di 140 caratteri.
     Ogni utente può avere un certo numero di follower che ricevono i suoi messaggi pubblicati. A sua volta esso può ricevere messaggi dagli utenti che segue (follower). I messaggi possono essere effettuati tramite il sito stesso, via SMS, con programmi di messaggistica istantanea e posta elettronica.
     Ogni messaggio può contenere un hashtag. I messaggi contenenti lo stesso hashtag possono essere categorizzanti insieme. Il sistema deve prevedere l’accesso sia in modalità amministratore che in modalità utente.
     L’amministratore può effettuare le seguenti operazioni
     eliminare un utente dal sistema. Automaticamente la comunicazione viene
     inviata a tutti i suoi follower
     visualizzare i messaggi per categorie in base agli hashtag
     L’utente può effettuare le seguenti operazioni
     registrarsi al servizio
     aggiungere un follower (utente che lui vuole seguire)
     inviare un messaggio (eventualmente contenente un hashtag) con una delle
     modalità precedentemente specificate
     Sviluppare il sistema di servizio di microblogging prevedendo un’interfaccia
     grafica per l’inserimento e la visualizzazione dei messaggi.

## Note di sviluppo:

    La prova d’esame richiede la progettazione e lo sviluppo della traccia proposta.
    Lo studente può scegliere di sviluppare il progetto nelle due modalità: Applicazione Web o programma standalone con supporto grafico.
    Il progetto deve essere sviluppato secondo le seguenti linee:
    - Usare almeno due pattern tra i design pattern noti;
    - Attenersi ai principi della programmazione SOLID;
    - Usare il linguaggio Java;
    - Inserire sufficienti commenti (anche per Javadoc) e annotazioni;
    - Gestione delle eccezioni;
    - Usare i file o database;
    È possibile costruire l'applicazione standalone con supporto grafico tramite l'utilizzo di strumenti per
    la realizzazione di interfacce grafiche presenti in molti IDE (GUI Designer in IntelliJ e WindowsBuilder in Eclipse)
    oppure utilizzare tools compatibili con JavaFx come Scene Builder (compatibile con gli IDE).

# Implementazione

Il progetto è un'applicazione JavaFX per la gestione di un sistema di messaggistica 
simile a Twitter. L'applicazione consente agli utenti di inviare messaggi ad altri utenti registrati nel sistema e  offre funzionalità di ricerca e eliminazione degli utenti e dei relativi messaggi.
    L'applicazione viene sviluppata seguendo per ogni scena dei relativi controller e un ragionamento 
    univoco per quella singola scena volto a garantire il corretto e completo svolgimento dei requisiti richiesti.
    Attorno alla parte grafica nonchè le scene , ovvero cio che vedrà il fruitore dell applicazione, sono stati utilizzati:
    -Controller:Utilizzati per la gestione d'eventi , e per andare a dare coesione al mio codice.
    -MySql: per la gestione di un database e andare ad effettura la creazione/manipolazione dei dati inseriti dall'utente.
    - Classi/ interfacce: per la gestione dell utente e dei dati da essso inseriti.
 
# Controller
I controller utilizzati sono AdminPage.fxml, Chatt.fxml, login.fxml, Register.fxml, Search.fxml e sono rispettivamente I controller per queste scene:
### Login.fxml
![LoginPage](login.png)

All'interno di qeusta pagina il controller va a gestire 3 tipologie d'eventi, cioè il cambiamento di scena dettato da 3 diversi pulsanti che possono esser premuti, 


### AdminPage.fxml
![AdminPage](Admin_page.png)

Mentre questa pagina serve a garantire che tutte le funzioni che un Admin può fare siano rispettate, 
cioè : 
-La cancellazione di un utente
-Visualizzazione di tutti i messaggi mandati dall'utente ricercato dall Admin

### Search.fxml
![SearchPage](Search.png)

ricerca degli utenti e alla visualizzazione dei messaggi inviati da un utente specifico.


### Chat.fxml
![ChatPage](chat.png)

gestisce l'interfaccia utente per la pagina del singolo utente, consentendo loro di inviare e ricevere messaggi, gestire l'accesso e garantire che l'interfaccia utente sia sempre aggiornata con i messaggi più recenti.

# Patterns
I pattern utilizzati sono tre:
- Factory Method Pattern;
- Singleton  Pattern;
- Observer Pattern;
