//TanLeeWei

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        Task[] texts = new Task[100];
        String commands;
        String line = "____________________________________________________________";
        int numberOfTexts = 0;
        int textNumber;
        Scanner in = new Scanner(System.in);

        System.out.println(line);
        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?");
        System.out.println("\n" + line);

        do {
            commands = in.nextLine();
            String splitString[] = commands.split(" ", 2);

            switch (splitString[0]) {
                case "list":
                    System.out.println(line);
                    System.out.println("Here are the tasks in your list:");
                    for(int i = 0; i < numberOfTexts; i++) {
                        System.out.println(i + 1 + "." + texts[i]);
                    }
                    System.out.println("\n" + line);
                    break;
                case "todo":
                    Todo todo = new Todo(splitString[1]);
                    texts[numberOfTexts] = todo;
                    numberOfTexts++;
                    System.out.println(line);
                    System.out.println("Got it. I've added this task");
                    System.out.println(todo);
                    System.out.println("Now you have " + numberOfTexts + " tasks in the list.");
                    System.out.println("\n" + line);
                    break;
                case "deadline":
                    Deadline deadline = new Deadline(splitString[1]);
                    deadline.setBy(splitString[1]);
                    texts[numberOfTexts] = deadline;
                    numberOfTexts++;
                    System.out.println(line);
                    System.out.println("Got it. I've added this task");
                    System.out.println(deadline);
                    System.out.println("Now you have " + numberOfTexts + " tasks in the list.");
                    System.out.println("\n" + line);
                    break;
                case "event":
                    Event event = new Event(splitString[1]);
                    event.setWhen(splitString[1]);
                    texts[numberOfTexts] = event;
                    numberOfTexts++;
                    System.out.println(line);
                    System.out.println("Got it. I've added this task");
                    System.out.println(event);
                    System.out.println("Now you have " + numberOfTexts + " tasks in the list.");
                    System.out.println("\n" + line);
                    break;
                case "done":
                    textNumber = Integer.parseInt(splitString[1]) - 1;
                    texts[textNumber].markAsDone();
                    System.out.println(line);
                    System.out.println("Nice! I've marked this task as done:");
                    System.out.println(texts[textNumber]);
                    System.out.println("\n" + line);
                    break;
                case "bye":
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }
        } while (!commands.equals("bye"));

        System.out.println(line);
        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("\n" + line);
    }
}
