package Classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CardsCollection {
    private ArrayList<Card> cardsCollection;
    private Card blankCard;

    //Construtors
    public CardsCollection() {
        this.cardsCollection = new ArrayList<Card>();
        this.addCardsToCollection();
        this.shuffle();

        //create a blank card for every collection of card
        this.blankCard = new Card();
    }
    public CardsCollection(String type){
        this.cardsCollection = new ArrayList<Card>();

        //create a blank card
        this.blankCard = new Card();
    }
    
    public ArrayList<Card> getCardsCollection() {
        return this.cardsCollection;
    }

    public void addCardsToCollection(){
        //--------------------------------------LEVEL 1----------------------------------------------------
        //Fire

        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 4));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 4));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 4));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 4));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,4));

        //Rock
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",1,20,200,4));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,4));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",1,30,180,4));
        cardsCollection.add(new RockTribe("Spherous_Lady",1,10,180,4));
        cardsCollection.add(new RockTribe("Winged_Sphinx",1,20,170,4));

        //Water
        cardsCollection.add(new WaterTribe("Divine_Dragon",1,20,150,4));
        cardsCollection.add(new WaterTribe("Ice_Barrier",1,40,110,4));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",1,20,160,4));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",1,30,100,4));
        cardsCollection.add(new WaterTribe("The_Mermail",1,20,130,4));

        //--------------------------------------LEVEL 2----------------------------------------------------
        //Fire
        cardsCollection.add(new FireTribe("Volcanic_Rat", 2, 30, 200, 10));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 2, 60, 210, 11));
        cardsCollection.add(new FireTribe("Inari_Fire", 2, 60, 220, 12));
        cardsCollection.add(new FireTribe("Burning_Algae", 2, 60, 200, 10));
        cardsCollection.add(new FireTribe("Fire_Princess", 2, 30, 220,10));
        cardsCollection.add(new FireTribe("Fire_Lavaval_Ignis", 2, 60, 260,14));
        cardsCollection.add(new FireTribe("Laval_Judgment_Lord", 2, 60, 260,14));

        //Rock
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",2,30,270,11));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",2,30,230,11));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",2,40,230,12));
        cardsCollection.add(new RockTribe("Spherous_Lady",2,20,210,11));
        cardsCollection.add(new RockTribe("Winged_Sphinx",2,30,220,10));
        cardsCollection.add(new RockTribe("U.A._Blockbacker",2,50,300,15));
        cardsCollection.add(new RockTribe("Vision_Hero_Gravito",2,30,310,14));

        //Water
        cardsCollection.add(new WaterTribe("Divine_Dragon",2,30,170,12));
        cardsCollection.add(new WaterTribe("Ice_Barrier",2,50,140,11));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",2,30,180,12));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",2,40,150,13));
        cardsCollection.add(new WaterTribe("The_Mermail",2,30,160,11));
        cardsCollection.add(new WaterTribe("Ice_Master",2,40,190,15));
        cardsCollection.add(new WaterTribe("Megician_Of_Prophecy",2,40,180,15));

        //--------------------------------------LEVEL 3----------------------------------------------------
        //Fire
        cardsCollection.add(new FireTribe("Volcanic_Rat", 3, 40, 220, 18));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 3, 60, 240, 20));
        cardsCollection.add(new FireTribe("Inari_Fire", 3, 70, 230, 22));
        cardsCollection.add(new FireTribe("Burning_Algae", 3, 80, 230, 20));
        cardsCollection.add(new FireTribe("Fire_Princess", 3, 40, 240,19));
        cardsCollection.add(new FireTribe("Fire_Lavaval_Ignis", 3, 90, 300,25));
        cardsCollection.add(new FireTribe("Laval_Judgment_Lord", 3, 80, 310,25));

        //Rock
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",3,30,330,21));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",3,30,290,19));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",3,50,280,20));
        cardsCollection.add(new RockTribe("Spherous_Lady",3,20,260,18));
        cardsCollection.add(new RockTribe("Winged_Sphinx",3,40,260,20));
        cardsCollection.add(new RockTribe("U.A._Blockbacker",3,50,380,26));
        cardsCollection.add(new RockTribe("Vision_Hero_Gravito",3,30,400,26));

        //Water
        cardsCollection.add(new WaterTribe("Divine_Dragon",3,30,220,23));
        cardsCollection.add(new WaterTribe("Ice_Barrier",3,50,190,22));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",3,30,250,23));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",3,50,200,23));
        cardsCollection.add(new WaterTribe("The_Mermail",3,30,220,21));
        cardsCollection.add(new WaterTribe("Ice_Master",3,60,260,28));
        cardsCollection.add(new WaterTribe("Megician_Of_Prophecy",3,50,260,28));

    }

    //Methods
    public void shuffle(){
        //remove a blank card out of a collection and then refill the collection.
        cardsCollection = new ArrayList<Card>();
        this.addCardsToCollection();
        Collections.shuffle(this.cardsCollection);
    }
    //remove the card that are selected and replace them with a blank card
    public void removeCard(Card card) {
        int index = cardsCollection.indexOf(card);
        cardsCollection.remove(card);
        cardsCollection.add(index, blankCard);
    }
    //remove the card at a specific index (in case of there's the same card when using above methods)
    public void removeCardAt(int index) {
        cardsCollection.remove(index);
        cardsCollection.add(index, blankCard);
    }
}
