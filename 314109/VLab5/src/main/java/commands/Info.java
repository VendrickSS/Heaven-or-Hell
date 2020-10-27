package commands;

import beasts.Dragon;
import storage.Storage;

public class Info extends AbstractCommand {

    @Override
    public String execute() {
        return "Collection type: Stack.\n" +
                "Initialization date: "+ Storage.getInitializationDate().toString() +"\n" +
                "Amount of elements: "+ Storage.getStorage().size() +"\n";
    }
}
