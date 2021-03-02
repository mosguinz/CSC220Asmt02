/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Card.java
 * @author: Duc Ta
 * @author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Card {

    private static final int MAX_RETRIES = 3;
    private final int artSize = 0;
    // Please change artSize, if needed, to get an identical output
    private final String artFont = "";
    // Please change artFont, if needed, to get an identical output

    private final Player player;
    private final Student student;
    private final Scanner scan;
    private final ResourceBundle bundle;

    public Card(Player player, Student student, Scanner scan) {
        bundle = Messenger.getConfig().getLang().getBundle("Card");
        this.player = player;
        this.student = student;
        this.scan = scan;
    }

    /**
     * Prompts the number of card to order.
     *
     * @return An integer.
     * @throws InputMismatchException Raised when the user exceeded the amount of tries.
     */
    private int promptCardAmount() throws InputMismatchException {
        for (int i = 0; i <= MAX_RETRIES; i++) {
            try {
                player.sayPrompt(bundle.getString("player.amountPrompt"));
                return scan.nextInt();
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.printf(bundle.getString("error.invalidInputTypeCardAmount"),
                        MAX_RETRIES - i);
            } finally {
                scan.nextLine();  // reset cursor
            }
        }
        throw new InputMismatchException(String.format("Exceeded %d retries.", MAX_RETRIES));
    }

    /**
     * Prompts the user for the card's recipient, style, and message to recipient.
     *
     * @param amountOfCards The amount of cards to order. The prompts will repeat for this amount.
     * @return A 2D array representing the cards to order and its fields.
     */
    private String[][] promptCardParams(int amountOfCards) {
        String[][] params = new String[amountOfCards][3];

        // Instructions
        player.sayDialogue(bundle.getString("player.parameterPrompt"));
        System.out.printf("%4s[1] %s%n", "", bundle.getString("player.parameterPrompt.1"));
        System.out.printf("%4s[2] %s%n", "", bundle.getString("player.parameterPrompt.2"));
        System.out.printf("%4s[3] %s%n", "", bundle.getString("player.parameterPrompt.3"));

        // Prompt for each cards.
        for (int i = 0; i < amountOfCards; i++) {
            player.sayDialogue(String.format(bundle.getString("player.cardNumberPrompt"), i + 1));

            // Prompt for each fields.
            for (int j = 0; j < 3; j++) {
                student.sayPrompt();
                System.out.printf("[%d] ", j + 1);
                params[i][j] = scan.nextLine();
            }
        }
        player.sayDialogue(String.format(
                bundle.getString("player.confirmation"), student.getFirstName()));
        return params;
    }

    /**
     * Prints the card(s) to the console.
     *
     * @param cards A 2D array representing the cards to print.
     */
    private void printCards(String[][] cards) {
        SFGiantsCardGenerator generator = new SFGiantsCardGenerator();
        final String firstName = student.getFirstName();
        final String email = student.getEmail();

        for (String[] card : cards) {
            final String recipient = card[0];
            final char artSymbol = card[1].charAt(0);
            final String message = card[2];

            try {
                System.out.println();
                generator.generateSFGiantsCard(recipient, message, firstName, email,
                        artSymbol, artSize, artFont);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }

    /**
     * Start the interactive card creation wizard.
     */
    public void runCardWizard() {
        int cardAmount = promptCardAmount();
        String[][] cardParams = promptCardParams(cardAmount);
        printCards(cardParams);
    }
}
