package duke.command;

import duke.task.Todo;

public class TodoCommand extends Commands {

    public final String input;
    public final String line;

    public TodoCommand(String input, String line) {
        this.input = input;
        this.line = line;
    }

    @Override
    public void execute() {
        try {
            Todo todo = new Todo(this.input);
            tasksList.addTask(todo);
            System.out.println(line);
            System.out.println("Got it. I've added this task");
            System.out.println(todo);
            System.out.println("Now you have " + tasksList.getTaskListSize() + " tasks in the list.");
            System.out.println("\n" + line);
        } catch (NullPointerException e) {
            System.out.println("An error occurred");
        }
    }

}
