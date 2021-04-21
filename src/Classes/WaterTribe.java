package Classes;

public class WaterTribe extends Card {
    private int heal;

    //Constructor
    public WaterTribe(String name, int level, int damage, int hp, int cost, int speed) {
        super(name,"water", level, damage, hp, cost, speed);
    }

    //Getters
    public int getHeal() {
        return this.heal;
    }

    //Setters
    public void setHeal(int heal) {
        this.heal = heal;
    }
}
