/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: Directory.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.io.File;

public class Directory {

    //
    // Instance Data Fields
    //
    /**
     * The string representation of the path.
     */
    private String path;
    /**
     * The {@link File} object that represents the directory.
     */
    private File directory;

    //
    // Constructors
    //
    public Directory() {
    }

    public Directory(String path) {
        this.path = path;
        this.directory = createPath(path);
    }

    private static File createPath(String path) {
        return;
    }
}
