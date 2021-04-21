package Classes;

public class RockTribe extends Card{
    private int shield;

    //Constructor
    public RockTribe(String name, int level, int damage, int hp, int cost, int speed, int shield) {
        super(name,"rock", level, damage, hp, cost, speed);
        setShield(shield);
    }

    //Getters
    public int getShield() {
        return this.shield;
    }

    //Setters
    public void setShield(int shield) {
        this.shield = shield;
    }
}
