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

import java.util.ResourceBundle;

public class Receipt {

    private static final ResourceBundle bundle = Messenger.getConfig().getLang()
            .getBundle("Receipt");
    private static final String path = Messenger.getConfig().getReceiptFilePath();

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


}