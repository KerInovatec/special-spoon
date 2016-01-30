package de.matchbox.communication.contentobjects.roomcommands.server;

import de.matchbox.communication.contentobjects.roomcommands.IRoomCommandContentObject;

//Nur für den Server. Für Client bitte EquasionContentObject benutzen
public class CheckEquasionResultContentObject implements IRoomCommandContentObject {

    private boolean equasionCorrect;

    public CheckEquasionResultContentObject() {
        this(false);
    }

    public CheckEquasionResultContentObject(boolean pIsEquasionCorrect) {
        this.equasionCorrect = pIsEquasionCorrect;
    }

    public boolean isEquasionCorrect() {
        return equasionCorrect;
    }
}
