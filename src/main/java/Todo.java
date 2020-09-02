public class Todo extends Task {
    //protected boolean isDone;

    public Todo(String description){
        super(description);
    }


    public String toString(){
        //super.markAsDone();
        return "[T]" + "[" + super.getStatusIcon() + "]" + this.description;

    }
}
