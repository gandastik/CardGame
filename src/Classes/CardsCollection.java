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

}
