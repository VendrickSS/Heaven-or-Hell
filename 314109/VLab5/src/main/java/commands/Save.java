package commands;

import storage.Storage;
import tools.FileWorker;

import java.io.IOException;

public class Save extends AbstractCommand {
    @Override
    public String execute() {
        if (!FileWorker.checkWriting(Storage.getCollectionFile())) {
            return "Unable to write data to file!";
        }

        try {
            FileWorker.writeDateIntoCsvFile(null, Storage.getCollectionFile()); //todo
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (!FileWorker.checkReading(Storage.getCollectionFile())) {
            return "Unable to check if data has survived!";
        }
        return "Data saved!";
    }
}
