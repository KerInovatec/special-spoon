package de.matchbox.server;

import de.matchbox.communication.shared.Room;
import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.shared.abiturklassen.List;
import de.matchbox.server.abiturklassen.Server;
import de.matchbox.server.net.Client;

public class StreichholzServer extends Server {

    private final Control control;
    private final List roomList;

    public StreichholzServer(int pPortNr, Control pControl) {
        super(pPortNr);
        this.control = pControl;
        this.roomList = new List();
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort) {
        if (this.containsClient(pClientIP, pClientPort)) {
            this.deleteClient(getClient(pClientIP, pClientPort));
        }
        this.addClient(pClientIP, pClientPort);
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage) {
        Gson lGsonObject = new StandardGsonBuilder().create();
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
            this.deleteClient(getClient(pClientIP, pClientPort));
        }
    }

    private Client getClient(String pIp, int pPort) {
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            if (this.roomList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.roomList.getObject();
                if (lClient.getIp().equals(pIp) && lClient.getPort() == pPort) {
                    return lClient;
                }
            }
            this.roomList.next();
        }

        this.addClient(pIp, pPort);
        return this.getClient(pIp, pPort);
    }

    private boolean containsClient(String pIp, int pPort) {
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            if (this.roomList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.roomList.getObject();
                if (lClient.equals(new Client(pIp, pPort, this))) {
                    return true;
                }
            }
            this.roomList.next();
        }
        return false;
    }

    private void deleteClient(Client pClient) {
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            if (this.roomList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.roomList.getObject();
                if (lClient.equals(pClient)) {
                    this.roomList.remove();
                    return;
                }
            }
            this.roomList.next();
        }
    }

    private void addClient(String pIp, int pPort) {
        this.roomList.append(new Client(pIp, pPort, this));
    }
    
    public boolean logoutClient(Client pClient){
        if(pClient == null || !this.containsClient(pClient.getIp(), pClient.getPort())) return false;
        this.deleteClient(pClient);
        return true;
    }
    
    public boolean createRoom(String pRoomName){
        if(pRoomName == null || this.containsRoom(pRoomName)) return false;
        this.roomList.append(new Room(pRoomName));
        return true;
    }
    
    private boolean containsRoom(String pRoomName){
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            if (this.roomList.getObject().getClass() == Room.class) {
                Room lRoom = (Room) this.roomList.getObject();
                if (pRoomName.equals(lRoom.getName())) {
                    return true;
                }
            }
            this.roomList.next();
        }
        return false;
    }
}
