/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Quiz.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ArrayList;
import java.util.ResourceBundle;

public class Quiz {

    private static final int MISSES_ALLOWED = 1;

    private final Club club;
    private final Student student;
    private final ResourceBundle bundle;
    private ArrayList<QuestionAnswer> questionAnswer;

    public Quiz(Club club, Student student) {
        bundle = Messenger.getConfig().getLang().getBundle("Quiz");
        this.club = club;
        this.student = student;
    }

}
