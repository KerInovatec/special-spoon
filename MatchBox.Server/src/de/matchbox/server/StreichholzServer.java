package de.matchbox.server;

import de.matchbox.server.net.Room;
import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.classmodels.RoomModel;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.shared.abiturklassen.List;
import de.matchbox.server.abiturklassen.Server;
import de.matchbox.server.net.Client;

public class StreichholzServer extends Server {

    private final Control control;
    private final List roomList;
    private final List clientList;

    public StreichholzServer(int pPortNr, Control pControl) {
        super(pPortNr);
        this.control = pControl;
        this.roomList = new List();
        this.clientList = new List();
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
            this.send(pClientIP, pClientPort, lGsonObject.toJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR, ex.getMessage()))));
        }
    }

    @Override
    public void processClosedConnection(String pClientIP, int pClientPort) {
        if (this.containsClient(pClientIP, pClientPort)) {
            this.deleteClient(getClient(pClientIP, pClientPort));
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
                if (lClient.equals(new Client(pIp, pPort, this))) {
                    return true;
                }
            }
            this.clientList.next();
        }
        return false;
    }
    
    public boolean containsName(String pName) {
        this.clientList.toFirst();
        while (this.clientList.hasAccess()) {
            if (this.clientList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.clientList.getObject();
                if (lClient.getUsername().equals(pName)) {
                    return true;
                }
            }
            this.clientList.next();
        }
        return false;
    }

    private void deleteClient(Client pClient) {
        this.clientList.toFirst();
        while (this.clientList.hasAccess()) {
            if (this.clientList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.clientList.getObject();
                if (lClient.equals(pClient)) {
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

    public boolean logoutClient(Client pClient) {
        if (pClient == null || !this.containsClient(pClient.getIp(), pClient.getPort())) {
            return false;
        }
        this.deleteClient(pClient);
        return true;
    }

    public boolean createRoom(String pRoomName, Client pClient) {
        if (pRoomName == null || this.containsRoom(pRoomName)) {
            return false;
        }
        Room lRoom = new Room(this.getFirstFreeRoomId(), pRoomName, pClient);
        this.insertRoomSorted(lRoom);
        pClient.setCurRoom(lRoom);
        return true;
    }

    private void insertRoomSorted(Room pRoom) {
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            Object lCurObject = this.roomList.getObject();
            if (lCurObject != null && lCurObject instanceof Room) {
                Room lCurRoom = (Room) lCurObject;
                if (lCurRoom.getId() < pRoom.getId()) {
                    break;
                }
            }
            this.roomList.next();
        }
        this.roomList.insert(pRoom);
    }

    private int getFirstFreeRoomId() {
        int lReturn = 1;
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            Object lCurObject = this.roomList.getObject();
            if (lCurObject != null && lCurObject instanceof Room) {
                Room lCurRoom = (Room) lCurObject;
                if (lCurRoom.getId() == lReturn) {
                    lReturn++;
                } else if (lCurRoom.getId() < lReturn) {
                    break;
                }
            }
            this.roomList.next();
        }
        return lReturn;
    }

    private boolean containsRoom(String pRoomName) {
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

    public boolean containsRoom(int pRoomId) {
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            if (this.roomList.getObject().getClass() == Room.class) {
                Room lRoom = (Room) this.roomList.getObject();
                if (pRoomId == lRoom.getId()) {
                    return true;
                }
            }
            this.roomList.next();
        }
        return false;
    }

    public Room getRoom(int pRoomId) {
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            if (this.roomList.getObject().getClass() == Room.class) {
                Room lRoom = (Room) this.roomList.getObject();
                if (pRoomId == lRoom.getId()) {
                    return lRoom;
                }
            }
            this.roomList.next();
        }
        return null;
    }

    public List getRoomList() {
        return roomList;
    }

    public List getRoomModelList() {
        List lList = new List();
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            Object lCurObject = this.roomList.getObject();
            if (lCurObject != null && lCurObject instanceof Room) {
                Room lCurRoom = (Room) lCurObject;
                lList.append(new RoomModel(lCurRoom.getId(), lCurRoom.getName()));
            }
            this.roomList.next();
        }
        return lList;
    }
}
