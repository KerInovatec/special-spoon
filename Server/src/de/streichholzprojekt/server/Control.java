package de.streichholzprojekt.server;

import de.streichholzprojekt.server.enumeration.MessageType;
import de.streichholzprojekt.server.net.Client;

public class Control
{
    private final StreichholzServer server;

    private Control()
    {
        this.server = new StreichholzServer(1234, this);
    }

    public void process(MessageType pType, String pMessage, Client pClient)
    {

    }

    public static void main(String[] args)
    {
        Control lControl = new Control();
    }
}
