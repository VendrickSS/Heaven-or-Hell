package tools;

import beasts.Dragon;
import builders.DragonBuilder;
import commands.*;

import java.io.FileNotFoundException;

public class CommandListener {
    /**
     * Метод, который считывает консольные команды
     * в бесконечном цыкле,а так же воплощает их в жизнь
     */
    public void readCommands() {
        AbstractCommand command = null;
        while(command == null) {
            command = executeCommand(TextReader.readText());
        }
    }


    public AbstractCommand executeCommand(String command) {
        Dragon dragon;
        if (command == null) {
            System.out.println("No command!");
            return null;
        } else {
            switch (readCommands(command)) {
                case "help":
                    System.out.println(new Help().execute());
                    break;
                case "info":
                    System.out.println(new Info().execute());
                    break;
                case "show":
                    System.out.println(new Show().execute());
                    break;
                case "add":
                    dragon = DragonBuilder.buildDragon();
                    System.out.println(new Add(dragon).execute());
                    break;
                case "update":
                    try {
                        System.out.println(new Update(Long.parseLong(readArgument(command))).execute());
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect argument entered.");
                    }
                    break;
                case "remove_by_id":
                    try {
                        System.out.println(new Remove_by_id(Long.parseLong(readArgument(command))).execute());
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect argument entered.");
                    }
                    break;
                case "clear":
                    System.out.println(new Clear().execute());
                    break;
                case "execute_script":
                    executeScript(readArgument(command));
                    break;
                case "exit":
                    System.out.println(new Exit().execute());
                    break;
                case "add_if_max":
                    dragon = DragonBuilder.buildDragon();
                    System.out.println(new Add_if_max(dragon).execute());
                    break;
                case "add_if_min":
                    dragon = DragonBuilder.buildDragon();
                    System.out.println(new Add_if_min(dragon).execute());
                    break;
                case "shuffle":
                    System.out.println(new Shuffle().execute());
                    break;
                case "remove_any_by_age":
                    try {
                        System.out.println(new Remove_any_by_age(Long.parseLong(readArgument(command))).execute());
                    } catch (NumberFormatException e) {
                        System.out.println("Incorrect argument entered.");
                    }
                    break;
                case "filter_starts_with_name":
                    System.out.println(new Filter_starts_with_name(readArgument(command)).execute());
                    break;
                case "print_ascending":
                    System.out.println(new Print_ascending().execute());
                    break;
                default:
                    System.out.println("You entered wrong command!");
            }
        }
        return null;
    }

    public String readCommands(String command){
        String answer = "";
        try {
            char[] commandToCharArray = command.toCharArray();
            for (int elementNumberInTheArray = 0;
                 elementNumberInTheArray < commandToCharArray.length && commandToCharArray[elementNumberInTheArray] != ' ';
                 elementNumberInTheArray++) {
                answer += commandToCharArray[elementNumberInTheArray];
            }
            return answer;
        } catch (NullPointerException e) {
            return null;
        }

    }
    public String readArgument (String command){
        String answer = "";
        int elementNumberInTheArray = 0;
        char[] commandToCharArray = command.toCharArray();
        while (commandToCharArray[elementNumberInTheArray] != ' ') {
            if (elementNumberInTheArray + 2 > commandToCharArray.length) {
                return null;
            }
            elementNumberInTheArray++;
        }
        elementNumberInTheArray++;
        for (; elementNumberInTheArray != commandToCharArray.length; elementNumberInTheArray += 1) {
            answer += commandToCharArray[elementNumberInTheArray];
        }
        return answer;
    }

    public static int numberOfExecuteScript = 0;
    /**
     * Считать и исполнить скрипт из указанного файла.
     * В скрипте содержатся команды в таком же виде,
     * в котором их вводит пользователь в интерактивном режиме
     */
    public static void executeScript(String thePathToTheFile) {
        numberOfExecuteScript++;
        try {
            FileWorker.readCommandsFromFile(thePathToTheFile);
        } catch (FileNotFoundException e) {
            System.out.println("Path to the file was entered wrong!");
        } finally {
            numberOfExecuteScript--;
        }

        if (numberOfExecuteScript == 0) {
            TextReader.setStream(System.in);
            TextReader.setScannerIsIn(true);
        }
    }
}
