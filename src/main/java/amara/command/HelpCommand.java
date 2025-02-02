package amara.command;

import java.util.ArrayList;

import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

/**
 * * A {@link Command} implementation that returns all command formats
 */
public class HelpCommand extends Command {
    @Override
    public String execute(ArrayList<Task> tasks, Ui ui, Storage storage) {
        return "Here are the list of available commands!\n"
                + "  <bye>: See you next time!\n\n"
                + "  <list>: I'll print out all of the task in the list!\n\n"
                + "  <mark index>: I'll mark the task as done on that index!\n\n"
                + "  <unmark index>: I'll unmark the task as done on that index!\n\n"
                + "  <todo description>: I'll add a new To Do task to your list!\n\n"
                + "  <deadline description /by date-time format>: I'll add a new Deadline task to your list!\n\n"
                + "  <event description /from date-time format /to date-time format>:"
                + " I'll add a new event task to your list!\n\n"
                + "  <delete Index>: I'll remove a task from the given index!\n\n"
                + "  <find query>: I'll return a list of task of the word you want!\n\n"
                + "Note that date-time format is as follows! <YYYY-MM-DD HHMM>";
    }
}
