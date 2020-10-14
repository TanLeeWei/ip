package duke.command;

/**
 * Return a error message when the user input is invalid
 */
public class InvalidCommand extends Commands {

    public final String LINE;

    public InvalidCommand(String LINE) {
        this.LINE = LINE;
    }

    @Override
    public void execute() {
        System.out.println(LINE);
        System.out.println("This command is invalid. Please try again");
        System.out.println("\n" + LINE);
    }

}
