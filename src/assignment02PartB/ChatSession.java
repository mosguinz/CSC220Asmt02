/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: ChatSession.java
 * @author: Duc Ta
 * @author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;

import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.Scanner;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"
public final class ChatSession {

    /**
     * The width of the line separator as specified in the sample output.
     */
    private static final int LINE_SEP_WIDTH = 66;
    private static final String LINE_SEP = "-".repeat(LINE_SEP_WIDTH);
    private static final Scanner scan = new Scanner(System.in);
    private final Club club;
    private final University university;
    private final ResourceBundle bundle;
    private Student student;
    private Player player;

    public ChatSession(Club club, University university) {
        this.club = club;
        this.university = university;
        this.bundle = Messenger.getConfig().getLang().getBundle("ChatSession");
    }

    /**
     * Prints a line.
     */
    public static void printLineSep() {
        System.out.println(LINE_SEP);
    }

    /**
     * Prints the given provided {@code fields} and {@code values} in a table-like format.
     * <p>
     * Each field and value are printed in pairs on each line, the format of which is specified in
     * the sample output. See the example below.
     * <pre>{@code
     * Language:                 English
     * Time Zone:                Pacific Standard Time
     * Color:                    ANSI
     * Standard Output Log:      ./src/assignment02PartB/log/StandardOut.log
     * Default club:             SF Giants
     * }</pre>
     *
     * @param fields The array of strings as fields. The size of the array must be equal to those of
     *               {@code values}.
     * @param values The array of strings as values. The size of the array must be equal to those of
     *               {@code fields}.
     */
    public static void printTable(String[] fields, String[] values) {
        for (int i = 0; i < fields.length; i++) {
            System.out.printf("%-26s%s%n", fields[i] + ":", values[i]);
        }
    }

    /**
     * Print the app banner as specified in the sample output.
     */
    public static void displayAppBanner() {
        System.out.println(LINE_SEP);
        System.out.println("-".repeat(19) + " "
                + Language.getOfficialAppName() + " " + "-".repeat(26));
        System.out.println(LINE_SEP);
    }

    /**
     * Prompts the user for an input. Strips all leading and trailing whitespaces.
     *
     * @return The string from stdin.
     */
    public static String readStringIn() {
        return scan.nextLine().strip();
    }

    /**
     * Display a fake loading screen.
     */
    private static void fakeLoading() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.print(". ");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.err.println(e);
            }
        }
        System.out.println();
    }

    /**
     * Start a fake chat delay.
     */
    private static void fakeChatDelay() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    // lazy debug
    public static void main(String[] args) {
        new ChatSession(new Club(), new University()).runChatSession();
    }

    /**
     * Prompts the number of card to order.
     *
     * @return An integer.
     * @throws InputMismatchException Raised when the user exceeded the amount of tries.
     */
    public int promptCardAmount() throws InputMismatchException {
        final int maxTries = 3;
        for (int i = 0; i <= maxTries; i++) {
            try {
                player.sayPrompt(bundle.getString("player.card.amountPrompt"));
                int cards = scan.nextInt();
                return cards;
            } catch (InputMismatchException e) {
                System.err.println(e);
                System.out.printf(bundle.getString("error.invalidInputTypeCardAmount"),
                        maxTries - i);
            } finally {
                scan.nextLine();
            }
        }
        throw new InputMismatchException(String.format("Exceeded %d tries.", maxTries));
    }

    private String[][] promptCardParams(int amountOfCards) {
        String[][] params = new String[amountOfCards][3];
        player.sayDialogue(bundle.getString("player.card.parameterPrompt"));
        System.out.printf("    [1] %s%n", bundle.getString("player.card.parameterPrompt.1"));
        System.out.printf("    [2] %s%n", bundle.getString("player.card.parameterPrompt.2"));
        System.out.printf("    [3] %s%n", bundle.getString("player.card.parameterPrompt.3"));
        for (int i = 0; i < amountOfCards; i++) {
            player.sayDialogue(
                    String.format(bundle.getString("player.card.cardNumberPrompt"), i + 1)
            );
            for (int j = 0; j < 3; j++) {
                student.sayPrompt();
                System.out.printf("[%d] ", j + 1);
                params[i][j] = scan.nextLine();
            }
        }
        player.sayDialogue(String.format(
                bundle.getString("player.card.confirmation"), student.getFirstName()));
        return params;
    }

    private void startChatSession() {
        String ts = Messenger.getConfig().getTimer().getChatTimestamp();
        System.out.printf("%s - %s%n%n", ts, bundle.getString("ts.sessionStart"));
        club.sayDialogue(String.format(bundle.getString("clubWelcomeMessage"),
                club.getOfficialName().toUpperCase()));
        printLineSep();

        club.displayInfo();
        printLineSep();
        System.out.println();
        student = getStudentInfo();

        club.sayDialogue(bundle.getString("preChat.connecting"));
        fakeLoading();
    }

    private Student getStudentInfo() {
        club.sayPrompt(bundle.getString("preChat.namePrompt"));
        String[] name = readStringIn().split("\\s", 2);
        club.sayPrompt(bundle.getString("preChat.emailPrompt"));
        String email = readStringIn();
        if (name.length == 1) {
            return new Student(name[0], university, email);
        }
        return new Student(name[0], name[1], university, email);
    }

    private void connectChatters() {
        player = new Player(club);
        String firstName = student.getFirstName();
        printLineSep();
        player.displayInfo();
        printLineSep();
        fakeLoading();

        player.sayDialogue(String.format(bundle.getString("player.greeting"), firstName));
        fakeChatDelay();
        player.sayDialogue(String.format(
                bundle.getString("player.universityEmphasis"),
                Color.sfsuHighlight(university.getName().toUpperCase())
        ));
        int amountOfCards = promptCardAmount();
        new Card().printCards(promptCardParams(amountOfCards), student);

        student.sayPrompt();
        readStringIn();
        player.sayDialogue(String.format(bundle.getString("player.card.thankYou"), firstName));
        System.out.println();
    }

    private void runQuiz() {
    }

    private void stopChatSession() {
    }

    public void runChatSession() {
        this.startChatSession();
        this.connectChatters();
        // Transaction

        this.runQuiz();
        //
        this.stopChatSession();
    }
}
