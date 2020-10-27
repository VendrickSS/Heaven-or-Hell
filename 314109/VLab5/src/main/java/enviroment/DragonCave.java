package enviroment;

/**
 * Станданртный класс из задания
 */
public class DragonCave {
    private long numberOfTreasures; //Значение поля должно быть больше 0

    public long getNumberOfTreasures() {
        return numberOfTreasures;
    }

    public void setNumberOfTreasures(long numberOfTreasures) {
        this.numberOfTreasures = numberOfTreasures;
    }

    @Override
    public String toString(){
        return "Number of treasure: "+ numberOfTreasures +"\n";
    }
}
