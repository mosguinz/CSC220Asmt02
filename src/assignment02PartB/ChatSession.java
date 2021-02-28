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

// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"
public final class ChatSession {

    /**
     * The width of the line separator as specified in the sample output.
     */
    private static final int LINE_SEP_WIDTH = 66;
    private static final String LINE_SEP = "-".repeat(LINE_SEP_WIDTH);
    private final Club club;
    private final University university;

    public ChatSession(Club club, University university) {
        this.club = club;
        this.university = university;
    }

    public static String getLineSep() {
        return LINE_SEP;
    }

    /**
     * Prints the given provided {@code fields} and {@values} in a table-like format.
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
    private void printAppBanner() {
        System.out.println(LINE_SEP);
        System.out.println("-".repeat(19) + Language.getOfficialAppName() + "-".repeat(26));
        System.out.println(LINE_SEP);
    }

    private void startChatSession() {
    }

    private void connectChatters() {
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
