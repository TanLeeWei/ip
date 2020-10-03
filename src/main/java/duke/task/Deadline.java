package duke.task;

import duke.task.Task;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Represent a deadline task in the Task List
 */
public class Deadline extends Task {

    protected String by;
    protected String date;
    protected String time;

    public Deadline(String description) {
        super(description);
        super.typeOfTask = "[D]";
    }

    /**
     * Set the date and time of the deadline
     */
    public void setBy(String description) {
        String[] arrOfStr = description.split("/", 2);
        by = arrOfStr[1];
        this.description = arrOfStr[0];
        arrOfStr = by.split(" ", 2);
        date = convertDateAndTime(arrOfStr[1]);
        by = arrOfStr[0] + ": " + date;
    }

    /**
     * Convert the date into Month in words , day , year format and the time into 12 hour clock format
     * @param dateAndTime the date and time given by the user input
     * @return the converted date and time
     */
    public String convertDateAndTime(String dateAndTime)  {
        String[] splitString = dateAndTime.split(" ", 2);
        if(splitString.length == 1) {
            LocalDate d1 = LocalDate.parse(splitString[0]);
            date =  d1.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
        }
        else {
            LocalDate d1 = LocalDate.parse(splitString[0]);
            date =  d1.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
            try {
                SimpleDateFormat _24HourTime = new SimpleDateFormat("HH:mm");
                SimpleDateFormat _12HourTime = new SimpleDateFormat("hh:mm a");
                Date t1 = _24HourTime.parse(splitString[1]);
                time = (_12HourTime.format(t1));
            } catch (final ParseException e) {
                return date + " " + splitString[1];
            }
            String dateTime =  date + " " + time;
            return dateTime;
        }
        return date;
    }

    public void assignBy(String newBy) {
        by = newBy;
    }

    public String toString() {
        return super.typeOfTask + "[" + super.getStatusIcon() + "] " + this.description + "(" + this.by + ")";
    }

}
