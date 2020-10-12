package duke.command;

/**
 * Return a error message when the user input's description is empty
 */
public class EmptyDescriptionCommand extends Commands {

    public final String LINE;

    public EmptyDescriptionCommand(String LINE) {
        this.LINE = LINE;
    }

    @Override
    public void execute() {
        System.out.println(LINE);
        System.out.println("The description or index cannot be empty!!");
        System.out.println("\n" + LINE);
    }

}
