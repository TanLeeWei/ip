package duke.task;

/**
 * Represent a event task in the Task List
 */
public class Event extends Task {

    protected String when;

    public Event(String description) {
        super(description);
        super.typeOfTask = "[E]";
    }

    /**
     * Set the time and date of the event
     */
    public void setWhen(String description) {
        String[] arrayOfString = description.split("/", 2);
        when = arrayOfString[1];
        this.description = arrayOfString[0];
        arrayOfString = when.split(" ", 2);
        when = arrayOfString[0] + ": " + arrayOfString[1];
    }

    public void assignWhen(String newWhen) {
        when = newWhen;
    }

    public String toString() {

        return super.getTypeOfTask() + "[" + super.getStatusIcon() + "] " + this.description + "(" + this.when + ")";
    }

}
