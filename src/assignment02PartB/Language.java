/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Language.java
 * @author: Duc Ta
 * @author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public class Language {

    //
    // Static Data Fields
    //
    private static final String defaultPreference = "English"; // default
    private static final String officialGreeting = "Say Hey Willie";
    private static final String officialSong = "Take Me out to the Ball Game";
    private static final String officialAppName = "SF Giants Thank You";

    /**
     * The language to use for this instance.
     */
    private final String language;

    /**
     * Initialize {@link Language} with {@link #defaultPreference} as the
     * language.
     */
    public Language() {
        this.language = defaultPreference;
    }

    /**
     * Initialize {@link Language} with {@code language}.
     *
     * @param language The language to use.
     */
    public Language(String language) {
        this.language = language;
    }
}
