package commands;

import beasts.Dragon;
import storage.Storage;

import java.util.NoSuchElementException;

public class Remove_by_id  extends AbstractCommand{
    public Remove_by_id(Long id) {
        setArgument(id.toString());
    }

    @Override
    public String execute() {
        try {
            Storage.getStorage().stream().filter(dragon -> dragon.getId() == Long.parseLong(getArgument())).findAny();
            Storage.getStorage().remove(Storage.findDragonById(Long.parseLong(getArgument())));
            return "Element removed.";
        } catch (NoSuchElementException e) {
            return "Nonexistent element!";
        }
    }
}
