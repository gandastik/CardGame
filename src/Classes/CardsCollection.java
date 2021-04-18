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
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 150, 1));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 1, 40, 160, 2));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Inari_Fire", 1, 40, 170, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Burning_Algae", 1, 50, 150, 3));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));
        cardsCollection.add(new FireTribe("Fire_Princess", 1, 20, 170,2));

        //Rock
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",1,20,200,2));
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",1,20,200,2));
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",1,20,200,2));
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",1,20,200,2));
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",1,20,200,2));
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",1,20,200,2));
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",1,20,200,2));
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",1,20,200,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",1,20,190,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",1,30,180,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",1,30,180,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",1,30,180,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",1,30,180,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",1,30,180,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",1,30,180,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",1,30,180,2));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",1,30,180,2));
        cardsCollection.add(new RockTribe("Spherous_Lady",1,10,180,1));
        cardsCollection.add(new RockTribe("Spherous_Lady",1,10,180,1));
        cardsCollection.add(new RockTribe("Spherous_Lady",1,10,180,1));
        cardsCollection.add(new RockTribe("Spherous_Lady",1,10,180,1));
        cardsCollection.add(new RockTribe("Spherous_Lady",1,10,180,1));
        cardsCollection.add(new RockTribe("Spherous_Lady",1,10,180,1));
        cardsCollection.add(new RockTribe("Spherous_Lady",1,10,180,1));
        cardsCollection.add(new RockTribe("Spherous_Lady",1,10,180,1));
        cardsCollection.add(new RockTribe("Winged_Sphinx",1,20,170,1));
        cardsCollection.add(new RockTribe("Winged_Sphinx",1,20,170,1));
        cardsCollection.add(new RockTribe("Winged_Sphinx",1,20,170,1));
        cardsCollection.add(new RockTribe("Winged_Sphinx",1,20,170,1));
        cardsCollection.add(new RockTribe("Winged_Sphinx",1,20,170,1));
        cardsCollection.add(new RockTribe("Winged_Sphinx",1,20,170,1));
        cardsCollection.add(new RockTribe("Winged_Sphinx",1,20,170,1));
        cardsCollection.add(new RockTribe("Winged_Sphinx",1,20,170,1));

        //Water
        cardsCollection.add(new WaterTribe("Divine_Dragon",1,20,150,3));
        cardsCollection.add(new WaterTribe("Divine_Dragon",1,20,150,3));
        cardsCollection.add(new WaterTribe("Divine_Dragon",1,20,150,3));
        cardsCollection.add(new WaterTribe("Divine_Dragon",1,20,150,3));
        cardsCollection.add(new WaterTribe("Divine_Dragon",1,20,150,3));
        cardsCollection.add(new WaterTribe("Divine_Dragon",1,20,150,3));
        cardsCollection.add(new WaterTribe("Divine_Dragon",1,20,150,3));
        cardsCollection.add(new WaterTribe("Ice_Barrier",1,40,110,3));
        cardsCollection.add(new WaterTribe("Ice_Barrier",1,40,110,3));
        cardsCollection.add(new WaterTribe("Ice_Barrier",1,40,110,3));
        cardsCollection.add(new WaterTribe("Ice_Barrier",1,40,110,3));
        cardsCollection.add(new WaterTribe("Ice_Barrier",1,40,110,3));
        cardsCollection.add(new WaterTribe("Ice_Barrier",1,40,110,3));
        cardsCollection.add(new WaterTribe("Ice_Barrier",1,40,110,3));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",1,20,160,4));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",1,20,160,4));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",1,20,160,4));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",1,20,160,4));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",1,20,160,4));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",1,20,160,4));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",1,20,160,4));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",1,30,100,4));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",1,30,100,4));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",1,30,100,4));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",1,30,100,4));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",1,30,100,4));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",1,30,100,4));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",1,30,100,4));
        cardsCollection.add(new WaterTribe("The_Mermail",1,20,130,3));
        cardsCollection.add(new WaterTribe("The_Mermail",1,20,130,3));
        cardsCollection.add(new WaterTribe("The_Mermail",1,20,130,3));
        cardsCollection.add(new WaterTribe("The_Mermail",1,20,130,3));
        cardsCollection.add(new WaterTribe("The_Mermail",1,20,130,3));
        cardsCollection.add(new WaterTribe("The_Mermail",1,20,130,3));
        cardsCollection.add(new WaterTribe("The_Mermail",1,20,130,3));

        //--------------------------------------LEVEL 2----------------------------------------------------
        //Fire
        cardsCollection.add(new FireTribe("Volcanic_Rat", 2, 30, 200, 3));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 2, 30, 200, 3));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 2, 60, 210, 4));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 2, 60, 210, 4));
        cardsCollection.add(new FireTribe("Inari_Fire", 2, 60, 220, 5));
        cardsCollection.add(new FireTribe("Inari_Fire", 2, 60, 220, 5));
        cardsCollection.add(new FireTribe("Burning_Algae", 2, 60, 200, 5));
        cardsCollection.add(new FireTribe("Burning_Algae", 2, 60, 200, 5));
        cardsCollection.add(new FireTribe("Fire_Princess", 2, 30, 220,4));
        cardsCollection.add(new FireTribe("Fire_Princess", 2, 30, 220,4));
        cardsCollection.add(new FireTribe("Fire_Lavaval_Ignis", 2, 60, 260,10));
        cardsCollection.add(new FireTribe("Laval_Judgment_Lord", 2, 60, 260,10));

        //Rock
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",2,30,270,5));
        cardsCollection.add(new RockTribe("Felix_King_Of_Battlefield",2,30,270,5));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",2,30,230,4));
        cardsCollection.add(new RockTribe("Gem_Knight_Lapis",2,30,230,4));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",2,40,230,5));
        cardsCollection.add(new RockTribe("Gem_Knight_Sardontyx",2,40,230,5));
        cardsCollection.add(new RockTribe("Spherous_Lady",2,20,210,3));
        cardsCollection.add(new RockTribe("Spherous_Lady",2,20,210,3));
        cardsCollection.add(new RockTribe("Winged_Sphinx",2,30,220,4));
        cardsCollection.add(new RockTribe("Winged_Sphinx",2,30,220,4));
        cardsCollection.add(new RockTribe("U.A._Blockbacker",2,50,300,12));
        cardsCollection.add(new RockTribe("Vision_Hero_Gravito",2,30,310,11));

        //Water
        cardsCollection.add(new WaterTribe("Divine_Dragon",2,30,170,7));
        cardsCollection.add(new WaterTribe("Divine_Dragon",2,30,170,7));
        cardsCollection.add(new WaterTribe("Ice_Barrier",2,50,140,6));
        cardsCollection.add(new WaterTribe("Ice_Barrier",2,50,140,6));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",2,30,180,8));
        cardsCollection.add(new WaterTribe("Lady_Of_The_Lake",2,30,180,8));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",2,40,150,8));
        cardsCollection.add(new WaterTribe("Prince_Of_Ice",2,40,150,8));
        cardsCollection.add(new WaterTribe("The_Mermail",2,30,160,7));
        cardsCollection.add(new WaterTribe("The_Mermail",2,30,160,7));
        cardsCollection.add(new WaterTribe("Ice_Master",2,40,190,13));
        cardsCollection.add(new WaterTribe("Megician_Of_Prophecy",2,40,180,13));
    }

    //Methods
    public void shuffle(){
        //remove a blank card out of a collection and then refill the collection.
        cardsCollection.removeIf(card -> card.getName().equals("blank"));
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
