public class Event extends Task {

    protected String when;

    public Event(String description) {
        super(description);
        super.typeOfTask = "[E]";
    }

    public void setWhen(String description) {
        String[] arrayOfString = description.split("/", 2);
        when = arrayOfString[1];
        this.description = arrayOfString[0];
        arrayOfString = when.split(" ", 2);
        when = arrayOfString[0] + ": " + arrayOfString[1];
    }

    public String getWhen() {
        return when;
    }

    public String toString() {

        return super.getTypeOfTask() + "[" + super.getStatusIcon() + "] " + this.description + "(" + this.when + ")";
    }

}
