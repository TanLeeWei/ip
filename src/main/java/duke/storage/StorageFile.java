package duke.storage;

import duke.task.Deadline;
import duke.task.Event;
import duke.task.Todo;
import duke.task.TaskList;

import java.io.*;
import java.util.Scanner;

/**
 * Represent thefile to store the Task data
 */
public class StorageFile {

    /** Default file name if the user did not provide file name.*/
    private static String filePath = "data/duke.txt";

    private static TaskList tasksList;
    private static String line;

    public StorageFile(String line, TaskList tasksList) {
        this.line = line;
        this.tasksList = tasksList;
    }

    /**
     * Load the file when the user start the program
     * @return all the task from the previous usage
     */
    public static TaskList readFile(){
        try{
            File myFile = new File(filePath);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String file = myReader.nextLine();
                String[] splitString = file.split(" ", 2);
                if (file.contains("[T]")){
                    Todo todo = new Todo(splitString[1]);
                    if (file.contains("[✓]")) {
                        todo.markAsDone();
                    }
                    tasksList.addTask(todo);
                } else if (file.contains("[D]")) {
                    int start = splitString[1].indexOf("(") + 1;
                    int end = splitString[1].indexOf(")");
                    String by = splitString[1].substring(start, end);
                    String text = splitString[1].substring(0 , start - 1);
                    Deadline deadline = new Deadline(text);
                    deadline.assignBy(by);
                    if(file.contains("[✓]")) {
                        deadline.markAsDone();
                    }
                    tasksList.addTask(deadline);
                } else if (file.contains("[E]")) {
                    int start = splitString[1].indexOf("(") + 1;
                    int end = splitString[1].indexOf(")");
                    String when = splitString[1].substring(start, end);
                    String text = splitString[1].substring(0 , start - 1);
                    Event event = new Event(text);
                    event.assignWhen(when);
                    if(file.contains("[✓]")) {
                        event.markAsDone();
                    }
                    tasksList.addTask(event);
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Does not Exist. Nothing will be loaded");
            System.out.println(line);
        }
        return tasksList;
    }

    /**
     * Create the file to store all the tasks
     */
    public static void CreateFile(String filePath) {
        try {
            File myObj = new File(filePath);
            if (!myObj.getParentFile().exists()) {
                myObj.getParentFile().mkdirs();
            }
            if (myObj.exists()){
                return;
            } else {
                myObj.createNewFile();
            }

        } catch (IOException e){
            System.out.println("An error occurred while creating file");
        }
    }

    /**
     * Empty the file for saving purposes
     */
    public static void ClearFile(String filePath) {
        try {
            PrintWriter writer = new PrintWriter(filePath);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred while clearing file");
        }
    }

    /**
     * Save all the task into the file after each user input
     */
    public static void writeToFile() {
        try {
            CreateFile(filePath);
            ClearFile(filePath);
            FileWriter myWriter = new FileWriter(filePath);
            for (int i = 0; i < tasksList.getTaskListSize(); i++) {
                if (tasksList.getTask(i).getDone() == true) {
                    myWriter.write(tasksList.getTask(i).toString() + "\n");
                } else {
                    myWriter.write(tasksList.getTask(i).toString() + "\n");
                }
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occur. Unable to save to file.");
        }
    }

}
