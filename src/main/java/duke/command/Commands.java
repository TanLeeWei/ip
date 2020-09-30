package duke.command;

import duke.task.TaskList;

public class Commands {

    protected TaskList tasksList;

    protected Commands() {
    }

    public void setData(TaskList tasksList) {
        this.tasksList = tasksList;
    }

    public void execute() {
        throw new UnsupportedOperationException("This method is to be implemented by child classes");
    }

}

