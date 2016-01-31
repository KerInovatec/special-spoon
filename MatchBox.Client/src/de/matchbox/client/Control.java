package de.matchbox.client;

import com.google.gson.Gson;
import de.matchbox.client.forms.FrmLobby;
import de.matchbox.client.forms.FrmLogin;
import de.matchbox.client.forms.FrmMain;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.contentobjects.server.ListRoomsContentObject;
import de.matchbox.communication.contentobjects.client.LoginContentObject;
import de.matchbox.communication.contentobjects.roomcommands.server.ListPlayerContentObject;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.communication.enumeration.RoomCommand;
import javax.swing.JOptionPane;

public class Control {

    private MatchBoxClient client = null;
    private FrmMain main;
    private FrmLogin login;
    private FrmLobby lobby;

    public Control() {

    }

    public Control(FrmMain main) {
        this.main = main;
        //this.client = new MatchBoxClient(this, "10.16.12.1", 1234);
        //this.client = new MatchBoxClient(this, ip, port);
    }

    public Control(FrmLogin login) {
        this.login = login;
    }

    public Control(FrmLobby lobby) {
        this.lobby = lobby;
    }

    public void setMain(FrmMain main) {
        this.main = main;
    }

    public void setLobby(FrmLobby lobby) {
        this.lobby = lobby;
    }

    public void connect(String ip, int port) {
        this.client = new MatchBoxClient(this, ip, port);
    }

    public void process(MessageObject pMessageObject) {
        switch (pMessageObject.getNachrichtenTyp()) {
            case LIST_ROOMS:
                if (!(pMessageObject.getContentObject() instanceof ListRoomsContentObject)) {
                    return;
                }

                this.lobby.setRooms(((ListRoomsContentObject) pMessageObject.getContentObject()).getRooms());
                break;
            case LOGIN:
                JOptionPane.showMessageDialog(null, new Gson().toJson(pMessageObject));
                login.startLobby();

                break;
            case CREATE_ROOM:

                this.send(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.LIST_PLAYER)));

                break;
            case JOIN_ROOM:
                lobby.startMain();
                main.setPlayerList(((ListPlayerContentObject) (((RoomCommandContentObject) pMessageObject.getContentObject()).getContentObject())).getPlayer());
                break;
            case ROOM_CMD:
                
                if (lobby != null) {
                    lobby.startMain();
                }
                main.verarbeite(((RoomCommandContentObject) pMessageObject.getContentObject()).getContentObject());
                
                break;
            
            case ERROR:
                //Benachrichtige den User
                break;
            default:
                break;
        }
    }

    public void login(String pUsername) {
        this.client.send(new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.LOGIN, new LoginContentObject(pUsername))));
    }

    public void send(MessageObject pMessageObject) {
        this.client.send(new StandardGsonBuilder().create().toJson(pMessageObject));
    }
}
