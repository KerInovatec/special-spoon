package de.streichholzprojekt.server;

public class StreichholzServer extends Server
{
    public StreichholzServer(int pPortNr)
    {
        super(pPortNr);
    }

    public static void main(String[] args)
    {
        StreichholzServer lServer = new StreichholzServer(1234);
    }

    @Override
    public void processNewConnection(String pClientIP, int pClientPort)
    {
    }

    @Override
    public void processMessage(String pClientIP, int pClientPort, String pMessage)
    {
    }

    @Override
    public void processClosedConnection(String pClientIP, int pClientPort)
    {
    }
}
