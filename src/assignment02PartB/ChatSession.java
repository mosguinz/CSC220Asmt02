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

import java.util.ResourceBundle;
import java.util.Scanner;

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"
public final class ChatSession {

    /**
     * Delay in milliseconds for chat. Set to zero for quick testing.
     */
    private static final int CHAT_DELAY_MS = 1000;

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

    public static String getLineSep() {
        return LINE_SEP;
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
            System.out.printf("%-25s %s%n", fields[i] + ":", values[i]);
        }
    }

    /**
     * Returns the app banner as specified in the sample output.
     */
    public static String getAppBanner() {
        return (LINE_SEP
                + "\n" + "-".repeat(19) + " "
                + Language.getOfficialAppName() + " " + "-".repeat(26)
                + "\n" + LINE_SEP
        );
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
     * Convenience method to print chat timestamp with a message.
     *
     * @param msg The message to add after the timestamp.
     */
    public static String generateTimestamp(String msg) {
        return String.format("%s - %s", Messenger.getConfig().getTimer().getChatTimestamp(), msg);
    }

    /**
     * Display a fake loading screen.
     */
    private static void fakeLoading() {
        for (int i = 0; i < 5; i++) {
            try {
                System.out.print(". ");
                Thread.sleep(CHAT_DELAY_MS);
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
            Thread.sleep(CHAT_DELAY_MS);
        } catch (InterruptedException e) {
            System.err.println(e);
        }
    }

    private void startChatSession() {
        System.out.println(generateTimestamp(bundle.getString("ts.sessionStart")));
        fakeChatDelay();
        System.out.println();

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
        fakeChatDelay();
        student.sayPrompt();
        readStringIn();
        fakeChatDelay();
        player.sayDialogue(String.format(bundle.getString("player.likewiseResponse"), firstName));
        fakeChatDelay();

        new Card(player, student, scan).runCardWizard();

        student.sayPrompt();
        readStringIn();
        fakeChatDelay();
        player.sayDialogue(String.format(bundle.getString("player.card.thankYou"), firstName));
        fakeChatDelay();
        System.out.println();
    }

    private void runQuiz() {
        new Quiz(club, student).runQuiz();
    }

    private void stopChatSession() {
        System.out.println(generateTimestamp(bundle.getString("ts.sessionEnd")));
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
