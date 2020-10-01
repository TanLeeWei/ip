package duke.task;

import java.util.ArrayList;

public class TaskList {
    private static ArrayList<Task> tasksList;

    public TaskList(){
        tasksList = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasksList.add(task);
    }

    public void removeTask(int index) {
        tasksList.remove(index);
    }

    public Task getTask(int index) {
        return tasksList.get(index);
    }

    public ArrayList<Task> getAllTasks() {
        return tasksList;
    }

    public int getTaskListSize() {
        return tasksList.size();
    }
}
