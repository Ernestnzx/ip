package amara.command;

import java.util.ArrayList;

import amara.exceptions.AmaraException;
import amara.storage.Storage;
import amara.task.Task;
import amara.ui.Ui;

public abstract class Command {
    public boolean isBye() {
        return false;
    }

    public abstract void execute(ArrayList<Task> tasks, Ui ui, Storage storage) throws AmaraException;
}
