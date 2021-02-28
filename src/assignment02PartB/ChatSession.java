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

    public void runChatSession() {
        this.startChatSession();
        this.connectChatters();
        // Transaction

        this.runQuiz();
        //
        this.stopChatSession();
    }
}