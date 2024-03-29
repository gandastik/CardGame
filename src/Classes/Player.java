package Classes;

import java.util.ArrayList;

public class Player {
    private String name;
    private int hp;
    private int money;
    private ArrayList<Card> hands;
    private ArrayList<Card> selectedCard;
    public static final int MAXNUMCARDONHAND = 7;

    //Constructor
    public Player() {
        this.hp = 20;
        this.name = "name";
        this.money = 20;
        this.hands = new ArrayList<Card>();
        this.selectedCard = new ArrayList<Card>();
    }
    public Player(String name){
        this.name = name;
        this.hp = 20;
        this.money = 15;
        this.hands = new ArrayList<Card>();
        this.selectedCard = new ArrayList<Card>();
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
    public ArrayList<Card> getHands() {
        return this.hands;
    }
    public ArrayList<Card> getSelectedCard() {
        return this.selectedCard;
    }
    public static int getMaxNumCardOnHand(){
        return MAXNUMCARDONHAND;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setSelectedCard(ArrayList<Card> arrayCards) {
        this.selectedCard = arrayCards;
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
    public void takeMoney(int amount) {
        this.money -= amount;
    }
    public void addCard(Card card) {
        this.hands.add(card);
    }
    public void removeCard(Card card) {
        this.hands.remove(card);
        this.getSelectedCard().removeIf(card::equals);
    }
}
