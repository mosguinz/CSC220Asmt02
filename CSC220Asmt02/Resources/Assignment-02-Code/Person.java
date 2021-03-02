/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Person.java
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

public class Person implements Greeting {

    //
    // Instance Data Fields
    //
    private String firstName;
    private String lastName;

    //
    // Constructors
    //
    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Instance Methods
    public String getFirstName() {
        return this.firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //
    // Override
    //
    @Override
    public String toString() {
        return this.firstName + " " + this.lastName;
    }

    @Override
    public void sayHello(String name) {
        System.out.println(Messenger.getCommonIdx(3)  + " " + name
                + Messenger.getCommonIdx(0));
    }
}
