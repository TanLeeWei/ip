public class Deadline extends Task{

    protected String by;

    public Deadline(String description){
        super(description);
        //this.by = by;
    }

    public void setBy(String description){
        String[] arrOfStr = description.split("/", 2);
        by = arrOfStr[1];
        this.description = arrOfStr[0];
        arrOfStr = by.split(" ", 2);
        by = arrOfStr[0] + ": " + arrOfStr[1];
    }

    public String getBy(){
        return by;
    }

    public String toString(){

        return "[D]" + "[" + super.getStatusIcon() + "]" + this.description + "(" + this.by + ")";
    }

}
