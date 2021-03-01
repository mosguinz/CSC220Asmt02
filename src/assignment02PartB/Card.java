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

    private static final int MAX_TRIES = 3;
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
        for (int i = 0; i <= MAX_TRIES; i++) {
            try {
                player.sayPrompt(bundle.getString("player.amountPrompt"));
                int cards = scan.nextInt();
                return cards;
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.printf(bundle.getString("error.invalidInputTypeCardAmount"),
                        MAX_TRIES - i);
            } finally {
                scan.nextLine();
            }
        }
        throw new InputMismatchException(String.format("Exceeded %d tries.", MAX_TRIES));
    }

    private String[][] promptCardParams(int amountOfCards) {
        String[][] params = new String[amountOfCards][3];
        player.sayDialogue(bundle.getString("player.parameterPrompt"));
        System.out.printf("    [1] %s%n", bundle.getString("player.parameterPrompt.1"));
        System.out.printf("    [2] %s%n", bundle.getString("player.parameterPrompt.2"));
        System.out.printf("    [3] %s%n", bundle.getString("player.parameterPrompt.3"));
        for (int i = 0; i < amountOfCards; i++) {
            player.sayDialogue(
                    String.format(bundle.getString("player.cardNumberPrompt"), i + 1)
            );
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

    private void printCards(String[][] cards) {
        SFGiantsCardGenerator generator = new SFGiantsCardGenerator();
        final String firstName = student.getFirstName();
        final String email = student.getEmail();
        final String officialSong = Language.getOfficialSong();

        for (int i = 0; i < cards.length; i++) {
            final String recipient = cards[i][0];
            final char artSymbol = cards[i][1].charAt(0);
            final String message = cards[i][2];

            System.out.println();
            try {
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
