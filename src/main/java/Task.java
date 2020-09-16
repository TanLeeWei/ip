public class Task {
    protected String description;
    protected boolean isDone;
    protected String typeOfTask;

    public Task(String description){
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public String getTypeOfTask() {
        return typeOfTask;
    }

    public void markAsDone() {
        isDone = true;
    }

    public String toString() {
        return this.description;
    }
}
