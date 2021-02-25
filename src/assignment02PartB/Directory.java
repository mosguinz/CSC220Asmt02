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

    /**
     * The string representation of the path. The primary purpose of this field
     * is to ensure that the output of the program matches those of the example
     * output.
     *
     * Always a relative path if provided by the starter code.
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

    /**
     * Create a {@link Directory} object from the {@code path}.
     *
     * @param path The pathname at which the directory is to be created.
     */
    public Directory(String path) {
        this.path = path;
        this.directory = new File(path);
        directory.mkdirs();
    }

}
