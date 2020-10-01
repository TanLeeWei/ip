package duke.command;

/**
 * Delete a task from the Task List
 */
public class DoneCommand extends Commands{
    public int textNumber;
    public String input;
    public String line;

    public DoneCommand(String input, String line) {
        this.input = input;
        this.line = line;
    }

    public void execute() {
        try {
            textNumber = Integer.parseInt(input) - 1;
            if (tasksList.getTask(textNumber).getDone() == true) {
                System.out.println(line);
                System.out.println("The task has already been marked as done!");
                System.out.println("\n" + line);
            } else {
                tasksList.getTask(textNumber).markAsDone();
                System.out.println(line);
                System.out.println("Nice! I've marked this task as done:");
                System.out.println(tasksList.getTask(textNumber));
                System.out.println("\n" + line);
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The index cannot be found. Please check the list and try again");
            System.out.println("\n" + line);
        }
    }

}

