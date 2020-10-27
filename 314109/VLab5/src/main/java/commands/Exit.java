package commands;

public class Exit extends AbstractCommand {
    @Override
    public String execute() {
        System.exit(0);
        return "Closing application...";
    }
}
