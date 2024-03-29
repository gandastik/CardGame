package Controllers;

import Classes.Card;
import Classes.CardsCollection;
import Classes.Player;
import Classes.SoundEffects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class PlayerOneBuyingPhaseController implements Initializable {

    Player playerOne;
    Player playerTwo;

    @FXML
    private Label playerName ,playerMoney, playerHp;

    @FXML
    //Buying tab
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8;
    private CardsCollection buyingCollection;
    private CardsCollection allCardCollection;
    private ArrayList<Card> buyingHand;
    private ImageView[] buyingImageViews;
    @FXML
    private Label labelCost1, labelCost2, labelCost3, labelCost4, labelCost5, labelCost6, labelCost7, labelCost8, rerollCostLabel;
    private Label[] buyingLabelsCost;
    private int rerollCost;
    //Player's Inventory (I guess?)
    @FXML
    private ImageView imgP1, imgP2, imgP3, imgP4, imgP5, imgP6, imgP7;
    private ImageView[] playerHandsImageViews;

    //Initializations
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initVariables();
        this.initBuyingCollection();
        this.initBuyingImageViews();
        this.initBuyingLabelsCost();
        this.initPlayerHandsImageViews();
        //rendering blank card on the empty slot.
        for(int j = 0;j<Player.getMaxNumCardOnHand();j++){
            playerHandsImageViews[j].setImage(new Image("./Assets/blankCard.png"));
        }
        //showing 8 cards for the player to buy
        this.renderBuyingHand();
        this.renderCostBuying();
        this.renderRerollCostLabel();
    }
    public void initBuyingImageViews() {
        this.buyingImageViews = new ImageView[8];
        this.buyingImageViews[0] = this.img1;
        this.buyingImageViews[1] = this.img2;
        this.buyingImageViews[2] = this.img3;
        this.buyingImageViews[3] = this.img4;
        this.buyingImageViews[4] = this.img5;
        this.buyingImageViews[5] = this.img6;
        this.buyingImageViews[6] = this.img7;
        this.buyingImageViews[7] = this.img8;
    }
    public void initPlayerHandsImageViews() {
        this.playerHandsImageViews = new ImageView[7];
        this.playerHandsImageViews[0] = this.imgP1;
        this.playerHandsImageViews[1] = this.imgP2;
        this.playerHandsImageViews[2] = this.imgP3;
        this.playerHandsImageViews[3] = this.imgP4;
        this.playerHandsImageViews[4] = this.imgP5;
        this.playerHandsImageViews[5] = this.imgP6;
        this.playerHandsImageViews[6] = this.imgP7;
    }
    public void initBuyingCollection(){
        this.buyingCollection = new CardsCollection();
        this.buyingHand = buyingCollection.getCardsCollection();
        this.allCardCollection = new CardsCollection("ALL");
    }
    public void initPlayerMoney(){
        int money = this.playerOne.getMoney();
        this.playerMoney.setText("Money : " + money);
        this.playerName.setText("Name : " + this.playerOne.getName());
        this.playerHp.setText("HP : " + this.playerOne.getHp());
    }
    public void initBuyingLabelsCost() {
        this.buyingLabelsCost = new Label[8];
        this.buyingLabelsCost[0] = this.labelCost1;
        this.buyingLabelsCost[1] = this.labelCost2;
        this.buyingLabelsCost[2] = this.labelCost3;
        this.buyingLabelsCost[3] = this.labelCost4;
        this.buyingLabelsCost[4] = this.labelCost5;
        this.buyingLabelsCost[5] = this.labelCost6;
        this.buyingLabelsCost[6] = this.labelCost7;
        this.buyingLabelsCost[7] = this.labelCost8;
    }
    public void initVariables(){
        this.rerollCost = 0;
    }

    //Receiving data
    public void receiveData(Player one, Player two) {
        playerOne = one;
        playerTwo = two;
        this.initPlayerMoney();
        this.renderPlayerHand();
    }

    //Methods
    public Card getCardFromBuyingHand(String btnId) {
        //returning the card on buying hand.
        for(int i=0;i<8;i++){
            if(btnId.equals("btn" + (i+1))){
                return buyingHand.get(i);
            }
        }
        return null;
    }
    public int getIndexOfCardFromBuyingHand(String btnId) {
        //returning the index of the card on the buying hand.
        for(int i=0;i<8;i++){
            if(btnId.equals("btn" + (i+1))){
                return i;
            }
        }
        return 0;
    }
    public Card getCardFromImgBuyingHand(String imgId) {
        for(int i=0;i<8;i++){
            if(imgId.equals("img"+ (i+1))){
                return buyingHand.get(i);
            }
        }
        return null;
    }
    public Card getCardFromImgPlayerHand(String imgId) {
        for(int i=0;i<Player.getMaxNumCardOnHand();i++) {
            if(imgId.equals("imgP" + (i+1))){
                return this.playerOne.getHands().get(i);
            }
        }
        return null;
    }
    public Card getCardFromSellingBtn(String btnId, Player player) {
        if(player.getName().equals(this.playerOne.getName())) {
            for (int i = 0; i < this.playerOne.getHands().size(); i++) {
                if (btnId.equals("sell" + (i + 1))) {
                    return this.playerOne.getHands().get(i);
                }
            }
        }
        else {
            throw new IllegalArgumentException("Invalid btnId or player");
        }
        return null;
    }
    public Card getCardFromSelectImg(String imgId) {
        //return card on player' hand when clicking on it's img.
        for(int i=0;i<this.playerOne.getHands().size();i++){
            if(imgId.equals("imgP" + (i+1))){
                return this.playerOne.getHands().get(i);
            }
        }
        return null;
    }
    public void levelUPCard(){
        for(int i=0;i<this.playerOne.getHands().size();i++) {
            for (int j = i + 1; j < this.playerOne.getHands().size(); j++) {
                if (this.playerOne.getHands().get(i).equals(this.playerOne.getHands().get(j)) && this.playerOne.getHands().get(i).getLevel() != 3) {
                    Card cardToLevelUp = this.playerOne.getHands().get(i);
                    Card newCard = this.findCardinCollection(cardToLevelUp);
                    if(this.playerOne.getHands().get(j).getLevel() == 2){
                        if(this.playerOne.getHands().contains(newCard)){
                            newCard.addId();
                        }
                    }
                    this.playerOne.removeCard(cardToLevelUp);
                    this.playerOne.removeCard(cardToLevelUp);
                    this.playerOne.addCard(newCard);
                }
            }
        }
    }
    public void setLabelCostBlank(int index) {
        this.buyingLabelsCost[index].setText("");
    }
    public Card findCardinCollection(Card card){
        for(int i=0;i<allCardCollection.getCardsCollection().size();i++){
            if(allCardCollection.getCardsCollection().get(i).getName().equals(card.getName()) && allCardCollection.getCardsCollection().get(i).getLevel() == card.getLevel()+1){
                return allCardCollection.getCardsCollection().get(i);
            }
        }
        return null;
    }

    //Button Controllers
    public void onNext(ActionEvent e) throws Exception{
        //send players object to BattlePhaseController
        if(this.playerOne.getSelectedCard().size() > 0){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/PlayerTwoBuyingPhase.fxml"));
            Parent root = loader.load();

            //Change to playerTwoBuyingPhaseController later when done dev. and change the entire of playerTwoController to
            // be duplicate of playerOne
            PlayerTwoBuyingPhaseController controller = loader.getController();
            controller.receiveData(this.playerOne, this.playerTwo);

            //Switch to BattlePhaseScene
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
        SoundEffects.playMenuClick();
    }
    public void onBuy(ActionEvent e) {
        //can only buy when player hold less than 7 cards on the hands
        if(playerOne.getHands().size() < Player.getMaxNumCardOnHand()){
            //Buying Mechanic .. buy a card and remove it from the collection.
            String id =  ((Button)e.getSource()).getId();
            Card card = getCardFromBuyingHand(id);
            int index = getIndexOfCardFromBuyingHand(id);
            //Cannot buy a blank card and need to have money more than or equal to the cost of the card that you are going to buy.
            if(!card.getName().equals("blank") && this.playerOne.getMoney() >= card.getCost()) {
                buyingCollection.removeCardAt(index);
                this.buyingHand = buyingCollection.getCardsCollection();
                this.setLabelCostBlank(index);
                this.renderBuyingHand();

                //Transaction -> take money away from player and then render the player's money on screen
                this.playerOne.takeMoney(card.getCost());
                this.renderPlayerMoney();

                //In case of Buying level 3 card -> Check if there's the same level 3 card on the hand then add an extra
                // Id datafield to make the two of them different!
                if(card.getLevel() == 3){
                    if(this.playerOne.getHands().contains(card)){
                        card.addId();
                    }
                }

                //add a card to player's hands
                this.playerOne.addCard(card);
                //leveling up the duplicate card on the player's hand.
                this.levelUPCard();
                //incase of have the same level 2 card on the hand -> become level 3.
                this.levelUPCard();

                this.renderPlayerHand();
            }
        }
        SoundEffects.playMenuClick();
    }
    public void onReroll(ActionEvent e) {
        //Reroll actions -> checking if player have enough money to reroll
        if(this.playerOne.getMoney() >= this.rerollCost){
            this.playerOne.takeMoney(this.rerollCost);
            buyingCollection.shuffle();
            this.buyingHand = buyingCollection.getCardsCollection();
            this.rerollCost += 3;
            this.renderRerollCostLabel();
            this.renderCostBuying();
            this.renderBuyingHand();
            this.renderPlayerMoney();
        }
        SoundEffects.playMenuClick();
    }
    public void onSell(ActionEvent e) {
        //Selling actions on playerOne turn
        String id = ((Button)e.getSource()).getId();
        Card card = getCardFromSellingBtn(id, this.playerOne);
        if(card != null){
            this.playerOne.removeCard(card);

            //Transaction -> add money to player and render the player's money on screen.
            this.playerOne.addMoney(card.getCost() / 2);
            this.renderPlayerMoney();
            SoundEffects.playSelling();
        }
        else{
            SoundEffects.playMenuClick();
        }
        this.renderPlayerHand();
    }
    public void onSelectImg(MouseEvent e) {
        //click on img to select card to go to the arena.
        ImageView imgClicked = (ImageView)e.getSource();
        String imgId = ((ImageView) e.getSource()).getId();
        Card card = getCardFromSelectImg(imgId);
        if(this.playerOne.getSelectedCard().size() < 4 && card != null && !this.playerOne.getSelectedCard().contains(card) ){
            System.out.println("added card : " + card.getName());
            card.setSelectedBy(this.playerOne);
            this.playerOne.getSelectedCard().add(card);
            imgClicked.setScaleX(1.25);
            imgClicked.setScaleY(1.25);
        }
        else if(this.playerOne.getSelectedCard().contains(card)){
            System.out.println("removed card : " + card.getName());
            card.setUnSelected();
            this.playerOne.getSelectedCard().remove(card);
            imgClicked.setScaleX(1);
            imgClicked.setScaleY(1);
        }
        System.out.println(playerOne.getSelectedCard().size());
    }

    //Rendering
    public void renderBuyingHand() {
        //rendering the cards on the buying hand
        for(int i=0;i<8;i++){
            this.buyingImageViews[i].setImage(buyingHand.get(i).getImage());
            //Add tooltips in ImageView of each non blank card to show the details of the card.
            Card card = getCardFromImgBuyingHand(this.buyingImageViews[i].getId());
            if(!card.getName().equals("blank")){
                String name = card.getName();
                name = name.replaceAll("_", " ");
                int level = card.getLevel();
                int hp = card.getHp();
                int maxHp = card.getMaxHp();
                String tribe = card.getTribe();
                Tooltip.install(this.buyingImageViews[i], new Tooltip("name: " + name + "\nlevel: " + level +
                        "\nhp: " + hp + "/" + maxHp + "\ntribe: " + tribe));
            }
            else {
                Tooltip.uninstall(this.buyingImageViews[i], new Tooltip());
            }
        }
    }
    public void renderPlayerHand() {
        int index = 0;
        //rendering the cards on player's hand
        for (int i = 0; i < this.playerOne.getHands().size(); i++) {
            playerHandsImageViews[i].setImage(playerOne.getHands().get(i).getImage());
            playerHandsImageViews[i].setScaleX(1);
            playerHandsImageViews[i].setScaleY(1);
            //Add tooltips in ImageView of each non blank card to show the details of the card.
            Card card = getCardFromImgPlayerHand(this.playerHandsImageViews[i].getId());
            if(!card.getName().equals("blank")){
                String name = card.getName();
                name = name.replaceAll("_", " ");
                int level = card.getLevel();
                int hp = card.getHp();
                int maxHp = card.getMaxHp();
                String tribe = card.getTribe();
                Tooltip.install(this.playerHandsImageViews[i], new Tooltip("name: " + name + "\nlevel: " + level +
                        "\nhp: " + hp + "/" + maxHp + "\ntribe: " + tribe));
            }
            else {
                Tooltip.uninstall(this.playerHandsImageViews[i], new Tooltip());
            }
            //Check if the card on the player's hand are selected to the arena.
            if(this.playerOne.getSelectedCard().contains(playerOne.getHands().get(i))){
                playerHandsImageViews[i].setScaleY(1.25);
                playerHandsImageViews[i].setScaleX(1.25);
            }
            index = i;
        }
        //rendering blank card on the empty slot.
        for(int j = index+1;j<Player.getMaxNumCardOnHand();j++){
            playerHandsImageViews[j].setImage(new Image("./Assets/blankCard.png"));
            playerHandsImageViews[j].setScaleX(1);
            playerHandsImageViews[j].setScaleY(1);
        }
        //if no card on players hand let's the first slot be blank card.
        if(this.playerOne.getHands().size() == 0){
            playerHandsImageViews[0].setImage(new Image("./Assets/blankCard.png"));
            playerHandsImageViews[0].setScaleX(1);
            playerHandsImageViews[0].setScaleY(1);
        }
    }
    public void renderPlayerMoney() {
        this.playerMoney.setText("Money : " + this.playerOne.getMoney());
    }
    public void renderCostBuying() {
        for(int i=0;i<8;i++){
            this.buyingLabelsCost[i].setText("cost : " + buyingHand.get(i).getCost());
        }
    }
    public void renderRerollCostLabel() {
        this.rerollCostLabel.setText("reroll cost : " + this.rerollCost);
    }
}
