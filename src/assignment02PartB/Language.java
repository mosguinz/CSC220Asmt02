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

import java.util.Locale;
import java.util.ResourceBundle;

// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"
public class Language {

    //
    // Static Data Fields
    //
    private static final String defaultPreference = "English"; // default
    private static final String officialGreeting = "Say Hey Willie";
    private static final String officialSong = "Take Me out to the Ball Game";
    private static final String officialAppName = "SF Giants Thank You";

    private static final String LANGUAGE_PATH = "assignment02PartB.resources.resources.i18n";
    private static final Locale DEFAULT_LOCALE = new Locale("en");
    private static final Locale[] SUPPORTED_LOCALES = {
            DEFAULT_LOCALE, new Locale("th"), new Locale("alien")
    };

    /**
     * The language to use for this instance.
     */
    private final String language;

    /**
     * Initialize {@link Language} with {@link #defaultPreference} as the language.
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

    /**
     * Gets a supported language from the input.
     * <p>
     * {@code input} can be either the language code or the name of the language itself. Returns
     * {@link #DEFAULT_LOCALE} if the language is not supported.
     *
     * @param input The desired language.
     * @return The {@link Locale} object representing the language.
     */
    private static Locale findLocale(String input) {
        input = input.strip();
        for (Locale locale : SUPPORTED_LOCALES) {
            if (locale.getLanguage().equalsIgnoreCase(input)
                    || locale.getDisplayLanguage().equalsIgnoreCase(input)) {
                return locale;
            }
        }
        return DEFAULT_LOCALE;
    }

    public static String getOfficialSong() {
        return officialSong;
    }

    public ResourceBundle getBundle(String className) {
        return ResourceBundle.getBundle(className);
    }
}
