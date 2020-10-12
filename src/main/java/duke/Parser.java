package duke;

import duke.command.ByeCommand;
import duke.command.Commands;
import duke.command.DeadlineCommand;
import duke.command.DeleteCommand;
import duke.command.DoneCommand;
import duke.command.EmptyDescriptionCommand;
import duke.command.EventCommand;
import duke.command.FindCommand;
import duke.command.InvalidCommand;
import duke.command.ListCommand;
import duke.command.TodoCommand;


/**
 * Parses user inputs.
 */
public class Parser {

    public final String input;
    public static final String LINE = "____________________________________________________________";

    public Parser(String input) {
        this.input = input;
    }

    /**
     * Parses user inputs into different commands and allow the program to execute different commands
     *
     * @param input user input command string
     * @return command to execute base on user input
     */
    public static Commands parseCommand(String input) {
        String[] splitString = input.trim().split(" ", 2);
        splitString[0] = splitString[0].trim();
        splitString[0] = splitString[0].toLowerCase();
        try {
            switch (splitString[0]) {
                case "list":
                    return new ListCommand(LINE);
                case "todo":
                    return new TodoCommand(splitString[1].trim(), LINE);
                case "deadline":
                    return new DeadlineCommand(splitString[1].trim(), LINE);
                case "event":
                    return new EventCommand(splitString[1].trim(), LINE);
                case "done":
                    return new DoneCommand(splitString[1].trim(), LINE);
                case "delete":
                    return new DeleteCommand(splitString[1].trim(), LINE);
                case "find":
                    return new FindCommand(splitString[1].trim(), LINE);
                case "bye":
                    return new ByeCommand(LINE);
                default:
                    return new InvalidCommand(LINE);
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            return new EmptyDescriptionCommand(LINE);
        }
    }

}
