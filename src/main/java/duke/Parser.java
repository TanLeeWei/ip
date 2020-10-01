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
    static final String line = "____________________________________________________________";

    public Parser(String input){
        this.input = input;
    }

    /**
     * Parses user inputs into different commands and allow the program to execute different commands
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
                return new ListCommand(line);
            case "todo":
                return new TodoCommand(splitString[1], line);
            case "deadline":
                return new DeadlineCommand(splitString[1], line);
            case "event":
                return new EventCommand(splitString[1], line);
            case "done":
                return new DoneCommand(splitString[1], line);
            case "delete":
                return new DeleteCommand(splitString[1], line);
            case "find":
                return new FindCommand(splitString[1], line);
            case "bye":
                return new ByeCommand(line);
            default:
                return new InvalidCommand(line);
            }
        } catch (ArrayIndexOutOfBoundsException exception) {
            return new EmptyDescriptionCommand(line);
        }
    }

}
