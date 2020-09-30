package duke.command;

import duke.task.Task;
import java.util.ArrayList;

/**
 * Find a task according to keyword given by user
 */
public class FindCommand extends Commands {

    public final String input;
    public final String line;
    public ArrayList<Task> matchingTask = new ArrayList<>();

    public FindCommand(String input, String line) {
        this.input = input;
        this.line = line;
    }

    @Override
    public void execute() {
        int index = 1;
        for (Task t: tasksList.getAllTasks()) {
            if (t.toString().toLowerCase().contains(input)){
                matchingTask.add(t);
            }
        }
        System.out.println(line);
        if (matchingTask.isEmpty()) {
            System.out.println("There are not matching tasks in your list");
        } else {
            System.out.println("Here are the matching tasks in your list:");
            for (Task t : matchingTask) {
                System.out.println(index + "." + t);
                index++;
            }
        }
        System.out.println(line);
    }

}
