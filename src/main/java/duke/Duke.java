package duke;

import duke.command.Commands;
import duke.task.TaskList;
import duke.storage.StorageFile;
import duke.ui.Ui;

/**
 * Entry point of the Duke application.
 * Start up the application and starts the interaction with the user.
 */
public class Duke {

    static final String line = "____________________________________________________________";
    private static TaskList tasksList = new TaskList();
    private StorageFile storage = new StorageFile(line, tasksList);
    private Ui userInput = new Ui();

    public static void main(String[] args) {
        new Duke().run();
    }

    /**
     * Runs the program until termination is called
     */
    private void run() {
        start();
        runUntilByeIsCalled();
        exit();
    }

    /**
     * Print welcome message and set the previous save file to load.
     */
    private void start() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        System.out.println(line);
        this.tasksList = storage.readFile();
    }

    /**
     * Read in user commands and execute it until bye command is received.
     */
    private void runUntilByeIsCalled() {
        Commands command;
        String userCommand;
        String[] firstWord;
        do {
            userCommand = userInput.getUserCommand();
            firstWord = userCommand.split(" ", 2);
            command = Parser.parseCommand(userCommand);
            command.setData(tasksList);
            command.execute();
            storage.writeToFile();
        } while (!firstWord[0].trim().equals("bye"));
    }

    /**
     * Exit the program.
     */
    private void exit() {
        System.exit(0);
    }

}


