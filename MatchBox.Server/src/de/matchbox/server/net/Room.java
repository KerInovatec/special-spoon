package de.matchbox.server.net;

import de.matchbox.communication.shared.abiturklassen.List;

public class Room {

    private final int id;
    private final String name;
    private final List clientList;

    public Room(int pId, String pName) {
        this.id = pId;
        this.name = pName;
        this.clientList = new List();
    }

    public Room() {
        this(Integer.MAX_VALUE, "");
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public boolean containsClient(Client pClient) {
        this.clientList.toFirst();
        while (this.clientList.hasAccess()) {
            if (this.clientList.getObject().getClass() == Client.class) {
                Client lClient = (Client) this.clientList.getObject();
                if (lClient.equals(pClient)) {
                    return true;
                }
            }
            this.clientList.next();
        }
        return false;
    }

    public void deleteClient(Client pClient) {
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

    public void addClient(Client pClient) {
        this.clientList.append(pClient);
    }
}
