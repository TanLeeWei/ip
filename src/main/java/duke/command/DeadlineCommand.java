package duke.command;

import duke.exceptions.EmptyDescriptionException;
import duke.task.Deadline;

import java.time.format.DateTimeParseException;

/**
 * Add deadline into Tasks List.
 * The accepted format of deadline is eg: deadline return book /by 2020-12-12 23:59, the time is optional
 */
public class DeadlineCommand extends Commands {

    public String input;
    public final String LINE;

    public DeadlineCommand(String input, String LINE) {
        this.input = input;
        this.LINE = LINE;
    }

    @Override
    public void execute() {
        try {
            Deadline deadline = new Deadline(input);
            deadline.setBy(input);
            tasksList.addTask(deadline);
            System.out.println(LINE);
            System.out.println("Got it. I've added this task");
            System.out.println(deadline);
            System.out.println("Now you have " + tasksList.getTaskListSize() + " tasks in the list.");
            System.out.println("\n" + LINE);
        } catch (DateTimeParseException e) {
            System.out.println("Incorrect date and time format. Please enter in (yyyy-mm-dd HH:mm) format");
            System.out.println("\n" + LINE);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect format for deadline. Please use the following format eg:" +
                    "deadline borrow book /by 2020-12-12 ");
            System.out.println("\n" + LINE);
        } catch (EmptyDescriptionException e) {
            System.out.println("Description cannot be empty!!");
            System.out.println("\n" + LINE);
        }
    }

}
