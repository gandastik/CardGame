package Classes;


import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card {
    protected int damage;
    protected int hp;
    protected int maxHp;
    protected int level;
    protected String name;
    protected String tribe;
    protected Image image;
    protected int cost;
    protected Player selectedBy;
    protected int speed;
    protected Boolean isDead = false;

    //Constructors
    public Card(String name, String tribe, int level, int damage, int hp, int cost, int speed) {
        setName(name);
        setTribe(tribe);
        setLevel(level);
        setDamage(damage);
        setHp(hp);
        setMaxHp(hp);
        setCost(cost);
        setSpeed(speed);
        //assign the tribe and the name of the card to the images
        String fileName = this.tribe + "/" + this.name + "_" + this.level + ".png";
        this.image = new Image("./Assets/" +fileName);
    }
    public Card(){
        setName("blank");
        this.image = new Image("./Assets/blankCard.png");
    }

    //Getters
    public int getDamage() {
        return this.damage;
    }
    public int getHp() {
        return this.hp;
    }
    public int getLevel() {
        return this.level;
    }
    public int getCost() {
        return this.cost;
    }
    public String getName() {
        return this.name;
    }
    public String getTribe() {
        return this.tribe;
    }
    public Image getImage() {
        return this.image;
    }
    public int getSpeed() {
        return this.speed;
    }
    public Player getSelectedBy() {
        return this.selectedBy;
    }
    public int getMaxHp() {
        return this.maxHp;
    }
    public Boolean getIsDead() {
        return this.isDead;
    }

    //Setters
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setHp(int hp){
        this.hp = hp;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setTribe(String tribe) {
        List<String> validTribes = getValidTribes();
        tribe = tribe.toLowerCase();

        if(validTribes.contains(tribe)){
            this.tribe = tribe;
        }
        else
            throw new IllegalArgumentException("Valid types are " + validTribes);
    }
    public void setCost(int cost){
        this.cost = cost;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setSelectedBy(Player player){
        this.selectedBy = player;
    }
    public void setUnSelected(){
        this.selectedBy = null;
    }
    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    //Methods
    //this methods will return the valid type of card
    public static List<String> getValidTribes() {
        return Arrays.asList("fire", "water", "rock");
    }
    public void takeDmg(int dmg){
        this.hp -= dmg;
        if(this.hp <= 0){
            this.isDead = true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return damage == card.damage && hp == card.hp && level == card.level && Objects.equals(name, card.name) && Objects.equals(tribe, card.tribe);
    }
}