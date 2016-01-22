package main;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.ArrayList;

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
                ArrayList<String> rooms;
                rooms = new ArrayList<String>();
                Gson gson = new Gson();
                JsonObject lObject = gson.fromJson(pMessage.substring(4), JsonObject.class);
                JsonArray array = lObject.getAsJsonArray();
                for(JsonElement curObject : array)
                {
                    rooms.add(curObject.getAsJsonObject().get("name").getAsString());
                }
                con.setRooms(rooms);
                break;

            default:
                break;
        }
    }

}
