package duke.command;

import duke.task.Todo;

/**
 * Add todo Task into the task list.
 */
public class TodoCommand extends Commands {

    public String input;
    public final String LINE;

    public TodoCommand(String input, String LINE) {
        this.input = input;
        this.LINE = LINE;
    }

    @Override
    public void execute() {
        try {
            Todo todo = new Todo(this.input);
            tasksList.addTask(todo);
            System.out.println(LINE);
            System.out.println("Got it. I've added this task");
            System.out.println(todo);
            System.out.println("Now you have " + tasksList.getTaskListSize() + " tasks in the list.");
            System.out.println("\n" + LINE);
        } catch (NullPointerException e) {
            System.out.println("An error occurred");
            System.out.println("\n" + LINE);
        }
    }

}
