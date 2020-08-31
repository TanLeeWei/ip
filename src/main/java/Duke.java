import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        String line;
        Scanner in = new Scanner(System.in);

        System.out.println("_______________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?");
        System.out.println("\n_______________________________________________");

        do{
            line = in.nextLine();
            if(!line.equals("bye")) {
                System.out.println(line);
            }

        }while(!line.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("\n_______________________________________________");
    }
}
