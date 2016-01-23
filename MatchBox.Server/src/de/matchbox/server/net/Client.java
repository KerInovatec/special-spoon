package de.matchbox.server.net;

import de.matchbox.server.abiturklassen.Server;

public class Client {

    private final String ip;
    private final int port;
    private final Server server;
    private String username;

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

    public void setUsername(String username) {
        this.username = username;
    }

}
