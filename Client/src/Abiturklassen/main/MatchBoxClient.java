package Abiturklassen.main;

public class MatchBoxClient extends Abiturklassen.Client
{
    public ClientState state;

    public MatchBoxClient(String pIPAdresse, int pPortNr)
    {
        super(pIPAdresse, pPortNr);
        state = ClientState.EMPTY;
    }

    @Override
    public void processMessage(String pMessage)
    {
        switch(state)
        {

        }
    }

}
