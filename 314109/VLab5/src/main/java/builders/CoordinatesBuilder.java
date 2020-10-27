package builders;

import enviroment.Coordinates;
import tools.TextReader;

public class CoordinatesBuilder {
    /**
     * Строитель, что реализует создвние и
     * ввод пользователем значений для полей
     * координат
     * @return Координаты с заполенными полями,
     * учитывая требованя ТЗ
     */
    public static Coordinates buildCoordinates() {
        Coordinates coordinates = new Coordinates();
        assignX(coordinates);
        assignY(coordinates);
        return coordinates;
    }

    /**
     * Нужно для того, чтобы корректно задать значения
     * полю X (длжно быть не более 503 и должно быть не null)
     * @param coordinates координаты, параметры которых надо
     *                    подвергунть изменениям
     */
    private static void assignX(Coordinates coordinates) {
        boolean success = false;
        Float coordinateX = null;
        while (!success) {
            System.out.print("Please enter coordinate X: ");
            coordinateX = TextReader.readFloatFromConsole();
            if (coordinateX != null) {
                if (coordinateX <= 503) {
                    success = true;
                }
                else {
                    System.out.println("Coordinate X cannot be more 503!");
                }
            } else {
                System.out.println("Coordinate X cannot be null!");
            }
        }
        coordinates.setX(coordinateX);
    }

    /**
     * Нужно для того, чтобы корректно задать значения
     * полю X (длжно быть не более 503 и должно быть не null)
     * @param coordinates координаты, параметры которых надо
     *                    подвергунть изменениям
     */
    private static void assignY(Coordinates coordinates) {
        boolean success = false;
        Long coordinateY = null;
        while (!success) {
            System.out.print("Please enter coordinate Y: ");
            coordinateY = TextReader.readLongFromConsole();
            if (coordinateY != null) {
                success = true;
            } else {
                System.out.println("Coordinate X cannot be null!");
            }
        }
        coordinates.setY(coordinateY);
    }
}
