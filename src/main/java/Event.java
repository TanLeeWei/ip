public class Event extends Task {

    protected String when;

    public Event(String description){
        super(description);
    }

    public void setWhen(String description){
        String[] arrOfStr = description.split("/", 2);
        when = arrOfStr[1];
        this.description = arrOfStr[0];
        arrOfStr = when.split(" ", 2);
        when = arrOfStr[0] + ": " + arrOfStr[1];
    }

    public String getWhen(){
        return when;
    }

    public String toString(){

        return "[E]" + "[" + super.getStatusIcon() + "]" + this.description + "(" + this.when + ")";
    }

}
