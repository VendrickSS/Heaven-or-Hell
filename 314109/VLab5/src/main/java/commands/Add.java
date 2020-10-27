package commands;

import beasts.Dragon;
import storage.Storage;

public class Add extends AbstractCommand {
    public Add(Dragon dragon) {
        setDragon(dragon);
    }

    @Override
    public String execute() {
        Storage.getStorage().push(getDragon());
        return "Dragon added."; //todo протестить
    }
}
