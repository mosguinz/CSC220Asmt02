/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Timer.java
 * @author: Duc Ta
 * @author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public class Timer {

    private static final String defaultTimeZone = "Pacific Standard Time";

    private final String timeZone;

    /**
     * Initialize {@link Timer} with {@link #defaultTimeZone} as the time zone.
     */
    public Timer() {
        this.timeZone = defaultTimeZone;
    }

    /**
     * Initialize {@link Timer} with the {@code timeZone}.
     *
     * @param timeZone The time zone to use.
     */
    public Timer(String timeZone) {
        this.timeZone = timeZone;
    }
}
