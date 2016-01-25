package de.matchbox.server;

import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.contentobjects.ErrorContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.server.abiturklassen.List;
import de.matchbox.server.abiturklassen.Server;
import de.matchbox.server.net.Client;

public class StreichholzServer extends Server {

    private final Control control;
    private final List clientList;

    public StreichholzServer(int pPortNr, Control pControl) {
        super(pPortNr);
        this.control = pControl;
        this.clientList = new List();
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        if (this.containsClient(pClientIP, pClientPort)) {
            this.deleteClient(pClientIP, pClientPort);
        }

        this.addClient(pClientIP, pClientPort);
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        Gson lGsonObject = new Gson();
        try {
            MessageObject lMessageObject = lGsonObject.fromJson(pMessage, MessageObject.class);
            this.control.process(lMessageObject, this.getClient(pClientIP, pClientPort), this);
        } catch (Exception ex) {
            this.send(pClientIP, pClientPort, lGsonObject.toJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR))));
        }
    }

    @Override
    public void processClosedConnection(String pClientIP, int pClientPort) {
        if (this.containsClient(pClientIP, pClientPort)) {
            this.deleteClient(pClientIP, pClientPort);
        }
    }

    private Client getClient(String pIp, int pPort) {
        this.clientList.toFirst();
        while (this.clientList.hasAccess()) {
            if (this.clientList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.clientList.getObject();
                if (lClient.getIp().equals(pIp) && lClient.getPort() == pPort) {
                    return lClient;
                }
            }
            this.clientList.next();
        }

        this.addClient(pIp, pPort);
        return this.getClient(pIp, pPort);
    }

    private boolean containsClient(String pIp, int pPort) {
        this.clientList.toFirst();
        while (this.clientList.hasAccess()) {
            if (this.clientList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.clientList.getObject();
                if (lClient.getIp().equals(pIp) && lClient.getPort() == pPort) {
                    return true;
                }
            }
            this.clientList.next();
        }
        return false;
    }

    private void deleteClient(String pIp, int pPort) {
        this.clientList.toFirst();
        while (this.clientList.hasAccess()) {
            if (this.clientList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.clientList.getObject();
                if (lClient.getIp().equals(pIp) && lClient.getPort() == pPort) {
                    this.clientList.remove();
                    return;
                }
            }
            this.clientList.next();
        }
    }

    private void addClient(String pIp, int pPort) {
        this.clientList.append(new Client(pIp, pPort, this));
    }
}