package Classes;


import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Card {
    protected int damage;
    protected int hp;
    protected int level;
    protected String name;
    protected String tribe;
    protected Image image;
    protected int cost;

    //Constructors
    public Card(String name, String tribe, int level, int damage, int hp, int cost) {
        setName(name);
        setTribe(tribe);
        setLevel(level);
        setDamage(damage);
        setHp(hp);
        setCost(cost);
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

    //Methods
    //this methods will return the valid type of card
    public static List<String> getValidTribes() {
        return Arrays.asList("fire", "water", "rock");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return damage == card.damage && hp == card.hp && level == card.level && Objects.equals(name, card.name) && Objects.equals(tribe, card.tribe);
    }
}