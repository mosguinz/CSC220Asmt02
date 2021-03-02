/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: University.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.util.ResourceBundle;

public class University {

    /**
     * Name of the university. Note that this is independent of the default university name defined
     * in Config and is never localized.
     */
    private final String name;

    public University() {
        final ResourceBundle bundle = ResourceBundle
                .getBundle("assignment02PartB.resources.UniversityData");
        this.name = bundle.getString("name");
    }

    public String getName() {
        return name;
    }
}