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
        String line;
        String secondline;
        int NumberOfTexts = 0;
        int TextNumber;
        Scanner in = new Scanner(System.in);

        System.out.println("_______________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?");
        System.out.println("\n_______________________________________________");

        do{
            line = in.next();
            if(!line.equals("bye") && !line.equals("list") && !line.equals("done")){
                secondline = in.nextLine();
                line = line + secondline;
                Task t = new Task(line);
                System.out.println("added: " + line + "\n");
                texts[NumberOfTexts] = t;
                NumberOfTexts++;
            }
            if(line.equals("list")){
                System.out.println("Here are the tasks in your list:");
                for(int i = 0; i < NumberOfTexts; i++){
                    System.out.println(i+1 + "." + "[" + texts[i].getStatusIcon() + "] " + texts[i] );
                }
            }
            if(line.equals("done")){
                TextNumber = in.nextInt() - 1;
                texts[TextNumber].markAsDone();
                System.out.println("Nice! I've marked this task as done:");
                System.out.println("  [" + texts[TextNumber].getStatusIcon() + "] " + texts[TextNumber]);
            }

        }while(!line.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("\n_______________________________________________");
    }
}
