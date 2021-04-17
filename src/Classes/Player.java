package Classes;

import java.util.ArrayList;

public class Player {
    private String name;
    private int hp;
    private int money;
    private int numCardOnHand;
    private ArrayList<Card> hands;

    //Constructor
    public Player() {
        this.hp = 100;
        this.name = "name";
        this.numCardOnHand = 0;
    }
    public Player(String name){
        this.name = name;
        this.hp = 100;
        this.numCardOnHand = 0;
    }

    //Getters
    public String getName() {
        return this.name;
    }
    public int getHp() {
        return this.hp;
    }
    public int getMoney() {
        return this.money;
    }
    public int getNumCardOnHand() {
        return this.numCardOnHand;
    }
    public ArrayList<Card> getHands() {
        return this.hands;
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
    public void addMoney(int amount) {
        this.money += amount;
    }
    public void addCardOnHand(int x) {
        this.numCardOnHand += x;
    }
    public void addCardOnHand() {
        this.numCardOnHand += 1;
    }
    public void addCard(Card card) {
        this.hands.add(card);
    }
    public void removeCard(Card card) {
        this.hands.remove(card);
    }

}
