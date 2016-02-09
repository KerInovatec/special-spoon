package de.matchbox.client;

import de.matchbox.client.forms.FrmLobby;
import de.matchbox.client.forms.FrmLogin;
import de.matchbox.client.forms.FrmRoom;
import de.matchbox.client.forms.models.RoomFormModel;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.StandardGsonBuilder;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.contentobjects.client.LoginContentObject;
import de.matchbox.communication.contentobjects.server.ListRoomsContentObject;
import de.matchbox.communication.enumeration.MessageType;
import javax.swing.JOptionPane;

public class Control {

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmRoom.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRoom.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRoom.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRoom.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                try{
                    Thread.sleep(2600);
                }catch(Exception e)
                {
                    
                }
                
                
                Control lControl = new Control();
            }
        });
    }
    private MatchBoxClient client = null;
    private FrmLobby lobby;
    private FrmLogin login;
    private RoomFormModel roomFormModel;

    public Control() {
        this.login = new FrmLogin(this);
        this.login.setVisible(true);
    }

    public void connect(String ip, int port) {
        this.client = new MatchBoxClient(this, ip, port);
    }

    public void setPendingRoom(RoomFormModel pRoomFormModel) {
        this.roomFormModel = pRoomFormModel;
    }

    public void login(String pUsername) {
        this.client.send(new StandardGsonBuilder().create().toJson(new MessageObject(MessageType.LOGIN, new LoginContentObject(pUsername))));
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
                this.login.setVisible(false);
                this.lobby = new FrmLobby(this);
                this.lobby.setVisible(true);
                break;
            case CREATE_ROOM:
                if (this.lobby != null) {
                    this.lobby.setVisible(false);
                    this.roomFormModel = new RoomFormModel(this);
                    this.roomFormModel.openRoom();
                }
                break;
            case JOIN_ROOM:
                if (this.lobby != null) {
                    this.lobby.setVisible(false);
                    this.roomFormModel = new RoomFormModel(this);
                    this.roomFormModel.openRoom();
                }
                break;
            case ROOM_CMD:
                if (this.roomFormModel == null) {
                    this.roomFormModel = new RoomFormModel(this);
                }

                if (this.lobby != null) {
                    this.lobby.setVisible(false);
                    this.roomFormModel.process((RoomCommandContentObject) pMessageObject.getContentObject());
                }
                break;
            case ERROR:
                JOptionPane.showMessageDialog(this.login, "ERROR");
                break;

            default:
                break;
        }
    }

    public void send(MessageObject pMessageObject) {
        this.client.send(new StandardGsonBuilder().create().toJson(pMessageObject));
    }

}
