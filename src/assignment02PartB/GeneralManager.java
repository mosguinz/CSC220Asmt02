/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: GeneralManager.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public class GeneralManager extends FrontOffice {

    //
    // Instance Data Fields
    //
    private String position;

    public GeneralManager(String fullName, Club club) {
        super(fullName.split("\\s")[0], fullName.split("\\s")[1], club);
    }

    @Override
    public String displayInfo() {
        return toString();
    }
}
