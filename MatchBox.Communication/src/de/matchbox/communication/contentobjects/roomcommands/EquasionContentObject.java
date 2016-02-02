package de.matchbox.communication.contentobjects.roomcommands;

public class EquasionContentObject implements IRoomCommandContentObject {

    private String equasion;

    public EquasionContentObject() {

    }

    public EquasionContentObject(String pEquasion) {
        this.equasion = pEquasion;
    }

    public String getEquasion() {
        return equasion;
    }
}
