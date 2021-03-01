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

public class Player extends Person {

    private String position;
    private String number;
    private String batSide;
    private String throwSide;
    private String mlbDebut;

    public Player(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public Player(String firstName, String lastName, String position, String number, String batSide,
            String throwSide, String mlbDebut) {
        super(firstName, lastName);
        this.position = position;
        this.number = number;
        this.batSide = batSide;
        this.throwSide = throwSide;
        this.mlbDebut = mlbDebut;
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
