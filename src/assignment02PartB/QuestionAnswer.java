/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: QuestionAnswer.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

class QuestionAnswer {

    private final String question;
    private final String answer;

    public QuestionAnswer(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    /**
     * Validate the given {@code answer}. Validation is strips all trailing and leading whitespaces
     * and is case-insensitive.
     *
     * @param answer The answer to validate.
     * @return Whether the answer is correct.
     */
    public boolean validateAnswer(String answer) {
        return answer.strip().equalsIgnoreCase(this.answer);
    }

}
