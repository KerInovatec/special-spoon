package de.matchbox.communication.classmodels;

public class PlayerModel {
    private int points;
    private String username;
    private boolean host;
    
    public PlayerModel(){
        
    }
    
    public PlayerModel(String pUsername, int pPoints, boolean pIsHost){
        this.username = pUsername;
        this.points = pPoints;
        this.host = pIsHost;
    }

    public int getPoints() {
        return points;
    }

    public String getUsername() {
        return username;
    }

    public boolean isHost() {
        return host;
    }
}
