package Classes;


import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    protected int damage;
    protected int hp;
    protected int level;
    protected String name;
    protected String tribe;
    protected Image image;

    //Constructors
    public Card(String name, String tribe, int level, int damage, int hp) {
        setName(name);
        setTribe(tribe);
        setLevel(level);
        setDamage(damage);
        setHp(hp);
        //assign the tribe and the name of the card to the images
        String fileName = this.tribe + "_" + this.name + "_" + this.level + ".png";
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

    //Methods
    //this methods will return the valid type of card
    public static List<String> getValidTribes() {
        return Arrays.asList("fire", "water", "rock");
    }
}