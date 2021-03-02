/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Greeting.java
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

public interface Greeting {
    public static final String GREETING = Language.getOfficialGreeting();
    public default void sayHello() {
        System.out.println(Greeting.GREETING);
    }
    public abstract void sayHello(String name);
}