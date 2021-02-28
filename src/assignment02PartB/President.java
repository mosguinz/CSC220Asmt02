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

    //
    // Instance Data Fields
    //
    private String position;

    public President(String firstName, String lastName, Club club) {
        super(firstName, lastName, club);
    }

    @Override
    public String displayInfo() {
        return toString();
    }
}
