package commands;

import beasts.Dragon;
import storage.Storage;

import java.util.Arrays;
import java.util.Stack;

public class Filter_starts_with_name extends AbstractCommand{
    public Filter_starts_with_name(String partOfName) {
        setArgument(partOfName);
    }
    private String result = "";

    @Override
    public String execute() {
        if (getArgument() == null) {
            return "Error!";
        }

        if (Storage.getStorage().isEmpty()) {
            return "No dragons!";
        }
        Storage.getStorage().stream()
                .filter(dragon -> dragon.getName().length() >= getArgument().length())
                .filter(dragon -> dragon.getName().startsWith(getArgument()))
                .forEach(this::addToResult);

        if (result.isEmpty()) {
            return "No dragons!";
        }
        return result;
    }

    private void addToResult(Dragon dragon) {
        result += dragon.toString();
    }
}
