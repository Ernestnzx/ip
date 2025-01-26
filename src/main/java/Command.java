public abstract class Command {
    public boolean isBye() {
        return false;
    }

    public abstract String execute();
}
