public class Todo extends Task {

    public Todo(String description)  {
        super(description);
        super.typeOfTask = "[T]";
    }

    public String toString() {
        return super.getTypeOfTask() + "[" + super.getStatusIcon() + "] " + this.description;
    }
}
