/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: President.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public class President extends FrontOffice {

    /**
     * Unused field. Preserved in accordance with the requirements listed in the assignment
     * specification.
     */
    private String position;

    public President(String firstName, String lastName, Club club) {
        super(firstName, lastName, club);
    }

    /**
     * Unused method.
     *
     * @deprecated Implemented in order to allow compilation. Presumably, this method would be used
     *         to return the general manager's name alongside their position.
     */
    @Override
    @Deprecated
    public String displayInfo() {
        return toString();
    }
}
