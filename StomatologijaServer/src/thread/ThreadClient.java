/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Klijent;
import domain.StavkaTermina;
import domain.Termin;
import domain.Zubar;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author PC
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request request = (Request) in.readObject();
                Response response = handleRequest(request);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(response);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request request) {
        Response response = new Response(null, null, ResponseStatus.Success);
        try {
            switch (request.getOperation()) {
                case Operation.ADD_KLIJENT:
                    ServerController.getInstance().addKlijent((Klijent) request.getData());
                    break;
                case Operation.ADD_TERMIN:
                    ServerController.getInstance().addTermin((Termin) request.getData());
                    break;
                case Operation.ADD_STAVKA_TERMINA:
                    ServerController.getInstance().addStavkaTermina((StavkaTermina) request.getData());
                    break;
                case Operation.DELETE_KLIJENT:
                    ServerController.getInstance().deleteKlijent((Klijent) request.getData());
                    break;
                case Operation.DELETE_TERMIN:
                    ServerController.getInstance().deleteTermin((Termin) request.getData());
                    break;
                case Operation.DELETE_STAVKA_TERMINA:
                    ServerController.getInstance().deleteStavkaTermina((StavkaTermina) request.getData());
                    break;
                case Operation.UPDATE_KLIJENT:
                    ServerController.getInstance().updateKlijent((Klijent) request.getData());
                    break;
                case Operation.UPDATE_TERMIN:
                    ServerController.getInstance().updateTermin((Termin) request.getData());
                    break;
                case Operation.GET_ALL_ZUBAR:
                    response.setData(ServerController.getInstance().getAllZubar());
                    break;
                case Operation.GET_ALL_KLIJENT:
                    response.setData(ServerController.getInstance().getAllKlijent());
                    break;
                case Operation.GET_ALL_USLUGA:
                    response.setData(ServerController.getInstance().getAllUsluga());
                    break;
                case Operation.GET_ALL_TERMIN:
                    response.setData(ServerController.getInstance().getAllTermin());
                    break;
                case Operation.GET_ALL_STAVKA_TERMINA:
                    response.setData(ServerController.getInstance().getAllStavkaTermina((Termin)request.getData()));
                    break;
                case Operation.LOGIN:
                    ArrayList<Zubar> zubari = ServerController.getInstance().getAllZubar();
                    Zubar z = (Zubar) request.getData();
                    for (Zubar zubar : zubari) {
                        if (zubar.getUsername().equals(z.getUsername())
                                && zubar.getPassword().equals(z.getPassword())) {
                            response.setData(zubar);
                        }
                    }
                    if (response.getData() == null) {
                        throw new Exception("Ne postoji zubar sa tim kredencijalima.");
                    } else {
                        break;
                    }
                default:
                    return null;
            }
        } catch (Exception e) {
            response.setError(e);
            response.setResponseStatus(ResponseStatus.Error);
        }
        return response;
    }

}
