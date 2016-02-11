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
<<<<<<< HEAD
                this.room.setPlayerList(pCommandObject.getContentObject());
                if (!((EquasionSolvedContentObject) pCommandObject.getContentObject()).getUsername().equals(control.getUsername())) {
                    this.room.callTheSolver(((EquasionSolvedContentObject) pCommandObject.getContentObject()).getUsername());
                }else if(((EquasionSolvedContentObject) pCommandObject.getContentObject()).getUsername().equals(control.getUsername()))
                {
                    this.room.callWellDone();
                    this.room.initMLG();
                }
                room.newEquasion();
=======
                this.room.onEquasionSolved(pCommandObject.getContentObject(), this.control.getUsername());
>>>>>>> origin/master
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

        }
    }

    public void send(MessageObject pMessageObject) {
        this.control.send(pMessageObject);
    }
}
