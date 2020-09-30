package duke.command;

/**
 * Return a error message when the user input is invalid
 */
public class InvalidCommand extends Commands{

    public final String line;

    public InvalidCommand(String line) {
        this.line = line;
    }

    @Override
    public void execute() {
        System.out.println(line);
        System.out.println("This command is invalid. Please try again");
        System.out.println(line + "\n");
    }

}
