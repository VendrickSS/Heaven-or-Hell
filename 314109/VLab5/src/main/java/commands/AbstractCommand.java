package commands;

import beasts.Dragon;
import interfaces.CommandInterface;
import storage.Storage;

/**
 * Суперкласс, который позволит стандартизировать
 * все команды
 */
public abstract class AbstractCommand implements CommandInterface {
    protected String answer = "";
    protected int dragonNumber; //надо исключительно для метода addToAnswer

    private Dragon dragon;
    private String argument;


    abstract public String execute();

    protected void addToAnswer(Dragon dragon) {   //нужен, чтобы более комфортно было работать со stream API
        answer += dragon.toString();
        dragonNumber++;

        if (!(Storage.getStorage().size() == dragonNumber)) {
            answer += "-------------------------";
        }
    }

    public Dragon getDragon() {
        return dragon;
    }

    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    public String getArgument() {
        return argument;
    }

    public void setArgument(String argument) {
        this.argument = argument;
    }
}
