package de.matchbox.communication.contentobjects.roomcommands.server;

import de.matchbox.communication.contentobjects.roomcommands.IRoomCommandContentObject;
import de.matchbox.communication.shared.abiturklassen.List;

public class ListPlayerContentObject implements IRoomCommandContentObject {

    private final List player;

    public ListPlayerContentObject() {
        this.player = new List();
    }

    public ListPlayerContentObject(List pPlayerList) {
        this.player = pPlayerList;
    }

    public List getPlayer() {
        return player;
    }
}
