package Classes;

import java.util.Arrays;
import java.util.List;

public class FireTribe extends Card{
    //Constructor
    public FireTribe(String name, int level, int damage, int hp, int cost,int speed) {
        super(name,"fire", level, damage, hp, cost, speed);
    }

    //Methods

    //Passive skills - checking if the dealing damage will critical or not by the chance given by the level of the card
    public boolean isCritical(){
        return (int) (Math.random() * 100) + 1 <= this.level * 10;
    }
}