package de.matchbox.communication.contentobjects.roomcommands.server;

import de.matchbox.communication.contentobjects.roomcommands.IRoomCommandContentObject;
import de.matchbox.communication.shared.abiturklassen.List;

public class EquasionSolvedContentObject implements IRoomCommandContentObject {

    private String username;
    private List playerList;

    public EquasionSolvedContentObject() {
        this("", new List());
    }

    public EquasionSolvedContentObject(String pUsername, List pPlayerList) {
        this.username = pUsername;
        this.playerList = pPlayerList;
    }

    public String getUsername() {
        return username;
    }

    public List getPlayerList() {
        return playerList;
    }
}
