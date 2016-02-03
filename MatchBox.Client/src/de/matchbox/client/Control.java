package de.matchbox.client;

import de.matchbox.client.forms.FrmLobby;
import de.matchbox.client.forms.FrmLogin;
import de.matchbox.client.forms.FrmMain;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.contentobjects.client.LoginContentObject;
import de.matchbox.communication.contentobjects.server.ListRoomsContentObject;
import de.matchbox.communication.enumeration.MessageType;
import javax.swing.JOptionPane;

public class Control
{

    private MatchBoxClient client = null;
    private FrmLobby lobby;
    private FrmLogin login;
    private FrmMain main;

    public Control()
    {

    }

    public Control(FrmMain main)
    {
        this.main = main;
        //this.client = new MatchBoxClient(this, "10.16.12.1", 1234);
        //this.client = new MatchBoxClient(this, ip, port);
    }

    public Control(FrmLogin login)
    {
        this.login = login;
    }

    public Control(FrmLobby lobby)
    {
        this.lobby = lobby;
    }

    public void connect(String ip, int port)
    {
        this.client = new MatchBoxClient(this, ip, port);
    }

    public void setLobby(FrmLobby lobby)
    {
        this.lobby = lobby;
    }

    public void setMain(FrmMain main)
    {
        this.main = main;
    }

    public void login(String pUsername)
    {
        this.client.send(new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.LOGIN, new LoginContentObject(pUsername))));
    }

    public void process(MessageObject pMessageObject)
    {
        switch(pMessageObject.getNachrichtenTyp())
        {
            case LIST_ROOMS:
                if(!(pMessageObject.getContentObject() instanceof ListRoomsContentObject))
                {
                    return;
                }
                this.lobby.setRooms(((ListRoomsContentObject)pMessageObject.getContentObject()).getRooms());
                break;
            case LOGIN:
                this.login.setVisible(false);
                this.login.startLobby();
                break;
            case CREATE_ROOM:
                if(this.lobby != null && this.main == null)
                {
                    this.lobby.startMain();
                }
                break;
            case JOIN_ROOM:
                this.lobby.startMain();
                break;
            case ROOM_CMD:
                if(this.lobby != null && this.main == null)
                {
                    this.lobby.startMain();
                }
                this.main.verarbeite((RoomCommandContentObject)pMessageObject.getContentObject());
                break;
            case ERROR:
                JOptionPane.showMessageDialog(this.login, "ERROR");
                break;

            default:
                break;
        }
    }

    public void send(MessageObject pMessageObject)
    {
        this.client.send(new StandardGsonBuilder().create().toJson(pMessageObject));
    }
}
