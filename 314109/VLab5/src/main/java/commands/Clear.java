package commands;

import storage.Storage;

public class Clear extends AbstractCommand {
    @Override
    public String execute() {
        Storage.getStorage().clear();
        return "Collection has been cleaned.";
    }
}
