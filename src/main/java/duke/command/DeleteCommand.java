package duke.command;

/**
 * Delete a task from the Task List
 */
public class DeleteCommand extends Commands {

    public int index;
    public final String input;
    public final String line;

    public DeleteCommand(String input, String line) {
        this.input = input;
        this.line = line;
    }

    @Override
    public void execute() {
        try {
            if (input.equals("all")) {
                tasksList.getAllTasks().clear();
                System.out.println(line);
                System.out.println("All tasks have been removed");
                System.out.println("\n" + line);
            } else {
                index = Integer.parseInt(input) - 1;
                System.out.println(line);
                System.out.println("Noted. I've removed this task:\n" + tasksList.getTask(index));
                System.out.println("Now you have " + (tasksList.getTaskListSize() - 1) + " tasks in the list.");
                System.out.println("\n" + line);
                tasksList.removeTask(index);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The index cannot be found. Please check the list and try again");
            System.out.println("\n" + line);

        } catch (NumberFormatException e) {
            System.out.println("The input has to be an integer or all");
            System.out.println("\n" + line);
        }
    }

}
