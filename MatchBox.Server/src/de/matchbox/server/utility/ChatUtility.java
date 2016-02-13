package de.matchbox.server.utility;

public class ChatUtility {
    public static String KickUsageText = "!kick USERNAME [REASON]";
    public static String KickHelpText = "Kicks a specified player with an optional reason.";
    public static String SetUsageText = "!set {winningPoints, roomName} [VALUE]";
    public static String SetHelpText = "Sets a property to a specified value.";
    public static String InfoUsageText = "!info";
    public static String InfoHelpText = "Gives general information about the room.";
    public static String StartUsageText = "!start";
    public static String StartHelpText = "Starts the game.";
    public static String StopUsageText = "!stop";
    public static String StopHelpText = "Stops the game and calls the player with the most points the winner.";
    
    public static String getHelpText(boolean isHost){
        if(isHost){
            return "Help:\n" + InfoUsageText + " - " + InfoHelpText + "\n" 
                    + KickUsageText + " - " + KickHelpText + "\n" 
                    + SetUsageText + " - " + SetHelpText + "\n"
                    + StartUsageText + " - " + StartHelpText + "\n"
                    + StopUsageText + " - " + StopHelpText;
        }else{
            return "Help:\n" + InfoUsageText + " - " + InfoHelpText;
        }
    }
}
