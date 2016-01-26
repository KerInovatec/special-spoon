package de.matchbox.client;

import com.google.gson.Gson;
import de.matchbox.client.forms.FrmMain;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.contentobjects.client.ListRoomsContentObject;
import de.matchbox.communication.contentobjects.client.LoginContentObject;
import de.matchbox.communication.enumeration.MessageType;
import java.util.Map;
import javax.swing.JOptionPane;

public class Control {

    private final MatchBoxClient client;
    private final FrmMain main;

    public Control(FrmMain main) {
        this.main = main;
        //this.client = new MatchBoxClient(this, "10.16.12.1", 1234);
        this.client = new MatchBoxClient(this, "127.0.0.1", 1234);
    }

    public void process(MessageObject pMessageObject) {
        switch (pMessageObject.getNachrichtenTyp()) {
            case LIST_ROOMS:
                if (!(pMessageObject.getContentObject() instanceof ListRoomsContentObject)) {
                    return;
                }
                this.main.setRooms(((ListRoomsContentObject)pMessageObject.getContentObject()).getRooms());
                break;
            case LOGIN:
                JOptionPane.showMessageDialog(null, new Gson().toJson(pMessageObject));
                break;
            case ERROR:
                //Benachrichtige den User
                break;
            default:
                break;
        }
    }
    
    public void login(String pUsername){
        this.client.send(new Gson().toJson(new MessageObject(MessageType.LOGIN, new LoginContentObject(pUsername))));
    }
}
