package de.matchbox.client;

import com.google.gson.Gson;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;

public class MatchBoxClient extends de.matchbox.communication.shared.abiturklassen.Client
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
        Gson lGsonObject = new StandardGsonBuilder().create();
        try{
            MessageObject lMessageObject = lGsonObject.fromJson(pMessage, MessageObject.class);
            this.control.process(lMessageObject);
        }catch(Exception ex){
            //Errorhandling
        }
    }

}
