package main;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class MatchBoxClient extends main.abi.Client
{
    public ClientState state;
    private Control con;

    public MatchBoxClient(Control con, String pIPAdresse, int pPortNr)
    {
        super(pIPAdresse, pPortNr);
        this.con = con;
        state = ClientState.EMPTY;
    }

    @Override
    public void processMessage(String pMessage)
    {
        switch(state)
        {
            case LIST:
                //JSON auflösen
                Gson gson = new Gson();
                JsonObject lObject = gson.fromJson(pMessage, JsonObject.class);
                JsonArray array = lObject.getAsJsonArray();
                for(JsonElement curObject : array)
                {
                    curObject.getAsJsonObject().get("id").getAsInt();
                }
                break;

            default:
                break;
        }
    }

}
