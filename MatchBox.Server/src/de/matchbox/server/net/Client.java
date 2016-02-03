package de.matchbox.server.net;

import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.server.abiturklassen.Server;

public class Client
{

    private Room curRoom;

    private final String ip;
    private final int port;
    private final Server server;
    private String username;

    public Client(String pIp, int pPort, Server pServer)
    {
        this.ip = pIp;
        this.port = pPort;
        this.server = pServer;
    }

    @Override
    public String toString()
    {
        return "Nutzer \"" + username + "\" (" + ip + ")";
    }

    public boolean equals(Client pClient)
    {
        return this.ip.equals(pClient.getIp()) && this.port == pClient.getPort();
    }

    public Room getCurRoom()
    {
        return curRoom;
    }

    public void setCurRoom(Room pCurRoom)
    {
        this.curRoom = pCurRoom;
    }

    public String getIp()
    {
        return ip;
    }

    public int getPort()
    {
        return port;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String pUsername)
    {
        this.username = pUsername;
    }

    public void send(String pMessage)
    {
        this.server.send(this, pMessage);
    }

    public void sendJson(MessageObject pMessage)
    {
        this.server.send(this, new StandardGsonBuilder().create().toJson(pMessage));
    }

}
