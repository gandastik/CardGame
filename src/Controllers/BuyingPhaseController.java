package Controllers;

import Classes.Card;
import Classes.CardsCollection;
import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class BuyingPhaseController implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;

    Player playerOne;
    Player playerTwo;

    @FXML
    private Label playerOneName;
    @FXML
    private Label playerTwoName;
    @FXML
    private Label playerOneHp;
    @FXML
    private Label playerTwoHp;

    @FXML
    //Buying tab
    private ImageView img1, img2, img3, img4, img5, img6, img7, img8;
    //Player's Inventory (I guess?)
    @FXML
    private ImageView imgP1, imgP2, imgP3, imgP4, imgP5, imgP6, imgP7;
    private ImageView[] buyingImageViews;
    private ImageView[] playerHandsImageViews;
    private CardsCollection buyingCollection;
    private ArrayList<Card> buyingHand;


    //Initializations
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initBuyingCollection();
        this.initBuyingImageViews();
        this.initPlayerHandsImageViews();
        //showing 8 cards for the player to buy
        for(int i=0;i<8;i++){
            buyingImageViews[i].setImage(buyingHand.get(i).getImage());
        }
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
    }

    //Receiving data
    public void receiveData(Player one, Player two) {
        playerOne = one;
        playerTwo = two;

        /*
        //Display the name on the screen
        this.playerOneName.setText("Player One: " + playerOne.getName());
        this.playerTwoName.setText("Player Two: " + playerTwo.getName());

        //Display the hp on the screen
        this.playerOneHp.setText("Player One HP : " + playerOne.getHp());
        this.playerTwoHp.setText("Player Two HP: " + playerTwo.getHp());
         */
    }

    //Rendering
    public void renderBuyingHand() {
        //rendering the cards on the buying hand
        for(int i=0;i<8;i++){
            buyingImageViews[i].setImage(buyingHand.get(i).getImage());
        }
    }
    public void renderPlayerHand() {
        //rendering the cards on player's hand
        for (int i = 0; i < this.playerOne.getHands().size(); i++) {
            playerHandsImageViews[i].setImage(playerOne.getHands().get(i).getImage());
        }
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
    public Card getCardFromSellingBtn(String btnId, Player player) {
        if(player.getName().equals(this.playerOne.getName())){
            for(int i=0;i<7;i++){
                if(btnId.equals("sell" + (i+1))){
                    return this.playerOne.getHands().get(i);
                }
            }
        } else if (player.getName().equals(this.playerTwo.getName())) {
            for(int i=0;i<7;i++){
                if(btnId.equals(this.playerTwo.getName())){
                    return this.playerTwo.getHands().get(i);
                }
            }
        }
        else {
            throw new IllegalArgumentException("Invalid btnId or player");
        }
        return null;
    }

    //Button Controllers
    public void onNext(ActionEvent e) throws Exception{
        //send players object to BattlePhaseController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/BattlePhase.fxml"));
        root = loader.load();

        BattlePhaseController controller = loader.getController();
        controller.receiveData(this.playerOne, this.playerTwo);

        //Switch to BattlePhaseScene
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onBuy(ActionEvent e) {
        //can only buy when player hold less than 7 cards on the hands
        if(playerOne.getHands().size() < 7){
            //Buying Mechanic .. buy a card and remove it from the collection.
            String id =  ((Button)e.getSource()).getId();
            Card card = getCardFromBuyingHand(id);
            buyingCollection.removeCard(card);
            this.buyingHand = buyingCollection.getCardsCollection();
            this.renderBuyingHand();

            //add a card to player's hands
            this.playerOne.addCard(card);
            this.renderPlayerHand();
        }
    }
    public void onReroll(ActionEvent e) {
        //Reroll actions
        buyingCollection.shuffle();
        this.buyingHand = buyingCollection.getCardsCollection();
        this.renderBuyingHand();
    }
    public void onSell(ActionEvent e) {
        //Selling actions
    }
    public void onSelect(ActionEvent e) {
       //Selected actions
    }
}
