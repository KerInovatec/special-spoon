package de.streichholzprojekt.server.net;

import de.streichholzprojekt.server.abiturklassen.Server;

public class Client
{
    private final String ip;
    private final int port;
    private final Server server;

    public Client(String pIp, int pPort, Server pServer)
    {
        this.ip = pIp;
        this.port = pPort;
        this.server = pServer;

    }

    public String getIp()
    {
        return ip;
    }

    public int getPort()
    {
        return port;
    }

}
