package de.matchbox.client.forms.models;

import de.matchbox.client.Control;
import de.matchbox.client.forms.FrmRoom;
import de.matchbox.communication.MessageObject;
import de.matchbox.communication.contentobjects.RoomCommandContentObject;
import de.matchbox.communication.enumeration.MessageType;
import de.matchbox.communication.enumeration.RoomCommand;

public class RoomFormModel {

    private final Control control;
    private final FrmRoom room;

    public RoomFormModel(Control pControl) {
        this.control = pControl;
        this.room = new FrmRoom(this);
        this.room.setTitle(this.control.getUsername());
    }

    public boolean konamiisak() {
        return control.isKonamiisAk();
    }

    public void openRoom() {
        this.send(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.LIST_PLAYER)));
        this.room.setVisible(true);
    }

    public void closeRoom() {
        control.setLobby();
        this.room.setVisible(false);
    }

    public void process(RoomCommandContentObject pCommandObject) {
        switch (pCommandObject.getCommand()) {
            case LIST_PLAYER:
                this.room.setPlayerList(pCommandObject.getContentObject());
                break;
            case PLAYER_JOINED:
                this.room.setPlayerList(pCommandObject.getContentObject());
                break;
            case EQUASION_SOLVED:
                this.room.onEquasionSolved(pCommandObject.getContentObject(), this.control.getUsername());
                break;
            case REQUEST_EQUASION:
                this.room.newEquasion();
                this.room.setEquasion(pCommandObject);
                break;
            case CHECK_EQUASION:
                this.room.onCheckedEquasion(pCommandObject);
                break;
            case LEAVE_ROOM:
                this.closeRoom();
                break;
            case PLAYER_WON:
                this.room.onPlayerWon(pCommandObject.getContentObject());
                break;
            case MESSAGE:
                this.room.receiveMassage(pCommandObject.getContentObject());
                break;
            case SERVER_MESSAGE:
                this.room.receiveMassage(pCommandObject.getContentObject());
                break;
            case ERROR_MESSAGE:
                this.room.receiveMassage(pCommandObject.getContentObject());
                break;
            case PLAYER_LEFT:
                this.room.setPlayerList(pCommandObject.getContentObject());
                break;
            case HOST_CHANGED:
                this.room.setPlayerList(pCommandObject.getContentObject());
                break;

        }
    }

    public void send(MessageObject pMessageObject) {
        this.control.send(pMessageObject);
    }
}
