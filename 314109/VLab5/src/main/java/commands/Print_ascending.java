package commands;

import storage.Storage;

public class Print_ascending extends AbstractCommand {

    @Override
    public String execute() {
        Storage.getStorage().stream().sorted().forEach(this::addToAnswer);
        return answer;
    }
}
