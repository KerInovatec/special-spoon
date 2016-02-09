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
    }

    public void openRoom() {
        this.send(new MessageObject(MessageType.ROOM_CMD, new RoomCommandContentObject(RoomCommand.LIST_PLAYER)));
        this.room.setVisible(true);
    }

    public void process(RoomCommandContentObject pCommandObject) {
        switch (pCommandObject.getCommand()) {
            case LIST_PLAYER:
                this.room.setPlayerList(pCommandObject.getContentObject());
                break;
            case REQUEST_EQUASION:
                this.room.setEquasion(pCommandObject);
                break;
            case CHECK_EQUASION:
                this.room.onCheckedEquasion(pCommandObject);
                break;
        }
    }

    public void send(MessageObject pMessageObject) {
        this.control.send(pMessageObject);
    }
}