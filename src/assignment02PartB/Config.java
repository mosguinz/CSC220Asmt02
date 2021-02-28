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
    //
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

    //
    // Instance Data Fields
    //


	//
    public void setPreferences() {
		//...	
        this.displayInfo();
    }
}
