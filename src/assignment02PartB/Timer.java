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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Timer {

    private static final String defaultTimeZone = "Pacific Standard Time";

    private static final TimeZone DEFAULT_TZ = TimeZone.getTimeZone("America/Los_Angeles");
    private final TimeZone timeZoneObject;
    private final String timeZoneName;
    private boolean isDst = false;

    /**
     * Initialize {@link Timer} with {@link #defaultTimeZone} as the time zone.
     */
    public Timer() {
        this.timeZoneObject = DEFAULT_TZ;
        this.timeZoneName = defaultTimeZone;
    }

    /**
     * Initialize {@link Timer} with the {@code timeZone}.
     *
     * @param timeZoneName The time zone to use.
     */
    public Timer(String timeZoneName) {
        this.timeZoneObject = findTimeZone(timeZoneName);
        this.timeZoneName = timeZoneObject.getDisplayName(isDst, TimeZone.LONG);
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    /**
     * Finds the corresponding {@link TimeZone} object to the provided string.
     * <p>
     * <b>Warning: this method may be expensive to run.</b>
     * <p>
     * The provided string should be representative of a time zone in either IANA format or its
     * canonical aliases. If a time zone cannot be found, then {@link #DEFAULT_TZ} is returned.
     *
     * @param q The alias to lookup.
     * @return The {@link TimeZone} object corresponding to the alias.
     */
    private TimeZone findTimeZone(String q) {
        for (String supportedId : TimeZone.getAvailableIDs()) {
            TimeZone tz = TimeZone.getTimeZone(supportedId);

            // If it's the IANA ID.
            if (q.equalsIgnoreCase(supportedId)) {
                return tz;
            }
            // If it matches the daylight version of the name.
            if (q.equalsIgnoreCase(tz.getDisplayName(true, TimeZone.LONG))
                    || q.equalsIgnoreCase(tz.getDisplayName(true, TimeZone.SHORT))) {
                isDst = true;
                return tz;
            }
            // If it matches the non-daylight version of the name.
            if (q.equalsIgnoreCase(tz.getDisplayName(false, TimeZone.LONG))
                    || q.equalsIgnoreCase(tz.getDisplayName(false, TimeZone.SHORT))) {
                isDst = false;
                return tz;
            }
        }
        return DEFAULT_TZ;
    }

    /**
     * Generates a timestamp in the format specified in the sample output.
     * <p>
     * For example, "2021/02/27 06:23:15 [0726 ms] PM PST".
     *
     * @return The timestamp in question.
     */
    public String getChatTimestamp() {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss [SSSS 'ms'] a z");
        df.setTimeZone(timeZoneObject);
        return df.format(new Date());
    }
}
