import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        String[] texts = new String[100];
        String line;
        int NumberOfTexts = 0;
        Scanner in = new Scanner(System.in);

        System.out.println("_______________________________________________");
        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?");
        System.out.println("\n_______________________________________________");

        do{
            line = in.nextLine();
            if(!line.equals("bye") && !line.equals("list")){
                System.out.println("added: " + line + "\n");
                texts[NumberOfTexts] = line;
                NumberOfTexts++;
            }
            if(line.equals("list")){
                for(int i = 0; i < NumberOfTexts; i++){
                    System.out.println(i+1 + ". " + texts[i]);
                }
            }

        }while(!line.equals("bye"));

        System.out.println("Bye. Hope to see you again soon!");
        System.out.println("\n_______________________________________________");
    }
}
