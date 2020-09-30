package duke.command;

public class ByeCommand extends Commands{

    String line;

    public ByeCommand(String line) {
        this.line = line;
    }

    public void execute() {
        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("\n" + line);
    }

}