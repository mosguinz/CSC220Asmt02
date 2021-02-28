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
}
