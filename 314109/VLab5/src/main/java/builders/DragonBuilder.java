package builders;

import beasts.Dragon;
import enums.Color;
import enums.DragonCharacter;
import enums.DragonType;
import storage.Storage;
import tools.TextReader;

import java.util.Date;

public class DragonBuilder {

    /**
     * Строитель, что реализует создвние и
     * ввод пользователем значений для полей
     * дракона
     * @return Дракон с заполенными полями,
     * учитывая требованя ТЗ
     */
    public static Dragon buildDragon() {
        Dragon dragon = new Dragon();
        assignId(dragon);
        initializationAllExceptId(dragon);
        return dragon;
    }

    public static void initializationAllExceptId(Dragon dragon) {
        assignName(dragon);
        assignCoordinates(dragon);
        assignAge(dragon);
        assignColor(dragon);
        assignType(dragon);
        assignCharacter(dragon);
        assignCave(dragon);
        assignCreationDate(dragon);
    }

    /**
     * Нужно для того, чтобы автоматически задать
     * id дракону, кторое будет удовлетворять ТЗ
     * (Значение поля должно быть больше 0,
     * Значение этого поля должно быть уникальным,
     * Значение этого поля должно генерироваться автоматически)
     * @param dragon с измененным уникальным id
     */
    private static void assignId(Dragon dragon) {
        long estimatedId = 1;
        boolean success = false;

        while (!success) {
            if (Storage.findDragonById(estimatedId) != null) {
                estimatedId++;
            } else {
                success = true;
            }
        }
        dragon.setId(estimatedId);
    }

    /**
     * Нужно для того, чтобы задать имя дракону,
     * которое будет удовлетворять условию из ТЗ
     * (Поле не может быть null,
     * Строка не может быть пустой)
     * @param dragon в котором будет изменено поле "name"
     */
    private static void assignName(Dragon dragon) {
        String name;
        do {
            System.out.println("Please enter a name:");
            name = TextReader.readText();
            if (name != null) {     //Эта проверка нужна, так как если name будет null, то будет исключение
                name = name.trim();
            }
            if (name == null) {     //Проверка на то, null ли введенное имя
                System.out.println("A name cannot be empty!");
            } else if (name.isEmpty()) {    //Проверка на то, не пустую ли строку ввел ползователь
                System.out.println("The name is empty!");
            } else {
                dragon.setName(name);
            }
        } while ((name == null) || (name.isEmpty()));
        System.out.println();
    }

    /**
     * Нужно для того, чтобы задать координаты дракону,
     * которые будут удовлетворять условию из ТЗ
     * (Поле не может быть null)
     * @param dragon в котором будет изменено поле "coordinates"
     */
    private static void assignCoordinates(Dragon dragon) {
        dragon.setCoordinates(CoordinatesBuilder.buildCoordinates());   //Ссылается на строитель
    }

    /**
     * Нужно для того,чтобы задать, в какое время был создан
     * дракон. Оно так же должно отвечать требованиям ТЗ
     * (Поле не может быть null,
     * Значение этого поля должно генерироваться автоматически)
     * @param dragon в котором будет изменено поле "creationDate"
     */
    private static void assignCreationDate(Dragon dragon) {
        dragon.setCreationDate(new Date());     //При вызове конструкктора время задается автоматически. (стандартная библиотека java)
    }

    /**
     * Нужно для того,чтобы задать возраст, который будет
     * удовлетворять ТЗ
     * (Значение поля должно быть больше 0)
     * @param dragon в котором будет изменено поле "age"
     */
    private static void assignAge(Dragon dragon) {
        Long age = 0L;  //L просто показывает, что это число типа long
        boolean success = false;

        while (!success) {
            System.out.print("Please enter age: ");
            age = TextReader.readLongFromConsole();
            if (age != null) {
                if (age > 0) {
                    success = true;
                } else {
                    System.out.println("Age must be more 0!");
                }
            } else {
                System.out.println("Age cannot be null!");
            }
        }
        dragon.setAge(age);
    }

    /**
     * Нужно для того,чтобы задать цвет
     * @param dragon в котором будет изменено поле "age"
     */
    private static void assignColor(Dragon dragon) {
        String colorName;
        boolean success = false;
        while (!success) {
            System.out.print("Please enter color name (green; orange; white): ");
            colorName = TextReader.readText();

            if (colorName != null)
            switch (colorName) {
                case "green":
                    success = true;
                    dragon.setColor(Color.GREEN);
                    break;
                case "orange":
                    success = true;
                    dragon.setColor(Color.ORANGE);
                    break;
                case "white":
                    success = true;
                    dragon.setColor(Color.WHITE);
                    break;
            }

        }
    }

    /**
     * Нужно для того,чтобы задать тип
     * @param dragon в котором будет изменено поле "type"
     */
    private static void assignType(Dragon dragon) {
        String type;
        boolean success = false;
        while (!success) {
            System.out.print("Please enter type (underground; air; fire): ");
            type = TextReader.readText();

            if (type != null)
                switch (type) {
                    case "underground":
                        success = true;
                        dragon.setType(DragonType.UNDERGROUND);
                        break;
                    case "air":
                        success = true;
                        dragon.setType(DragonType.AIR);
                        break;
                    case "fire":
                        success = true;
                        dragon.setType(DragonType.FIRE);
                        break;
                }

        }
    }

    /**
     * Нужно для того,чтобы задать характер
     * @param dragon в котором будет изменено поле "character"
     */
    private static void assignCharacter(Dragon dragon) {
        String character;
        boolean success = false;
        while (!success) {
            System.out.print("Please enter character (cunning; wise; evil; chaotic evil): ");
            character = TextReader.readText();

            if (character != null)
                switch (character) {
                    case "cunning":
                        success = true;
                        dragon.setCharacter(DragonCharacter.CUNNING);
                        break;
                    case "wise":
                        success = true;
                        dragon.setCharacter(DragonCharacter.WISE);
                        break;
                    case "evil":
                        success = true;
                        dragon.setCharacter(DragonCharacter.EVIL);
                        break;
                    case "chaotic evil":
                        success = true;
                        dragon.setCharacter(DragonCharacter.CHAOTIC_EVIL);
                        break;

                }
        }
    }

    /**
     * Нужно для того,чтобы задать пещеру
     * @param dragon в котором будет изменено поле "cave"
     */
    private static void assignCave(Dragon dragon) {
        dragon.setCave(DragonCaveBuilder.buildDragonCave());    //Ссылается на другой строитель
    }
}
