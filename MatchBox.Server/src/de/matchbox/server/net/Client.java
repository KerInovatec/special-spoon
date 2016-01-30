package de.matchbox.server.net;

import de.matchbox.server.abiturklassen.Server;

public class Client {

    private final String ip;
    private final int port;
    private final Server server;
    private String username;
    private Room curRoom;

    public Client(String pIp, int pPort, Server pServer) {
        this.ip = pIp;
        this.port = pPort;
        this.server = pServer;
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

    public void setCurRoom(Room pCurRoom) {
        this.curRoom = pCurRoom;
    }

    public void setUsername(String pUsername) {
        this.username = pUsername;
    }
    
    public void send(String pMessage){
        this.server.send(this, pMessage);
    }

    public boolean equals(Client pClient) {
        return this.ip.equals(pClient.getIp()) && this.port == pClient.getPort();
    }
}
