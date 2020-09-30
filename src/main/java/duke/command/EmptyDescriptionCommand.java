package duke.command;

public class EmptyDescriptionCommand extends Commands {

    public final String line;

    public EmptyDescriptionCommand(String line) {
        this.line = line;
    }

    @Override
    public void execute() {
        System.out.println(line);
        System.out.println("The description cannot be empty!!");
        System.out.println(line);
    }

}