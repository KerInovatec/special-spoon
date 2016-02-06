package de.matchbox.server;

import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.classmodels.RoomModel;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.shared.abiturklassen.List;
import de.matchbox.server.abiturklassen.Server;
import de.matchbox.server.net.Client;
import de.matchbox.server.net.Room;

public class StreichholzServer extends Server {

    private final List clientList;

    private final Control control;
    private final List roomList;

    public StreichholzServer(int pPortNr, Control pControl) {
        super(pPortNr);
        this.control = pControl;
        this.roomList = new List();
        this.clientList = new List();
    }

    public boolean containsName(String pName) {
        this.clientList.toFirst();
        while (this.clientList.hasAccess()) {
            if (this.clientList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.clientList.getObject();
                if (lClient.getUsername() != null && lClient.getUsername().equals(pName)) {
                    return true;
                }
            }
            this.clientList.next();
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

    public boolean createRoom(String pRoomName, Client pClient) {
        if (pRoomName == null) {
            return false;
        }
        this.log("Versuche Raum \"" + pRoomName + "\" zu erstellen.");
        if (this.containsRoom(pRoomName)) {
            this.log("Raum \"" + pRoomName + "\" bereits vorhanden.");
            return false;
        }
        Room lRoom = new Room(this.getFirstFreeRoomId(), pRoomName, pClient, this);
        this.insertRoomSorted(lRoom);
        pClient.setCurRoom(lRoom);
        this.log("Raum \"" + pRoomName + "\" erfolgreich erstellt.");
        return true;
    }

    public void deleteRoom(Room pRoom) {
        this.log("Versuche Raum \"" + pRoom.getName() + "\" zu löschen");
        this.roomList.toFirst();
        while (this.roomList.hasAccess()) {
            if (this.roomList.getObject().equals(pRoom)) {

                this.roomList.remove();
                this.log("Der Raum \"" + pRoom.getName() + "\" wurde gelöscht");
            }
            this.roomList.next();
        }
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

    public boolean logoutClient(Client pClient) {
        if (pClient == null || !this.containsClient(pClient.getIp(), pClient.getPort())) {
            return false;
        }
        this.log(pClient.toString() + " erfolgreich ausgeloggt.");
        this.deleteClient(pClient);
        return true;
    }

    @Override
    public void processClosedConnection(String pClientIP, int pClientPort) {
        if (this.containsClient(pClientIP, pClientPort)) {
            this.deleteClient(getClient(pClientIP, pClientPort));
        }
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
    public void processNewConnection(String pClientIP, int pClientPort) {
        if (this.containsClient(pClientIP, pClientPort)) {
            this.deleteClient(getClient(pClientIP, pClientPort));
        }
        this.addClient(pClientIP, pClientPort);
    }

    private void addClient(String pIp, int pPort) {
        this.clientList.append(new Client(pIp, pPort, this));
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

    private void deleteClient(Client pClient) {
        if (pClient.getCurRoom() != null) {
            pClient.getCurRoom().logoutPlayer(pClient);
        }

        this.clientList.toFirst();
        while (this.clientList.hasAccess()) {
            if (this.clientList.getObject() instanceof Client) {
                Client lClient = (Client) this.clientList.getObject();
                if (lClient.equals(pClient)) {
                    this.clientList.remove();
                    this.log(lClient.toString() + " wurde ausgeloggt.");
                    return;
                }
            }
            this.clientList.next();
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

    public void log(String message) {
        System.out.println(message);
    }

    public void err(String errMsg) {
        System.err.println(errMsg);
    }

}
