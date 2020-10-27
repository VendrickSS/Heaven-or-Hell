package storage;
import beasts.Dragon;

import java.io.File;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Класс для хранения объектов
 */
public class Storage {
    static Stack<Dragon> storage = new Stack<>();  //именно тут храняться все эелменты класса Dragon
    private static LocalDate initializationDate = LocalDate.now();
    private static File collectionFile;

    /**
     * Метод, ищущий дракона по его id
     * @return дракона с заданным id или null
     */
    public static Dragon findDragonById(long dragonId) {
        try {
            return storage.stream()
                    .filter(dragon1 -> dragon1.getId() == dragonId)
                    .findAny()
                    .get();   //здесь с помощью stream API и лямбда выражерия легко находиться дракон с нужнам id;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    public static boolean initCollectionFromFile(File file) {
        return false;
    }

    public static Stack<Dragon> getStorage() {
        return storage;
    }

    public static LocalDate getInitializationDate() {
        return initializationDate;
    }

    public static File getCollectionFile() {
        return collectionFile;
    }

    public static void setCollectionFile(File collectionFile) {
        Storage.collectionFile = collectionFile;
    }
}
