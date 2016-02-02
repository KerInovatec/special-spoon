package de.matchbox.server.net;

import de.matchbox.communication.classmodels.PlayerModel;

public class Player {

    private final Client client;
    private boolean host;
    private int points;

    public Player(Client pClient, int pPoints, boolean pIsHost) {
        this.client = pClient;
        this.points = pPoints;
        this.host = pIsHost;
    }

    public Client getClient() {
        return client;
    }

    public boolean isHost() {
        return host;
    }

    public void setHost(boolean host) {
        this.host = host;
    }

    public PlayerModel getModel() {
        //Username ist immer null
        return new PlayerModel(this.client.getUsername(), this.points, this.host);
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
