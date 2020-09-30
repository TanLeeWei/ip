package duke.command;

import duke.task.Event;

/**
 * Add event into Task List
 */
public class EventCommand extends Commands {

    public final String input;
    public final String line;

    public EventCommand(String input, String line) {
        this.input = input;
        this.line = line;
    }

    @Override
    public void execute() {
        try {
            Event event = new Event(input);
            event.setWhen(input);
            tasksList.addTask(event);
            System.out.println(line);
            System.out.println("Got it. I've added this task");
            System.out.println(event);
            System.out.println("Now you have " + tasksList.getTaskListSize() + " tasks in the list.");
            System.out.println("\n" + line);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Incorrect format for event input. Please follow the following format: e.g " +
                    " event project meeting /at Sunday");
            System.out.println("\n" + line);
        }
    }

}
