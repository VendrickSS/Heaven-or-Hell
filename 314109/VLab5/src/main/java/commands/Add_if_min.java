package commands;

import beasts.Dragon;
import storage.Storage;

import java.util.NoSuchElementException;

public class Add_if_min extends AbstractCommand {
    public Add_if_min(Dragon dragon) {
        setDragon(dragon);
    }

    @Override
    public String execute() {
        try {
            Storage.getStorage().stream().filter(dragon -> dragon.compareTo(getDragon()) > 0).findAny().get();  //Пытаемся поймать исключение "NoSuchElementException"
            Storage.getStorage().push(getDragon());     //Если исключение не было поймано, то это значит, что в коллекции есть элемент, который меньше того, что в аргументе указывался
            return "Dragon added.";
        } catch (NoSuchElementException e) {
            return "Dragon must yongest!";
        }
    }
}
