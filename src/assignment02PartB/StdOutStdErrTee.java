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

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class StdOutStdErrTee extends OutputStream {

    private final OutputStream[] OUTPUT_STREAMS;

    public StdOutStdErrTee(String sOutPath, String sErrPath) {
        createStreams(sOutPath, sErrPath);
        OUTPUT_STREAMS = createStreams(sOutPath, sErrPath);
    }

    /**
     * Returns an array of {@link OutputStream}s to write the output to.
     *
     * @param sOutPath The filename under which to write the
     *                 {@link java.lang.System#out} stream to.
     * @param sErrPath The filename under which to write the
     *                 {@link java.lang.System#err} stream to.
     * @return The array of {@link OutputStream}s.
     */
    private OutputStream[] createStreams(String sOutPath, String sErrPath) {
        try {
            return new OutputStream[]{
                new FileOutputStream(sOutPath), new FileOutputStream(sErrPath)
            };
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
