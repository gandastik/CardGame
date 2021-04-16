package Classes;

public class Player {
    private String name;
    private int hp;

    //Constructor
    public Player() {
        this.hp = 100;
        this.name = "name";
    }
    public Player(String name){
        this.name = name;
        this.hp = 100;
    }

    //Getters
    public String getName() {
        return this.name;
    }
    public int getHp() {
        return this.hp;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    //Methods
    public void takeDmg(int dmg){
        this.hp -= dmg;
    }
    public void takeDmg() {
        this.hp -= 1;
    }

}
