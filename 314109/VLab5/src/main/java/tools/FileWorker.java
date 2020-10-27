package tools;

import java.io.*;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class FileWorker {
    private static CommandListener commandListener = new CommandListener();
    private static LinkedHashSet<String> executeScripts = new LinkedHashSet<>();
    private static int n = 0;

    /**
     * Этот метод не имеет практического смысла, так как
     * его аналог есть в стандартной библиотеке java.
     * Просто мне так удубнее
     * @param file Файл, который надо проверить на возможноть
     *             осуществелние чтения из файла
     * @return возможно ли причитать данные из фавйла
     */
    public static boolean checkReading(File file) {
        return file.canRead();
    }

    /**
     * Этот метод не имеет практического смысла, так как
     * его аналог есть в стандартной библиотеке java.
     * Просто мне так удубнее
     * @param file Файл, который надо проверить на возможноть
     *             осуществелние записи данных в файл
     * @return возможно ли записать данные в фавйл
     */
    public static boolean checkWriting(File file) {
        return file.canWrite();
    }

    /**
     * Метод проверяет, возможно ли достать данные
     * из файла
     * @param file файл, который будет проходить проверку
     * @return возможно ли произвести считывание данных
     */
    public static boolean isReachable(File file) {
        boolean success = true;

        if (!file.exists()) {
            System.out.println(("Could not find the file \"" + file.getName() + "\""));
            success = false;
        } else if (!file.canRead()) {
            System.out.println(("Could not open the file \"" + file.getName() + "\" for read!"));
            success = false;
        } else if (!file.canWrite()) {
            System.out.println(("Could not open the file \"" + file.getName() + "\" for write!"));
            success = false;
        }
        return success;
    }

    /**
     * В данном методе будет проиходить проверка
     * корректности введенного файла
     * @param thePathToTheFile название/путь к файлу
     * @return файл, который был найден
     */
    public static File enterFile(String thePathToTheFile) {
        File file;

        if (thePathToTheFile != null) {
            file = new File(thePathToTheFile);
            if (isReachable(file)) {
                return file;
            }
            System.out.println(("The path to file is null!"));
            System.out.println("Try entering the file name again:");
        } else {
            System.out.println("Enter a file name:");
        }

        while (true) {
            String var = TextReader.readText();
            if (var != null) {
                file = new File(var);
                if (isReachable(file))
                    return file;
                System.out.println("Try entering the file name again:");
            } else {
                System.out.println("The file can not have a name!");
            }
        }
    }

    public static String readCsvFile(File file) throws IOException {    //todo затестить
        String result = "";
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        int i;

        while((i = bufferedInputStream.read())!= -1){
            result += (char)i;
        }
        return result;
    }


    public static void writeDateIntoCsvFile(String date, File file) throws IOException {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
        outputStreamWriter.write(date);
    }


    /**
     * Метод нереально сложный, так что обратись ком не, чтобы
     * я тебе все рассказал. Только на написание этого метода
     * у меня ушел целый день. Но работает он нормально, наверное.
     * @param thePathToTheFile  Путь к файлу, откуда будут считываться
     *                          команды
     * @throws FileNotFoundException Будет вылетать, если кто-то
     * неверное введет путь к файлу или будут другие траблы. Я хз короч
     */
    public static void readCommandsFromFile(String thePathToTheFile) throws FileNotFoundException {
        n++;
        Scanner previousScanner = TextReader.getScanner();  //Мы создаем новый сканер (тут ты можешь чказать,
        File file;                                          //надо было реализовать чтение данных чере java.io.BufferedInputStream,
                                                            //но тут исключение. Это не нарушение ТЗ, так что изи)
        try {
            if (thePathToTheFile != null) {     //Проверка на наотсутствие ссылки
                file = new File(thePathToTheFile);  //Если ссылка есть, то пытаемся создать экземпляр класса с фалом
                if (checkReading(file)) {   //Проверка на то, возможно ли прочитать содержимое файла
                    String command = "";    //Инициализируем переменную command
                    TextReader.setStream(new FileInputStream(file));    //Тут мы создаем новый сканер, и он начинает чиать поток файла
                    TextReader.setScannerIsIn(false);   //Тут мы даем программе понять, что чтение происходит не из командной строки, а из вне

                    Scanner scanner = TextReader.getScanner();  //Тут мы создаем локальный сканер, который будет существовать только в рамках этого метода
                    //может быть исключение (этот комент я оставлял сам себе еще давно, но никаких исключений я не нашел)
                    while (scanner.hasNext()) {     //Цикл будет продолжаться, пока он не дойдет до послейдней строки в файле и не прочитает ее
                        boolean success = true;     //todo докоментить
                        command = TextReader.readText();    //Так как мы используем сканер для считывания строк в файле, мы можем юзать методы, написанные для консоли

                        if (command == null) {  //В случаи, если строка, где предположительно будет находиться команда, будет пустой
                            commandListener.executeCommand(null);   //Ну тут нечего пояснять
                        }
                        else if (commandListener.readCommands(command).equals("execute_script")) {  //Хитрая схема, если в файле будет команда execute_script
                            if (n==1) {
                                executeScripts.add("execute_script "+ thePathToTheFile);
                            }
                            if (!(executeScripts.isEmpty())) {  //Тут мы будем проверять, встречалась ли нам эта команда ранее (Не должно быть рекурсии!!!)
                                for (String executeScript : executeScripts) {   //Перебераем все пути к файлам, что былли введены
                                    if (executeScript.equals(command)) {    //Если находим хоть одно совпадение с аргументом этого execute_script
                                        success = false;    //Даем знать программе, что данный скрипт выполняется, поэтому вызвав его еще раз, мы получим рекурсию
                                    }
                                }
                            }
                            executeScripts.add(command);    //Если этот файл еще не выполняется, то добовляем его в коллекцию
                            if (success) {  //если этот файл сейчас не выполняется
                                executeScripts.add(command);    //Вроде в нем нет смысла, но я боюсь его трогать
                                Scanner scanner1 = TextReader.getScanner(); //Тут мы создаем еще один локальный сканер (так как у нас будет создан новый сканер, который будет считывать наой файл, надо надо сохранять прогресс этого, чтобы, когда новый закончит свою работу, мы могли продолжыть с того момента, где мы остановились)
                                CommandListener.executeScript(commandListener.readArgument(command));   //Тут мы возвращаемся в начало этого метода
                                TextReader.setScanner(scanner1);    //Тут мы возвращаемся назад, к тому моменту, на котором мы остановились
                                executeScripts.remove(command);     //Как только мы считаем все строки в файле, мы удаляем путь к этому файлу из коллекции, тем самым давая программе знать, что файл больше не выполняется
                            } else {    //Это мы выводим, если обнаружили совпадение а цикле forEach выше
                                System.out.println("***");
                                System.out.println("Command \"" + command + "\" was ignored because it could cause recursion!");
                                System.out.println("***");
                            }
                        } else {    //Если в файле встречается любая команда, кроме execute_script, то она выполняется как рядовая команда
                            commandListener.executeCommand(command);    //Дилегоруем выполнение этой команды на commandListener
                        }
                    }
                }
            }
        } catch (StackOverflowError e) {
            System.out.println("Recursion detected!");
        } finally {
            TextReader.setScanner(previousScanner);
        }
        n--;
    }
}
