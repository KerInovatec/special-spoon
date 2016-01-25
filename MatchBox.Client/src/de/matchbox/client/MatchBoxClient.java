package de.matchbox.client;

import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;

public class MatchBoxClient extends de.matchbox.client.abiturklassen.Client
{
    private final Control control;

    public MatchBoxClient(Control con, String pIPAdresse, int pPortNr)
    {
        super(pIPAdresse, pPortNr);
        this.control = con;
    }

    @Override
    public void processMessage(String pMessage)
    {
        Gson lGsonObject = new Gson();
        try{
            MessageObject lMessageObject = lGsonObject.fromJson(pMessage, MessageObject.class);
            this.control.process(lMessageObject);
        }catch(Exception ex){
            //Errorhandling
        }
    }

}
