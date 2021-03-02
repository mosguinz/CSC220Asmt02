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

import java.util.ResourceBundle;

public final class Config {

    // Static data fields from starter code
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

    private static final ResourceBundle configBundle = ResourceBundle
            .getBundle("assignment02PartB.resources.AppConfig");

    private String logDirectoryPath;
    private Directory logDirectory;
    private String stdOutFilePath;
    private String stdErrFilePath;
    private StdOutStdErrTee stdOutStdErrTee;
    private String receiptFilePath;
    private Language lang;
    private ResourceBundle langBundle;
    private Timer timer;
    private Color color;
    private Club club;
    private University university;

    public Config() {
        setLogPref();
        System.out.println(ChatSession.getAppBanner().toUpperCase());
        System.out.println();
    }

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

    public Club getClub() {
        return club;
    }

    public University getUniversity() {
        return university;
    }

    public String getReceiptFilePath() {
        return receiptFilePath;
    }

    private void displayInfo() {
        String[] labels = {
                langBundle.getString("language.label"),
                langBundle.getString("timeZone.label"),
                langBundle.getString("color.label"),
                langBundle.getString("stdOutLogPath.label"),
                langBundle.getString("stdErrLogPath.label"),
                langBundle.getString("receiptLogPath.label"),
                langBundle.getString("defaultClub.label"),
                langBundle.getString("defaultUniversity.label")
        };
        String[] values = {
                lang.getLanguage(),
                timer.getTimeZoneName(),
                color.getEncoding(),
                stdOutFilePath,
                stdErrFilePath,
                "",
                langBundle.getString("defaultClub.value"),
                langBundle.getString("defaultUniversity.value")
        };
        ChatSession.printLineSep();
        ChatSession.printTable(labels, values);
        ChatSession.printLineSep();
    }

    /**
     * Sets the preferences for log file locations.
     * <p>
     * Log configuration has the highest priority and is invoked in the sole constructor of the
     * {@link Config} class. This method is invoked prior to configuration of all other preferences
     * as it is required for the logger to start before all other processes.
     */
    private void setLogPref() {
        logDirectoryPath = configBundle.getString("logDirectoryPath");
        logDirectory = new Directory(logDirectoryPath);
        stdOutFilePath = configBundle.getString("stdOutFilePath");
        stdErrFilePath = configBundle.getString("stdErrFilePath");
        stdOutStdErrTee = new StdOutStdErrTee(stdOutFilePath, stdErrFilePath);
    }

    /**
     * Prompt the user for language preference.
     * <p>
     * This method has the highest priority after logger configuration ({@link #setLogPref()}) in
     * order to configure the necessary resource bundles for localized strings.
     *
     * @return The {@link Language} to use for this instance.
     * @see #setPreferences()
     */
    private Language promptLangPref() {
        System.out.print("Language: ");
        Language lang = new Language(ChatSession.readStringIn());
        langBundle = lang.getBundle("Config");
        return lang;
    }

    /**
     * Prompt the user for time zone preference.
     *
     * @return The {@link Timer} object to use for this instance.
     * @see #setPreferences()
     */
    private Timer promptTimerPref() {
        System.out.printf("%s: ", langBundle.getString("timeZone.label"));
        return new Timer(ChatSession.readStringIn());
    }

    /**
     * Set the program's preferences.
     * <p>
     * Default settings and program's data are loaded from the resource bundle(s). Preferences set
     * by the user are prompted via stdin (language and time zone for this implementation). Note
     * that the <b>language must be configured first</b> in order to determine the resource bundles
     * needed for localized texts.
     *
     * @see #promptLangPref()
     */
    public void setPreferences() {
        // Set by user prompts
        lang = promptLangPref();
        timer = promptTimerPref();

        // Set by config file
        color = new Color(configBundle.getString("color"));
        receiptFilePath = configBundle.getString("receiptFilePath");
        club = new Club();
        university = new University();

        this.displayInfo();
    }
}
