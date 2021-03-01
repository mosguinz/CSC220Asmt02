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
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Quiz {

    private static final int MISSES_ALLOWED = 1;

    private final Club club;
    private final Student student;
    private final ResourceBundle bundle;
    private final ArrayList<QuestionAnswer> questionAnswer;

    public Quiz(Club club, Student student) {
        bundle = Messenger.getConfig().getLang().getBundle("Quiz");
        this.club = club;
        this.student = student;
        this.questionAnswer = loadQuestionAnswers();
    }

    /**
     * Loads the questions and answers from the resource bundle.
     * <p>
     * Stops when the question and answer key-pairs in the resource bundle have been fully
     * enumerated.
     *
     * @return The {@link ArrayList} of {@link QuestionAnswer}.
     */
    private ArrayList<QuestionAnswer> loadQuestionAnswers() {
        int i = 1;
        ArrayList<QuestionAnswer> questionAnswer = new ArrayList<>();
        while (true) {
            try {
                questionAnswer.add(
                        new QuestionAnswer(
                                bundle.getString("question." + i),
                                bundle.getString("answer." + i)
                        ));
                i++;
            } catch (MissingResourceException e) {
                return questionAnswer;
            }
        }
    }
}
