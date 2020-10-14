package duke.command;

import duke.task.Task;

/**
 * Display all the tasks in the Task List
 */
public class ListCommand extends Commands {

    public final String LINE;

    public ListCommand(String LINE) {
        this.LINE = LINE;
    }

    @Override
    public void execute() {
        int index = 1;
        System.out.println(LINE);
        if (tasksList.getAllTasks().isEmpty()) {
            System.out.println("There is no task in your list. Please add some tasks");
        } else {
            System.out.println("Here are the tasks in your list:");
            for (Task t : tasksList.getAllTasks()) {
                System.out.println(index + "." + t);
                index++;
            }
        }
        System.out.println("\n" + LINE);
    }

}
