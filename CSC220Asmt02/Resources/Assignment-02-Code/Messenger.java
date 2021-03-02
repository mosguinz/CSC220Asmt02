/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Messenger.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

//
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
//

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Messenger {

    //
    // Static Data Fields
    //
    private static final Config config = new Config();

    //
    // Constructors
    //
    private Messenger() {
    }

    //
    // main
    //
    public static void main(String[] args) {
        Messenger.config.getStdOutStdErrTee().startLog();
        Messenger.config.setPreferences();
        (new ChatSession(Messenger.config.getClub(), Messenger.config.getUniversity())).runChatSession();
        StdOutStdErrTee.stopLog();

        // Please feel free to use GraderTest to test our programs.
        // Grader tests are not a part of our required output.
        // GraderTest.run();
    }

    //
    // Static Methods
    //
    public static Config getConfig() {
        return Messenger.config;
    }


    //
    // Method Shortcuts (convenient but optional to use)
    // Please DO NOT CHANGE this file. Please DO NOT comment out code.
    //
    public static String getGreetingIdx(int i) {
        return Messenger.getConfig().getLang().getGreetingIdx(i);
    }
    public static String getFrontOfficeIdx(int i) {
        return Messenger.getConfig().getLang().getFrontOfficeIdx(i);
    }
    public static String getCardIdx(int i) {
        return Messenger.getConfig().getLang().getCardIdx(i);
    }
    public static String getChatSessionIdx(int i) {
        return Messenger.getConfig().getLang().getChatSessionIdx(i);
    }
    public static String getClubIdx(int i) {
        return Messenger.getConfig().getLang().getClubIdx(i);
    }
    public static String getColorIdx(int i) {
        return Messenger.getConfig().getLang().getColorIdx(i);
    }
    public static String getNowTime(String s) {
        return Messenger.getConfig().getTimer().getNowTime(s);
    }
    public static String getCommonIdx(int i) {
        return Messenger.getConfig().getLang().getCommonIdx(i);
    }
    public static String getDecorIdx(int i) {
        return Messenger.getConfig().getLang().getDecorIdx(i);
    }
    public static String getConfigIdx(int i) {
        return Messenger.getConfig().getLang().getConfigIdx(i);
    }
    public static String getGeneralManagerIdx(int i) {
        return Messenger.getConfig().getLang().getGeneralManagerIdx(i);
    }
    public static String getManagerIdx(int i) {
        return Messenger.getConfig().getLang().getManagerIdx(i);
    }
    public static String getMessengerIdx(int i) {
        return Messenger.getConfig().getLang().getMessengerIdx(i);
    }
    public static String getPersonIdx(int i) {
        return Messenger.getConfig().getLang().getPersonIdx(i);
    }
    public static String getPlayerIdx(int i) {
        return Messenger.getConfig().getLang().getPlayerIdx(i);
    }
    public static String getPresidentIdx(int i) {
        return Messenger.getConfig().getLang().getPresidentIdx(i);
    }
    public static String getQuestionAnswerIdx(int i) {
        return Messenger.getConfig().getLang().getQuestionAnswerIdx(i);
    }
    public static String getQuizIdx(int i) {
        return Messenger.getConfig().getLang().getQuizIdx(i);
    }
    public static String getReceiptIdx(int i) {
        return Messenger.getConfig().getLang().getReceiptIdx(i);
    }
    public static String getSFGiantsCardGeneratorIdx(int i) {
        return Messenger.getConfig().getLang().getSfGiantsCardGeneratorIdx(i);
    }
    public static String getStdOutStdErrTeeIdx(int i) {
        return Messenger.getConfig().getLang().getStdOutStdErrIdx(i);
    }
    public static String getStudentIdx(int i) {
        return Messenger.getConfig().getLang().getStudentIdx(i);
    }
    public static String getTimerIdx(int i) {
        return Messenger.getConfig().getLang().getTimerIdx(i);
    }
    public static String getUniversityIdx(int i) {
        return Messenger.getConfig().getLang().getUniversityIdx(i);
    }
}
