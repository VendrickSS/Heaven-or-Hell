package builders;

import enviroment.DragonCave;
import tools.TextReader;

public class DragonCaveBuilder {
    /**
     * Строитель, что реализует создвние и
     * ввод пользователем значений для полей
     * пещеры
     * @return Пещеру с заполенными полями,
     * учитывая требованя ТЗ
     */
    public static DragonCave buildDragonCave() {
        DragonCave dragonCave = new DragonCave();
        assignNumberOfTreasures(dragonCave);
        return dragonCave;
    }

    /**
     * Нужно для того, чтобы задать значения полю numberOfTreasures
     * так, чтобы оно удовлетворяло условию ТЗ
     * (Значение поля должно быть больше 0)
     * @param dragonCave в котором будет изменено поле "numberOfTreasures"
     */
    private static void assignNumberOfTreasures(DragonCave dragonCave) {
        boolean success = false;
        Long numberOfTreasures = 0L;
        while (!success) {
            System.out.print("Please enter number of treasures: ");
            numberOfTreasures = TextReader.readLongFromConsole();
            if (numberOfTreasures != null) {
                if (numberOfTreasures > 0) {
                    success = true;
                }
                else {
                    System.out.println("Number of treasures must be more 0!");
                }
            } else {
                System.out.println("Number of treasures cannot be null!");
            }
        }
        dragonCave.setNumberOfTreasures(numberOfTreasures);
    }
}
