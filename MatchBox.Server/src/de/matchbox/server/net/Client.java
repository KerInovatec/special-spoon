package de.matchbox.server.net;

import de.matchbox.server.abiturklassen.Server;

public class Client {

    private final String ip;
    private final int port;
    private String username;
    private Room curRoom;

    public Client(String pIp, int pPort, Server pServer) {
        this.ip = pIp;
        this.port = pPort;
    }

    public String getIp() {
        return ip;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public Room getCurRoom() {
        return curRoom;
    }

    public void setCurRoom(Room curRoom) {
        this.curRoom = curRoom;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean equals(Client pClient) {
        return this.ip == pClient.getIp() && this.port == pClient.getPort();
    }
}
