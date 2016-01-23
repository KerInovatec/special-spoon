package de.streichholzprojekt.server;

import de.streichholzprojekt.server.abiturklassen.List;
import de.streichholzprojekt.server.abiturklassen.Server;
import de.streichholzprojekt.server.enumeration.MessageType;
import de.streichholzprojekt.server.net.Client;
import de.streichholzprojekt.server.utility.dictionary.StringToEnum;

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
        String[] lMessage;
        if (pMessage.contains(" ")) {
            lMessage = pMessage.split(" ");
        } else {
            lMessage = new String[]{pMessage};
        }

        MessageType lMessageType;
        if (StringToEnum.MessageTypeDictionary.containsKey(lMessage[0])) {
            lMessageType = StringToEnum.MessageTypeDictionary.get(lMessage[0]);
        } else {
            lMessageType = MessageType.UNKOWN;
        }

        this.control.process(lMessageType, lMessage, this.getClient(pClientIP, pClientPort));
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
