package duke.command;

import duke.exceptions.EmptyDescriptionException;
import duke.task.Event;

/**
 * Add event into Task List
 */
public class EventCommand extends Commands {

    public String input;
    public final String LINE;

    public EventCommand(String input, String LINE) {
        this.input = input;
        this.LINE = LINE;
    }

    @Override
    public void execute() {
        try {
            Event event = new Event(input);
            event.setWhen(input);
            tasksList.addTask(event);
            System.out.println(LINE);
            System.out.println("Got it. I've added this task");
            System.out.println(event);
            System.out.println("Now you have " + tasksList.getTaskListSize() + " tasks in the list.");
            System.out.println("\n" + LINE);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect format for event input. Please follow the following format: e.g " +
                    " event project meeting /at Sunday");
            System.out.println("\n" + LINE);
        } catch (EmptyDescriptionException e) {
            System.out.println("Description cannot be empty!!");
            System.out.println("\n" + LINE);
        }
    }

}
