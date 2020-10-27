package beasts;

import enums.Color;
import enums.DragonCharacter;
import enums.DragonType;
import enviroment.Coordinates;
import enviroment.DragonCave;

import java.util.Date;

/**
 * Станданртный класс из задания
 */
public class Dragon implements Comparable<Dragon>{
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long age; //Значение поля должно быть больше 0
    private Color color; //Поле не может быть null
    private DragonType type; //Поле не может быть null
    private DragonCharacter character; //Поле может быть null
    private DragonCave cave; //Поле не может быть null

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public DragonType getType() {
        return type;
    }

    public void setType(DragonType type) {
        this.type = type;
    }

    public DragonCharacter getCharacter() {
        return character;
    }

    public void setCharacter(DragonCharacter character) {
        this.character = character;
    }

    public DragonCave getCave() {
        return cave;
    }

    public void setCave(DragonCave cave) {
        this.cave = cave;
    }

    @Override
    public String toString(){
        String answer = "";
        answer += "ID: "+ id +"\n";
        answer += "Name: "+ name +"\n";
        answer += "Coordinates {\n";
        answer += coordinates.toString() +"}\n";  //смотри класс Coordinates
        answer += "Creation date: "+ creationDate.toString() +"\n"; //todo проверить на корректность
        answer += "Age: "+ age +"\n";
        answer += "Color: "+ color.toString() +"\n";
        answer += "Type: "+ type.toString() +"\n";
        answer += "Character: "+ character.toString() +"\n";    //смотри класс DragonCharacter
        answer += "Cave {\n";
        answer += cave.toString() +"}\n";   //смотри класс DragonCave
        return answer;
    }

    @Override
    public int compareTo(Dragon anotherDragon) {        //Сравнивает драконов по их возрасту
        return (int) (this.age - anotherDragon.age);
    }
}
