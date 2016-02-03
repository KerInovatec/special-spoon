package de.matchbox.server.net;

import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.contentobjects.roomcommands.EquasionContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.CheckEquasionResultContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.ListPlayerContentObject;
import de.matchbox.communication.contentobjects.server.ErrorContentObject;
import de.matchbox.communication.enumeration.ErrorType;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.communication.enumeration.RoomCommand;
import de.matchbox.communication.shared.abiturklassen.List;
import de.matchbox.server.StreichholzServer;
import de.matchbox.server.utility.ListUtility;
import de.matchbox.server.utility.MatchUtility;
import java.util.Random;

public class Room
{
    private String correctEquasion = "**7+**0=**7";

    private final int id;
    private final String name;
    private final List playerList;
    private String wrongEquasion = "**7+**8=**1";

    public Room(int pId, String pName, Client pHost)
    {
        this.id = pId;
        this.name = pName;
        this.playerList = new List();
        this.playerList.append(new Player(pHost, 0, true));
    }

    public void addClient(Client pClient)
    {
        this.playerList.append(new Player(pClient, 0, false));
    }

    public boolean containsClient(Client pClient)
    {
        this.playerList.toFirst();
        while(this.playerList.hasAccess())
        {
            if(this.playerList.getObject() instanceof Player)
            {
                Player lPlayer = (Player)this.playerList.getObject();
                if(lPlayer.getClient().equals(pClient))
                {
                    return true;
                }
            }
            this.playerList.next();
        }
        return false;
    }

    public void deleteClient(Client pClient)
    {
        this.playerList.toFirst();
        while(this.playerList.hasAccess())
        {
            if(this.playerList.getObject() instanceof Player)
            {
                Player lPlayer = (Player)this.playerList.getObject();
                if(lPlayer.getClient().equals(pClient))
                {
                    this.playerList.remove();
                    if(lPlayer.isHost())
                    {
                        this.playerList.toFirst();
                        if(this.playerList.hasAccess())
                        {
                            ((Player)this.playerList.getObject()).setHost(true);
                            this.onHostChanged();
                        }
                    }
                    return;
                }
            }
            this.playerList.next();
        }
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public boolean isClientHost(Client pClient)
    {
        this.playerList.toFirst();
        while(this.playerList.hasAccess())
        {
            if(this.playerList.getObject() instanceof Player)
            {
                Player lPlayer = (Player)this.playerList.getObject();
                if(lPlayer.getClient().equals(pClient))
                {
                    return lPlayer.isHost();
                }
            }
            this.playerList.next();
        }
        return false;
    }

    public void process(RoomCommandContentObject pMessageObject, Client pClient, StreichholzServer pServer)
    {
        switch(pMessageObject.getCommand())
        {
            case CHECK_EQUASION:
                this.checkEquasion(pMessageObject, pClient);
                break;
            case REQUEST_EQUASION:
                this.requestEquasion(pClient);
                break;
            case LIST_PLAYER:
                this.listPlayer(pClient, false);
                break;
            default:
                pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.UNKOWN_COMMAND)));
                break;
        }
    }

    public void sendToAll(String pMessage)
    {
        this.playerList.toFirst();
        Object lCurObject;
        while(this.playerList.hasAccess() && (lCurObject = this.playerList.getObject()) instanceof Client)
        {
            ((Client)lCurObject).send(pMessage);
            this.playerList.next();
        }
    }

    private void checkEquasion(RoomCommandContentObject pMessageObject, Client pClient)
    {
        if(pMessageObject.getContentObject() instanceof EquasionContentObject)
        {
            boolean lIsEquasionCorrect = ((EquasionContentObject)pMessageObject.getContentObject()).getEquasion().equals(this.correctEquasion);
            if(lIsEquasionCorrect)
            {
                this.givePlayerPoint(pClient);
            }
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.CHECK_EQUASION, new CheckEquasionResultContentObject(lIsEquasionCorrect))));
        }
        else
        {
            pClient.sendJson(new MessageObject(new ErrorContentObject(ErrorType.PARSE_ERROR)));
        }
    }

    private String fillStringUp(String pString, int pMaxLength, char pFillChar, boolean prepend)
    {
        while(pString.length() < pMaxLength)
        {
            if(prepend)
            {
                pString = pFillChar + pString;
            }
            else
            {
                pString += pFillChar;
            }
        }
        return pString;
    }

    public void getNewEquasion()
    {
        do
        {
            int lNumber1 = new Random().nextInt(100);
            int lNumber2 = new Random().nextInt(100);
            int lSum = lNumber1 + lNumber2;
            this.correctEquasion = this.fillStringUp(String.valueOf(lNumber1), 3, '*', true) + "+" + this.fillStringUp(String.valueOf(lNumber2), 3, '*', true) + "=" + this.fillStringUp(String.valueOf(lSum), 3, '*', true);
            this.wrongEquasion = MatchUtility.getWrongEquasion(this.correctEquasion);
        }
        while(this.wrongEquasion.equals(""));
    }

    private void givePlayerPoint(Client pClient)
    {
        this.playerList.toFirst();
        while(this.playerList.hasAccess() && this.playerList.getObject() instanceof Player)
        {
            Player lPlayer = (Player)this.playerList.getObject();
            if(lPlayer.getClient().equals(pClient))
            {
                lPlayer.setPoints(lPlayer.getPoints() + 1);
            }
            this.playerList.next();
        }
        this.sendPlayersToAll(false);
    }

    private void listPlayer(Client pClient, boolean pHostChanged)
    {
        List lPlayerList = new List();

        this.playerList.toFirst();
        while(this.playerList.hasAccess())
        {
            if(this.playerList.getObject() instanceof Player)
            {
                lPlayerList.append(((Player)this.playerList.getObject()).getModel());
            }
            this.playerList.next();
        }

        if(!pHostChanged)
        {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.LIST_PLAYER, new ListPlayerContentObject(lPlayerList))));
        }
        else
        {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.HOST_CHANGED, new ListPlayerContentObject(lPlayerList))));
        }
    }

    private void onHostChanged()
    {
        this.sendPlayersToAll(true);
    }

    private void requestEquasion(Client pClient)
    {
        if(this.isClientHost(pClient))
        {
            this.getNewEquasion();
            this.sendToAll(new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.REQUEST_EQUASION, new EquasionContentObject(this.wrongEquasion)))));
        }
        else
        {
            pClient.sendJson(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.REQUEST_EQUASION, new EquasionContentObject(this.wrongEquasion))));
        }
    }

    private void sendPlayersToAll(boolean pHostChanged)
    {
        List lPlayerList = ListUtility.copyList(this.playerList);
        lPlayerList.toFirst();
        while(lPlayerList.hasAccess())
        {
            this.listPlayer(((Player)lPlayerList.getObject()).getClient(), pHostChanged);
            lPlayerList.next();
        }
    }

}
