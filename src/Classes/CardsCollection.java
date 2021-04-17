package Classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class CardsCollection {
    private ArrayList<Card> cardsCollection;

    public CardsCollection() {
        this.cardsCollection = new ArrayList<Card>();
        this.addCardsToCollection();
        this.shuffle();
    }
    
    public ArrayList<Card> getCardsCollection() {
        return this.cardsCollection;
    }

    public void addCardsToCollection(){
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 100));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 2, 25, 120));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 100));
        cardsCollection.add(new FireTribe("Inari_Fire", 3, 30, 150));
        cardsCollection.add(new FireTribe("Burning_Algae", 3, 30, 150));
        cardsCollection.add(new FireTribe("Fire_Princess", 3, 30, 150));
        cardsCollection.add(new FireTribe("Inari_Fire", 3, 30, 150));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 100));
        cardsCollection.add(new FireTribe("Laval_Forest_Spirit", 2, 25, 120));
        cardsCollection.add(new FireTribe("Volcanic_Rat", 1, 20, 100));
        cardsCollection.add(new FireTribe("Inari_Fire", 3, 30, 150));
        cardsCollection.add(new FireTribe("Burning_Algae", 3, 30, 150));
        cardsCollection.add(new FireTribe("Fire_Princess", 3, 30, 150));
        cardsCollection.add(new FireTribe("Inari_Fire", 3, 30, 150));
    }

    public void shuffle(){
        Collections.shuffle(this.cardsCollection);
    }
}
