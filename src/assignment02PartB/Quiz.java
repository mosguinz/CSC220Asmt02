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
    private boolean passed;

    public Quiz(Club club, Student student) {
        bundle = Messenger.getConfig().getLang().getBundle("Quiz");
        this.club = club;
        this.student = student;
        this.questionAnswer = loadQuestionAnswers();
    }

    public boolean isPassed() {
        return passed;
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

    /**
     * Prompts the question to the user and read in the response.
     *
     * @param qa The {@link QuestionAnswer} object to use.
     * @return The user's answer.
     */
    private String promptQuestion(QuestionAnswer qa) {
        club.sayDialogue(qa.getQuestion());
        student.sayPrompt();
        return ChatSession.readStringIn();
    }

    /**
     * Run the quiz.
     */
    public void runQuiz() {
        int misses = 0;
        club.sayDialogue(String.format(bundle.getString("start.prompt"),
                club.getShortName().toUpperCase(), MISSES_ALLOWED));

        for (QuestionAnswer qa : questionAnswer) {
            if (qa.validateAnswer(promptQuestion(qa))) {
                club.sayDialogue(bundle.getString("response.correct"));
            } else {
                club.sayDialogue(bundle.getString("response.incorrect"));
                misses++;
            }
        }

        if (misses > MISSES_ALLOWED) {
            System.out.println(bundle.getString("finish.failure"));
            passed = false;
        } else {
            System.out.println(String.format(bundle.getString("finish.success"),
                    club.getShortName().toUpperCase())
            );
            passed = true;
        }
    }
}
