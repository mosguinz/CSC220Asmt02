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
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UncheckedIOException;

public class StdOutStdErrTee extends OutputStream {

    private final OutputStream[] OUTPUT_STREAMS;
    private String sOutPath;
    private String sErrPath;

    public StdOutStdErrTee(String sOutPath, String sErrPath) {
        this.sOutPath = sOutPath;
        this.sErrPath = sErrPath;
        OUTPUT_STREAMS = createFileStreams(sOutPath, sErrPath);
    }

    private StdOutStdErrTee(PrintStream printStream, FileOutputStream fOutStream) {
        OUTPUT_STREAMS = new OutputStream[]{printStream, fOutStream};
    }

    /**
     * Returns an array of {@link FileOutputStream}s to write the output to.
     * <p>
     * This method will attempt to create file output streams to write the standard output streams
     * to with the given filenames.
     * <p>
     * If the file exists but is a directory rather than a regular file, does not exist but cannot
     * be created, or cannot be opened for any other reason then the method will attempt to create
     * the output streams at the default location instead.
     *
     * @param sOutPath The filename under which to write the {@link java.lang.System#out} stream
     *                 to.
     * @param sErrPath The filename under which to write the {@link java.lang.System#err} stream
     *                 to.
     * @return The array of {@link FileOutputStream}s.
     * @see #defaultFileStreams()
     */
    private static FileOutputStream[] createFileStreams(String sOutPath, String sErrPath) {
        try {
            return new FileOutputStream[]{
                    new FileOutputStream(sOutPath), new FileOutputStream(sErrPath)
            };
        } catch (FileNotFoundException e) {
            System.err.printf(
                    "Could not create file output streams at '%s' and '%s'. Reason: %s\n"
                            + "Creating file output streams at default location instead...",
                    sOutPath, sErrPath, e.getMessage()
            );
            return defaultFileStreams();
        }
    }

    /**
     * Helper of {@link #createFileStreams(java.lang.String, java.lang.String)} to create output
     * streams at the default location.
     * <p>
     * Due to the requirements defined in the the assessment specification, the default file paths
     * defined in {@link Config} cannot be edited. As such, exceptions arising from the creation of
     * the fallback {@link FileOutputStream}s are treated as "unrecoverable" and will raise an
     * unchecked exception as a result.
     *
     * @return The array of {@link FileOutputStream}s.
     * @throws UncheckedIOException If an I/O error occurs; see above for more information.
     * @see Config#getDefaultStdOutFilePath()
     * @see Config#getDefaultStdErrFilePath()
     * @see #createFileStreams(java.lang.String, java.lang.String)
     */
    private static FileOutputStream[] defaultFileStreams() throws UncheckedIOException {
        try {
            return new FileOutputStream[]{
                    new FileOutputStream(Config.getDefaultStdOutFilePath()),
                    new FileOutputStream(Config.getDefaultStdErrFilePath())
            };
        } catch (FileNotFoundException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * @deprecated Unused convenience method. Defined to allow compilation without editing {@link
     *         Messenger}.
     */
    @Deprecated
    public static void stopLog() {
    }

    /**
     * Starts logging.
     */
    public void startLog() {
        StdOutStdErrTee sOutTee = new StdOutStdErrTee(System.out,
                (FileOutputStream) OUTPUT_STREAMS[0]);
        StdOutStdErrTee sErrTee = new StdOutStdErrTee(System.err,
                (FileOutputStream) OUTPUT_STREAMS[1]);
        PrintStream sOut = new PrintStream(sOutTee);
        PrintStream sErr = new PrintStream(sErrTee);

        System.setOut(sOut);
        System.setErr(sErr);
    }

    @Override
    public void write(int b) throws IOException {
        for (OutputStream out : OUTPUT_STREAMS) {
            out.write(b);
            out.flush();
        }
    }
}