package com.musala.atmosphere.commons.sa;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.musala.atmosphere.commons.util.Pair;

public class ConsoleControl {
    private static final String LINE_SEPARATOR = System.getProperty("line.separator");

    private static final String LINE_PREFFIX = ">> ";

    private static final Logger LOGGER = Logger.getLogger(ConsoleControl.class.getCanonicalName());

    private BufferedReader consoleReader;

    private BufferedWriter consoleWriter;

    /**
     * Creates console for the agent and associates it with {@link System#in System.in} and {@link System#out
     * System.out}.
     */
    public ConsoleControl() {
        consoleReader = new BufferedReader(new InputStreamReader(System.in));
        consoleWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    /**
     * Prints command prompt message and read the rest of the line.
     *
     * @return - A String containing the command and parameters of the user.
     * @throws IOException
     *         - if an I/O exception of some sort has occurred.
     */
    public String readCommand() throws IOException {
        write(LINE_PREFFIX);
        String line = readLine();
        return line;
    }

    /**
     * Reads single line of text from the console. A line is considered to be terminated by any one of a line feed
     * ('\n'), a carriage return ('\r'), or a carriage return followed immediately by a linefeed.
     *
     * @return - A String containing the contents of the line, not including any line-termination characters, or null if
     *         the end of the stream has been reached
     * @throws IOException
     *         - if the agent is started through IDE, it is possible for an IOException to be thrown while reading from
     *         the System.in
     */
    public String readLine() throws IOException {
        String line = consoleReader.readLine();
        return line;
    }

    /**
     * Prints message to the agent console. No new line will be added to the end of the message.
     *
     * @param message
     *        - message or command to be written on the agent console.
     */
    public void write(String message) {
        try {
            consoleWriter.write(message);
            consoleWriter.flush();
        } catch (IOException e) {
            LOGGER.error("Error while printing information on the console.", e);
        }
    }

    /**
     * Prints line of text to the console. The line consists of the given text, concatenated with the character for new
     * line.
     *
     * @param message
     *        - message or command to be written on the agent console.
     */
    public void writeLine(String message) {
        write(message + LINE_SEPARATOR);
    }

    /**
     * Parses given shell command in two: command and parameters, and returns the result as a Pair.
     *
     * @param passedCommand
     *        - full command for execution.
     * @return Pair&lt;String, List&lt;String&gt;&gt; where the key is the command and the value is a list with the
     *         passed parameters as strings.
     */
    public static Pair<String, List<String>> parseShellCommand(String passedCommand) {
        // parsing the command where character is ' ' OR ':'
        String[] args = passedCommand.trim().split("[ :]");
        int numberOfParams = args.length - 1;
        String command = args[0];
        String[] params = new String[numberOfParams];

        // Copy args array in params shifted with one position.
        System.arraycopy(args, 1, params, 0, numberOfParams);

        Pair<String, List<String>> parsedShellCommand = new Pair<>(command, Arrays.asList(params));
        return parsedShellCommand;
    }

}
