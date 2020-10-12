package duke.task;

import duke.exceptions.EmptyDescriptionException;

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
    public void setWhen(String description) throws EmptyDescriptionException {
        String[] descriptionString = description.split("/", 2);
        if (descriptionString[0].isEmpty()) {
            throw new EmptyDescriptionException();
        }
        when = descriptionString[1].trim();
        this.description = descriptionString[0].trim();
        descriptionString = when.split(" ", 2);
        when = descriptionString[0] + ": " + descriptionString[1];
    }

    public void assignWhen(String newWhen) {
        when = newWhen;
    }

    @Override
    public String toString() {
        return super.getTypeOfTask() + "[" + super.getStatusIcon() + "] " + this.description + " (" + this.when + ")";
    }

}
