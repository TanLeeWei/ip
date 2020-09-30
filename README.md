# User Guide

Duke Project is an application that allows the user to record, manage and keep track the tasks they have. If you can type fast, Duke can help to make their tasks management more effectively

## Features
```
- Items in square brackets are optional e.g: deadline borrow book /by 2020-12-12 [23:59]
- Commands can be entered in both upper and lower cases by the user.
- Parameters have to be in order e.g. event project meeting /at Sunday 12:00
  ```

### Adding Todo Tasks: `todo`
Adds a todo task to the task list. <br>
Format: `todo description...`

### Adding Deadline Tasks: `deadline`
Adds a deadline task to the task list. <br>
Format: `deadline description /date in YYYY-MM-DD format [time in 24hr format ]` <br>
Example Input: `deadline homework /by 2020-10-20 23:59` <br>
Example Output:  homework (by: Oct 20 2020 11:59 PM) <br>

### Adding Event Tasks: `event`
Adds an event task to the task list. <br>
Format: `event description /date and time` <br>
Example Input: `event project meeting /at Sunday 2-4` <br>
Example Output: project meeting (at: Sunday 2-4) <br>

### Deleting a task or all the task at once: `event`
Delete a specific task from the task list or all the task at once. <br>
Format: `delete INDEX` or `delete all` <br>
Tip: Check the list for the index before using the delete function. <br>
Example Input: `delete 1`  <br>

### Marking a task as done: `done`
Marks a task as done. <br>
Format: `done INDEX` <br>
Tip: Check the list first for the index before using the done function. <br>
Example Input: `done 2` <br>

### Find a task: `find`
Find tasks by searching for a keyword and return all the tasks related to the keyword. <br>
Format: `find INDEX` <br>
Tip: Check the list first for the index before using the find function. <br>
Example Input: `find 2` <br>

### Exiting the program: `bye`
Exits the program. <br>
Format: `bye` <br>

### Saving the data
Duke data will be automatically saved after each command input given by the user. There is no need to save manually. <br>


