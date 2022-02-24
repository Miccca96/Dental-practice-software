/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Klijent;
import domain.StavkaTermina;
import domain.Termin;
import domain.Usluga;
import domain.Zubar;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author PC
 */
public class ClientController {

    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if (instance == null) {
            instance = new ClientController();
        }
        return instance;
    }

    public Zubar login(Zubar zubar) throws Exception {
        return (Zubar) sendRequest(Operation.LOGIN, zubar);
    }

    public void addKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.ADD_KLIJENT, klijent);
    }
    
    public void addTermin(Termin termin) throws Exception {
        sendRequest(Operation.ADD_TERMIN, termin);
    }
    
    public void addStavkaTermina(StavkaTermina stavkaTermina) throws Exception {
        sendRequest(Operation.ADD_STAVKA_TERMINA, stavkaTermina);
    }

    public void deleteKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.DELETE_KLIJENT, klijent);
    }
    
    public void deleteTermin(Termin termin) throws Exception {
        sendRequest(Operation.DELETE_TERMIN, termin);
    }
    
    public void deleteStavkaTermina(StavkaTermina stavkaTermina) throws Exception {
        sendRequest(Operation.DELETE_STAVKA_TERMINA, stavkaTermina);
    }

    public void updateKlijent(Klijent klijent) throws Exception {
        sendRequest(Operation.UPDATE_KLIJENT, klijent);
    }
    
    public void updateTermin(Termin termin) throws Exception {
        sendRequest(Operation.UPDATE_TERMIN, termin);
    }

    public ArrayList<Zubar> getAllZubar() throws Exception {
        return (ArrayList<Zubar>) sendRequest(Operation.GET_ALL_ZUBAR, null);
    }
    
    public ArrayList<Klijent> getAllKlijent() throws Exception {
        return (ArrayList<Klijent>) sendRequest(Operation.GET_ALL_KLIJENT, null);
    }
    
    public ArrayList<Termin> getAllTermin() throws Exception {
        return (ArrayList<Termin>) sendRequest(Operation.GET_ALL_TERMIN, null);
    }
    
    public ArrayList<StavkaTermina> getAllStavkaTermina(Termin t) throws Exception {
        return (ArrayList<StavkaTermina>) sendRequest(Operation.GET_ALL_STAVKA_TERMINA, t);
    }
    
    public ArrayList<Usluga> getAllUsluga() throws Exception {
        return (ArrayList<Usluga>) sendRequest(Operation.GET_ALL_USLUGA, null);
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        Request req = new Request(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(req);
        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response res = (Response) in.readObject();
        if (res.getResponseStatus().equals(ResponseStatus.Error)) {
            throw res.getError();
        } else {
            return res.getData();
        }
    }
    
}
