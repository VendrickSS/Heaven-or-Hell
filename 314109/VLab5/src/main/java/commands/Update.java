package commands;

import builders.DragonBuilder;
import storage.Storage;

public class Update extends AbstractCommand {
    public Update(Long id) {
        setArgument(id.toString());
    }

    @Override
    public String execute() {
        DragonBuilder.initializationAllExceptId(Storage.findDragonById(Long.parseLong(getArgument())));
        return "Got it!";
    }
}
