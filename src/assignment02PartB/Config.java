/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Config.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public final class Config {

    //
    // Static Data Fields
    // @formatter:off
    private static final Language defaultLang = new Language("English"); // Default
    private static final Timer defaultTimer = new Timer("Pacific Standard Time"); // Default
    private static final Color defaultColor = new Color("ANSI"); // Default
    private static final String defaultLogDirectoryPath = "./src/assignment02PartB/log/"; // Default
    private static final Directory defaultLogDirectory = new Directory(defaultLogDirectoryPath); // Default
    private static final String defaultStdOutFilePath = "./src/assignment02PartB/log/StandardOut.log"; // Default
    private static final String defaultStdErrFilePath = "./src/assignment02PartB/log/StandardErr.log"; // Default
    private static final StdOutStdErrTee defaultStdOutStdErrTee = new StdOutStdErrTee(Config.defaultStdOutFilePath, Config.defaultStdErrFilePath); // Default
    private static final String defaultClubName = "San Francisco Giants"; // Default
    private static final Club defaultClub = new Club();
    private static final String defaultUniversityName = "San Francisco State University"; // Default
    private static final University defaultUniversity = new University();
    // @formatter:on

    //
    // Instance Data Fields
    //
    private Language lang;
    private Timer timer;
    private Color color;
    private String logDirectoryPath;
    private Directory logDirectory;
    private String stdOutFilePath;
    private String stdErrFilePath;
    private StdOutStdErrTee stdOutStdErrTee;
    private String clubName;
    private Club club;
    private String universityName;
    private University university;

    public static Language getDefaultLang() {
        return defaultLang;
    }

    public static Timer getDefaultTimer() {
        return defaultTimer;
    }

    public static Color getDefaultColor() {
        return defaultColor;
    }

    public static String getDefaultLogDirectoryPath() {
        return defaultLogDirectoryPath;
    }

    public static Directory getDefaultLogDirectory() {
        return defaultLogDirectory;
    }

    public static String getDefaultStdOutFilePath() {
        return defaultStdOutFilePath;
    }

    public static String getDefaultStdErrFilePath() {
        return defaultStdErrFilePath;
    }

    public static StdOutStdErrTee getDefaultStdOutStdErrTee() {
        return defaultStdOutStdErrTee;
    }

    public static String getDefaultClubName() {
        return defaultClubName;
    }

    public static Club getDefaultClub() {
        return defaultClub;
    }

    public static String getDefaultUniversityName() {
        return defaultUniversityName;
    }

    public static University getDefaultUniversity() {
        return defaultUniversity;
    }

    public Language getLang() {
        return lang;
    }

    public Timer getTimer() {
        return timer;
    }

    public Color getColor() {
        return color;
    }

    public String getLogDirectoryPath() {
        return logDirectoryPath;
    }

    public Directory getLogDirectory() {
        return logDirectory;
    }

    public String getStdOutFilePath() {
        return stdOutFilePath;
    }

    public String getStdErrFilePath() {
        return stdErrFilePath;
    }

    public StdOutStdErrTee getStdOutStdErrTee() {
        return stdOutStdErrTee;
    }

    public String getClubName() {
        return clubName;
    }

    public Club getClub() {
        return club;
    }

    public String getUniversityName() {
        return universityName;
    }

    public University getUniversity() {
        return university;
    }

    private void displayInfo() {
        System.out.println(lang);
        System.out.println(timer.getTimeZoneName());
        System.out.println(color.getEncoding());
        System.out.println(stdOutFilePath);
        System.out.println(stdErrFilePath);
        System.out.println("[receipt log]");
        System.out.println("[club/uni]");
    }

    public void setPreferences() {
        //...
        this.displayInfo();
    }
}
