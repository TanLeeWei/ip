package duke.command;

/**
 * Delete a task from the Task List
 */
public class DeleteCommand extends Commands {

    public int index;
    public String input;
    public final String LINE;

    public DeleteCommand(String input, String LINE) {
        this.input = input;
        this.LINE = LINE;
    }

    @Override
    public void execute() {
        try {
            if (input.equals("all")) {
                tasksList.getAllTasks().clear();
                System.out.println(LINE);
                System.out.println("All tasks have been removed");
                System.out.println("\n" + LINE);
            } else {
                index = Integer.parseInt(input) - 1;
                System.out.println(LINE);
                System.out.println("Noted. I've removed this task:\n" + tasksList.getTask(index));
                System.out.println("Now you have " + (tasksList.getTaskListSize() - 1) + " tasks in the list.");
                System.out.println("\n" + LINE);
                tasksList.removeTask(index);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("There is no task with this index. Please check the list and try again!");
            System.out.println("\n" + LINE);

        } catch (NumberFormatException e) {
            System.out.println("The input has to be an integer or all!");
            System.out.println("\n" + LINE);
        }
    }

}
