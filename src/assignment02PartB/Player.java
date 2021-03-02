/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Player.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ResourceBundle;

public class Player extends Person {

    private final Club club;
    private final String position;
    private final String number;
    private final String batSide;
    private final String throwSide;
    private final String mlbDebut;

    public Player(Club club) {
        super();
        final ResourceBundle bundle = ResourceBundle
                .getBundle("assignment02PartB.resources.PlayerInfo");
        this.setFirstName(bundle.getString("firstName"));
        this.setLastName(bundle.getString("lastName"));
        this.club = club;
        position = bundle.getString("position");
        number = bundle.getString("number");
        batSide = bundle.getString("batSide");
        throwSide = bundle.getString("throwSide");
        mlbDebut = bundle.getString("mlbDebut");
    }

    public Club getClub() {
        return club;
    }

    public void displayInfo() {
        final ResourceBundle bundle = Messenger.getConfig().getLang().getBundle("Player");
        String[] fields = {
                bundle.getString("player.label"),
                bundle.getString("club.label"),
                bundle.getString("position.label"),
                bundle.getString("number.label"),
                bundle.getString("batSide.label"),
                bundle.getString("throwSide.label"),
                bundle.getString("mlbDebut.label")
        };
        String[] values = {
                super.toString(),
                club.getOfficialName(),
                position,
                number,
                batSide,
                throwSide,
                mlbDebut
        };
        ChatSession.printTable(fields, values);
    }

    @Override
    public String toString() {
        return String.format("%s, %s", super.toString(), number);
    }

    /**
     * Prints a dialogue message with the player's name and number. Includes a newline at the end.
     *
     * @param m The message to print.
     */
    public void sayDialogue(String m) {
        System.out.printf("%s: %s%n", toString(), m);
    }

    /**
     * Prints a prompt message with the player's name and number. Includes a space at the end.
     *
     * @param m The message to use as a prompt.
     */
    public void sayPrompt(String m) {
        System.out.printf("%s: %s ", toString(), m);
    }
}
