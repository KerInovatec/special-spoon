package de.matchbox.communication.contentobjects.roomcommands.server;

import de.matchbox.communication.contentobjects.roomcommands.IRoomCommandContentObject;
import de.matchbox.communication.shared.abiturklassen.List;

public class PlayerWonContentObject implements IRoomCommandContentObject {

    private final String username;
    private final List playerList;

    public PlayerWonContentObject(String pUsername, List pPlayerList) {
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
