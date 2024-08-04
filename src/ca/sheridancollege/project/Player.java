/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public abstract class Player {

    private String playerID;

    public Player(String name) {
        playerID = name;
    }

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String givenID) {
        playerID = givenID;
    }

    public abstract void play();

}
