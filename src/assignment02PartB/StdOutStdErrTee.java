/*
 * **********************************************
 * San Francisco State University
 * CSC 220 -  Data Structures
 * File Name: StdOutStdErrTee.java
 * Author: Duc Ta
 * Author: Kullathon Sitthisarnwattanachai
 * **********************************************
 */
package assignment02PartB;
// Please organize all the given files in 1 same package
// Please make sure to read the provided "_ListOf-PleaseDoNotChange.txt"

import java.io.File;
import java.io.OutputStream;

public class StdOutStdErrTee extends OutputStream {

    private final String stdOutFilePath;
    private final String stdErrFilePath;
    private final File stdOutFile;
    private final File stdErrFile;

    public StdOutStdErrTee(String stdOutFilePath, String stdErrFilePath) {
        this.stdOutFilePath = stdOutFilePath;
        this.stdErrFilePath = stdErrFilePath;
    }
}
