/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: GraderTest.java
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class GraderTest {

    //
    // Constructors
    //
    private GraderTest() {
    }

    //
    // Static Methods
    //
    public static void run() {

        System.out.println("\n\n\n");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("---------- Grader's Tests ----------");
        System.out.println("------------------------------------------------------------------------");

        String dir = Config.getDefaultLogDirectoryPath();
        for (String fileName : (new File(dir)).list()) {
            System.out.println("\n\n\n");
            System.out.println("********************************************************************");
            System.out.println("********************************************************************");
            System.out.println("*** Reading file:  " + fileName);
            System.out.println("*** Relative path: " + dir + fileName);
            System.out.println("*** ");
            readFile(dir+fileName);
        }

        //
        // Other tests
        //
    }

    private static void readFile(String filePath) {
        java.io.File file = new java.io.File(filePath);
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                System.out.println(input.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.err.println(e.toString());
        } finally {
            //
        }
    }
}
