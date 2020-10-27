package enviroment;

/**
 * Станданртный класс из задания
 */
public class Coordinates {
    private float x; //Максимальное значение поля: 503
    private Long y; //Поле не может быть null

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public Long getY() {
        return y;
    }

    public void setY(Long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        String answer = "";
        answer += "Coordinate X: "+ x +"\n";
        answer += "Coordinate Y: "+ y +"\n";
        return answer;
    }
}
