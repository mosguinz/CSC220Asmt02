/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Receipt.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ResourceBundle;

public class Receipt {

    private static final ResourceBundle bundle = Messenger.getConfig().getLang()
            .getBundle("Receipt");
    private static final String pathFormat = Messenger.getConfig().getReceiptFilePath();

    private final String startTimestamp;
    private final Student student;
    private final Player player;
    private String endTimestamp;
    private Card card;
    private Quiz quiz;

    public Receipt(Student student, Player player) {
        startTimestamp = ChatSession.generateTimestamp("tx.start");
        this.student = student;
        this.player = player;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    private String getPathName() {
        String path;
        path = pathFormat.replaceFirst("\\*", student.getFirstName() + student.getLastName());
        path = path.replaceFirst("\\*", student.getEmail());
        return path;
    }

    public void writeReceipt() {
        endTimestamp = ChatSession.generateTimestamp("tx.end");
        try {
            final PrintWriter write = new PrintWriter(getPathName(), StandardCharsets.UTF_8);
            write.println(ChatSession.getAppBanner());
            write.println(startTimestamp);
            write.println();
            write.printf("%s | %s%n", player.toString().toUpperCase(),
                    player.getClub().getOfficialName().toUpperCase());
            write.printf("%s, %s | %s%n", student.toString().toUpperCase(),
                    student.getEmail().toUpperCase(),
                    student.getUniversity().getName().toUpperCase());
            write.println(ChatSession.getLineSep());

            // Card info
            for (String[] c : card.getCardParams()) {
                write.println(c[0]);
                write.println(c[1].charAt(0));
                write.println(c[2]);
                write.println(ChatSession.getLineSep());
            }

            // Quiz
            if (quiz.isPassed()) {
                write.println(bundle.getString("quiz.success"));
            } else {
                write.println(bundle.getString("quiz.failure"));
            }
            write.flush();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}