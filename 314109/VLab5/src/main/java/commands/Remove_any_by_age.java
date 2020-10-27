package commands;

import storage.Storage;

import java.util.NoSuchElementException;

public class Remove_any_by_age extends AbstractCommand {
    public Remove_any_by_age(Long dragonAge) {
        setArgument(dragonAge.toString());
    }

    @Override
    public String execute() {
        try {
            Storage.getStorage().remove(Storage.getStorage().stream().filter(dragon -> dragon.getAge() == Long.parseLong(getArgument())).findAny());

            return "Dragon removed.";
        } catch (NoSuchElementException e) {
            return "There are no dragons of this age!";
        }
    }
}
