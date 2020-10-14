package duke.command;

/**
 * Print goodbye message when the user input is bye
 */
public class ByeCommand extends Commands {

    public final String LINE;

    public ByeCommand(String LINE) {
        this.LINE = LINE;
    }

    @Override
    public void execute() {
        System.out.println(LINE);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("\n" + LINE);
    }

}
