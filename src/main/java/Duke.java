
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class Duke {
    private static ArrayList<Task> tasks = new ArrayList<>();
    static final String line = "____________________________________________________________";

    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        String commands;
        int textNumber;
        Scanner in = new Scanner(System.in);
        String filePath = "data/duke.txt";

        System.out.println(line);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?");
        System.out.println("\n" + line);
        ReadFile(filePath);

        do {
            commands = in.nextLine();
            String splitString[] = commands.split(" ", 2);
            try {
                switch (splitString[0]) {
                    case "list":
                        System.out.println(line);
                        System.out.println("Here are the tasks in your list:");
                        for (int i = 0; i < tasks.size(); i++) {
                            System.out.println(i + 1 + "." + tasks.get(i));
                        }
                        System.out.println("\n" + line);
                        break;
                    case "todo":
                        Todo todo = new Todo(splitString[1]);
                        if(splitString[1].isEmpty()){
                            throw new ArrayIndexOutOfBoundsException();
                        }
                        tasks.add(todo);
                        System.out.println(line);
                        System.out.println("Got it. I've added this task");
                        System.out.println(todo);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        System.out.println("\n" + line);
                        break;
                    case "deadline":
                        Deadline deadline = new Deadline(splitString[1]);
                        deadline.setBy(splitString[1]);
                        tasks.add(deadline);
                        System.out.println(line);
                        System.out.println("Got it. I've added this task");
                        System.out.println(deadline);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        System.out.println("\n" + line);
                        break;
                    case "event":
                        Event event = new Event(splitString[1]);
                        event.setWhen(splitString[1]);
                        tasks.add(event);
                        System.out.println(line);
                        System.out.println("Got it. I've added this task");
                        System.out.println(event);
                        System.out.println("Now you have " + tasks.size() + " tasks in the list.");
                        System.out.println("\n" + line);
                        break;
                    case "done":
                        textNumber = Integer.parseInt(splitString[1]) - 1;
                        tasks.get(textNumber).markAsDone();
                        System.out.println(line);
                        System.out.println("Nice! I've marked this task as done:");
                        System.out.println(tasks.get(textNumber));
                        System.out.println("\n" + line);
                        break;
                    case "delete":
                        textNumber = Integer.parseInt(splitString[1]) - 1;
                        System.out.println(line);
                        System.out.println("Noted. I've removed this task:");
                        System.out.println(tasks.get(textNumber));
                        System.out.println("Now you have " + (tasks.size() - 1) + " tasks in the list.");
                        System.out.println("\n" + line);
                        tasks.remove(textNumber);
                        break;
                    case "bye":
                        break;
                    default:
                        throw new InvalidCommandException();
                }
                WriteToFile(filePath);

            } catch (ArrayIndexOutOfBoundsException exception) {
                System.out.println(line);
                System.out.println("OOPS!!! The description of a " + splitString[0] + " cannot be empty.");
                System.out.println("\n" + line);
            } catch (InvalidCommandException exception) {
                System.out.println(line);
                System.out.println("OPPS!!! I'm sorry, but I don't know what that means :-(");
                System.out.println("\n" + line);
            }

        } while (!commands.equals("bye"));

        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("\n" + line);
    }

    public static void WriteToFile(String filePath) {
            try {
                ClearFile(filePath);
                CreateFile(filePath);
                FileWriter myWriter = new FileWriter(filePath);
                for (int i = 0; i < tasks.size(); i++) {
                    if(tasks.get(i).isDone == true) {
                        myWriter.write("1|" +tasks.get(i).toString() + "\n");
                    }
                    else{
                        myWriter.write("0|" +tasks.get(i).toString() + "\n");
                    }
                }
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occur");
            }
    }

    public static void ReadFile(String filePath){
        try{
            File myFile = new File(filePath);
            Scanner myReader = new Scanner(myFile);
            while (myReader.hasNextLine()) {
                String file = myReader.nextLine();
                System.out.println(file);
                String splitString[] = file.split(" ", 2);
                if(file.contains("[T]")){
                    Todo todo = new Todo(splitString[1]);
                    if(file.contains("1")) {
                        todo.markAsDone();
                    }
                    tasks.add(todo);
                }
                else if(file.contains("[D]")) {
                    int start = splitString[1].indexOf("(") + 1;
                    int end = splitString[1].indexOf(")");
                    String by = splitString[1].substring(start, end);
                    String text = splitString[1].substring(0 , start - 1);
                    Deadline deadline = new Deadline(text);
                    deadline.by = by;
                    if(file.contains("1")) {
                        deadline.markAsDone();
                    }
                    tasks.add(deadline);
                }
                else if(file.contains("[E]")) {
                    int start = splitString[1].indexOf("(") + 1;
                    int end = splitString[1].indexOf(")");
                    String when = splitString[1].substring(start, end);
                    String text = splitString[1].substring(0 , start - 1);
                    Event event = new Event(text);
                    event.when = when;
                    if(file.contains("1")) {
                        event.markAsDone();
                    }
                    tasks.add(event);
                }
            }
            myReader.close();
            System.out.println(line);
        } catch (FileNotFoundException e){
            System.out.println("File Does not Exist");
            System.out.println(line);
        }
    }

    public static void CreateFile(String filePath) {
        try {
            File myObj = new File(filePath);
            if(!myObj.getParentFile().exists()) {
                myObj.getParentFile().mkdirs();
            }
            if(myObj.exists()){
                return;
            }
            else {
                myObj.createNewFile();
                System.out.println("File created");
            }

        } catch(IOException e){
            System.out.println("An error occured");
        }
    }

    public static void ClearFile(String filePath) {
        try {
            PrintWriter writer = new PrintWriter(filePath);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occured");
        }

    }
}


