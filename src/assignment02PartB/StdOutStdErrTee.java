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
import java.io.UncheckedIOException;

public class StdOutStdErrTee extends OutputStream {

    private final OutputStream[] OUTPUT_STREAMS;

    public StdOutStdErrTee(String sOutPath, String sErrPath) {
        createStreams(sOutPath, sErrPath);
        OUTPUT_STREAMS = createStreams(sOutPath, sErrPath);
    }

    /**
     * Returns an array of {@link OutputStream}s to write the output to.
     * <p>
     * This method will attempt to create file output streams to write the standard output streams
     * to with the given filenames.
     * <p>
     * If the file exists but is a directory rather than a regular file, does not exist but cannot
     * be created, or cannot be opened for any other reason then the stream outputs will be stored
     * under {@link Config#defaultStdOutFilePath} and {@link Config#defaultStdErrFilePath},
     * respectively.
     *
     * @param sOutPath The filename under which to write the {@link java.lang.System#out} stream to.
     * @param sErrPath The filename under which to write the {@link java.lang.System#err} stream to.
     * @return The array of {@link OutputStream}s.
     * @see #defaultStreams()
     */
    private OutputStream[] createStreams(String sOutPath, String sErrPath) {
        try {
            return new OutputStream[]{
                new FileOutputStream(sOutPath), new FileOutputStream(sErrPath)
            };
        } catch (FileNotFoundException e) {
            System.err.printf(
                    "Could not create file output streams at '{}' and '{}'. Reason: {}\n"
                    + "Creating file output streams at default location instead...",
                    sOutPath, sErrPath, e.getMessage()
            );
            return defaultStreams();
        }
    }

    /**
     * Helper of {@link #createStreams(java.lang.String, java.lang.String)} to create default output
     * streams.
     * <p>
     * Due to the requirements defined in the the assessment specification, the default file paths
     * defined in {@link Config} cannot be edited. As such, exceptions arising from the creation of
     * the fallback {@link OutputStream}s are treated as "unrecoverable," raising an unchecked
     * exception as a result.
     *
     * @return The array of {@link OutputStream}s.
     * @throws UncheckedIOException If an I/O error occurs; see above for more information.
     * @see Config#defaultStdOutFilePath
     * @see Config#defaultStdErrFilePath
     * @see #createStreams(java.lang.String, java.lang.String)
     */
    private static OutputStream[] defaultStreams() throws UncheckedIOException {
        try {
            return new OutputStream[]{
                new FileOutputStream(Config.getDefaultStdOutFilePath()),
                new FileOutputStream(Config.getDefaultStdErrFilePath())
            };
        } catch (FileNotFoundException e) {
            throw new UncheckedIOException(e);
        }
    }
}
