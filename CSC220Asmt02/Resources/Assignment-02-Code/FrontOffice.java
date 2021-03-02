/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: FrontOffice.java
 * Author: Duc Ta
 * Author: <First Name> <Last Name>
 * **********************************************
 */

//
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
// Please DO NOT CHANGE this file.
//

package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

public abstract class FrontOffice extends Person {

    //
    // Instance Data Fields
    //
    private Club club;

    //
    // Constructors
    //
    protected FrontOffice() {
    }

    protected FrontOffice(String firstName, String lastName, Club club) {
        super(firstName, lastName);
        this.club = club;
    }

    //
    // Instance Methods
    //
    public Club getClub() {
        return this.club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    //
    // Abstract Methods
    //
    public abstract String displayInfo();
}
