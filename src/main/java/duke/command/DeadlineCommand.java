package duke.command;

import duke.task.Deadline;
import java.time.format.DateTimeParseException;

public class DeadlineCommand extends Commands {

    String input;
    String line;

    public DeadlineCommand(String input, String line) {
        this.input = input;
        this.line = line;
    }

    @Override
    public void execute() {
        try {
            Deadline deadline = new Deadline(input);
            deadline.setBy(input);
            tasksList.addTask(deadline);
            System.out.println(line);
            System.out.println("Got it. I've added this task");
            System.out.println(deadline);
            System.out.println("Now you have " + tasksList.getTaskListSize() + " tasks in the list.");
            System.out.println("\n" + line);
        } catch (DateTimeParseException e) {
            System.out.println("Incorrect date and time format. Please enter in (yyyy-mm-dd HH:mm) format");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect format for deadline. Please use the following format eg:" +
                    "deadline borrow book /by 2020-12-12 ");
        }
    }
}
