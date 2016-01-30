package de.matchbox.server.net;

import de.matchbox.communication.classmodels.PlayerModel;

public class Player {
    private int points;
    private boolean host;
    private final Client client;
    
    public Player(Client pClient, int pPoints, boolean pIsHost){
        this.client = pClient;
        this.points = pPoints;
        this.host = pIsHost;
    }
    
    public PlayerModel getModel(){
        return new PlayerModel(this.client.getUsername(), this.points, this.host);
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setHost(boolean host) {
        this.host = host;
    }

    public Client getClient() {
        return client;
    }

    public int getPoints() {
        return points;
    }

    public boolean isHost() {
        return host;
    }
}
