package commands;

import storage.Storage;

import java.util.Collections;

public class Shuffle extends AbstractCommand {
    @Override
    public String execute() {
        Collections.shuffle(Storage.getStorage());  //класс и метод из стандартной библиотеки java
        return "Elements has been shuffled!";
    }
}
