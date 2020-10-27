package commands;

import beasts.Dragon;
import storage.Storage;

public class Show extends AbstractCommand{
    @Override
    public String execute() {
        if (!Storage.getStorage().isEmpty())
            for (Dragon dragon : Storage.getStorage()) {
                int dragonNumber = 1;
                answer += dragon.toString();
                dragonNumber++;

                if (dragonNumber != Storage.getStorage().size() + 1) {
                    answer += "-------------------------";
                }
            }

        return answer;
    }
}
