package Controllers;

import Classes.Card;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ResourceBundle;

public class BattlePhaseController implements Initializable {
    private Node node;
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private Label playerOneName, playerTwoName, playerOneHp, playerTwoHp;

    @FXML
    private ImageView imgP1_1, imgP1_2, imgP1_3, imgP1_4, imgP2_1, imgP2_2, imgP2_3, imgP2_4;
    private ImageView[] playerOneImgViews;
    private ImageView[] playerTwoImgViews;
    @FXML
    private Label hpP1_1, hpP1_2, hpP1_3, hpP1_4, hpP2_1, hpP2_2, hpP2_3, hpP2_4;
    private ArrayList<Label> hpCards;

    @FXML
    private HBox hboxP2;

    @FXML
    private Button attackBtnP1_1, attackBtnP1_2, attackBtnP1_3, attackBtnP1_4, skillBtnP1_1, skillBtnP1_2, skillBtnP1_3, skillBtnP1_4;
    @FXML
    private Button attackBtnP2_1, attackBtnP2_2, attackBtnP2_3, attackBtnP2_4, skillBtnP2_1, skillBtnP2_2, skillBtnP2_3, skillBtnP2_4;
    private ArrayList<Button> skillButtons;
    private ArrayList<Button> attackButtons;

    private Player playerOne;
    private Player playerTwo;

    private ArrayList<Card> cardsOnArena;
    private int indexOfCard;
    private Card cardThisTurn;

    private Boolean isAttack;

    //Initializations
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initVariables();
        this.initPlayerOneCardImgViews();
        this.initPlayerTwoCardImgViews();
        this.initHpCards();

        this.initSkillButtons();
        this.initAttackButtons();
    }
    public void initPlayerOneCardImgViews(){
        this.playerOneImgViews = new ImageView[4];
        this.playerOneImgViews[0] = imgP1_1;
        this.playerOneImgViews[1] = imgP1_2;
        this.playerOneImgViews[2] = imgP1_3;
        this.playerOneImgViews[3] = imgP1_4;
    }
    public void initPlayerTwoCardImgViews() {
        this.playerTwoImgViews = new ImageView[4];
        this.playerTwoImgViews[0] = imgP2_1;
        this.playerTwoImgViews[1] = imgP2_2;
        this.playerTwoImgViews[2] = imgP2_3;
        this.playerTwoImgViews[3] = imgP2_4;
    }
    public void initCardsOnArena() {
        this.cardsOnArena = new ArrayList<Card>();
        this.cardsOnArena.addAll(playerOne.getSelectedCard());
        this.cardsOnArena.addAll(playerTwo.getSelectedCard());
        this.sortCardsOnArenaBySpeed();
        if(this.cardsOnArena.size() != 0) {
            this.indexOfCard = 0;
        }
    }
    public void initHpCards() {
        this.hpCards = new ArrayList<Label>();
        this.hpCards.addAll(Arrays.asList(hpP1_1, hpP1_2, hpP1_3, hpP1_4, hpP2_1, hpP2_2, hpP2_3, hpP2_4));
    }
    public void initSkillButtons(){
        this.skillButtons = new ArrayList<Button>();
        this.skillBtnP1_1.setVisible(false);
        this.skillBtnP1_2.setVisible(false);
        this.skillBtnP1_3.setVisible(false);
        this.skillBtnP1_4.setVisible(false);
        this.skillBtnP2_1.setVisible(false);
        this.skillBtnP2_2.setVisible(false);
        this.skillBtnP2_3.setVisible(false);
        this.skillBtnP2_4.setVisible(false);
        this.skillButtons.addAll(Arrays.asList(skillBtnP1_1, skillBtnP1_2, skillBtnP1_3, skillBtnP1_4, skillBtnP2_1, skillBtnP2_2, skillBtnP2_3, skillBtnP2_4));
    }
    public void initAttackButtons() {
        this.attackButtons = new ArrayList<Button>();
        this.attackBtnP1_1.setVisible(false);
        this.attackBtnP1_2.setVisible(false);
        this.attackBtnP1_3.setVisible(false);
        this.attackBtnP1_4.setVisible(false);
        this.attackBtnP2_1.setVisible(false);
        this.attackBtnP2_2.setVisible(false);
        this.attackBtnP2_3.setVisible(false);
        this.attackBtnP2_4.setVisible(false);
        this.attackButtons.addAll(Arrays.asList(attackBtnP1_1, attackBtnP1_2, attackBtnP1_3, attackBtnP1_4, attackBtnP2_1, attackBtnP2_2, attackBtnP2_3, attackBtnP2_4));
    }
    public void initVariables(){
        this.isAttack = false;
    }

    //Receiving data
    public void receiveData(Player one, Player two){
        playerOne = one;
        playerTwo = two;

        //Initializations
        this.initCardsOnArena();

        //Display the name on the screen
        this.playerOneName.setText("Player One: " + playerOne.getName());
        this.playerTwoName.setText("Player Two: " + playerTwo.getName());

        //render
        this.renderPlayerHp();
        this.renderCardsHp();
        this.renderPlayerOneCardImgViews();
        this.renderPlayerTwoCardImgViews();

        this.thisTurn();
    }

    //Methods
    public void sortCardsOnArenaBySpeed() {
        for(int i=0;i<this.cardsOnArena.size();i++){
            for(int j=i+1;j<this.cardsOnArena.size();j++){
                if(this.cardsOnArena.get(i).getSpeed() < this.cardsOnArena.get(j).getSpeed() ){
                    Collections.swap(this.cardsOnArena, i, j);
                }
            }
        }
    }
    public void thisTurn( ){
        if(this.cardsOnArena.size() > 0){
            this.cardThisTurn = cardsOnArena.get(this.indexOfCard);
            Player player = this.cardThisTurn.getSelectedBy();
            String prefix;
            if(player.getName().equals(this.playerOne.getName())){
                prefix="P1";
            }
            else {
                prefix = "P2";
            }
            int index = player.getSelectedCard().indexOf(this.cardThisTurn);
            this.showButton(prefix, index);
        }
    }
    public void endTurn() {
        this.indexOfCard += 1;
        if(this.indexOfCard > this.cardsOnArena.size() - 1){
            this.indexOfCard = 0;
        }
        this.thisTurn();
    }
    public void showButton(String prefix, int index){
        if(prefix.equals("P1")){
            for(int i=0;i<this.attackButtons.size();i++) {
                if(i == index){
                    this.attackButtons.get(i).setVisible(true);
                }
            }
            for(int i=0;i<this.skillButtons.size();i++) {
                if(i == index) {
                    this.skillButtons.get(i).setVisible(true);
                }
            }
        }
        else if(prefix.equals("P2")){
            for(int i=4;i<this.attackButtons.size();i++) {
                if(i == index+4){
                    this.attackButtons.get(i).setVisible(true);
                }
            }
            for(int i=4;i<this.skillButtons.size();i++) {
                if(i == index+4) {
                    this.skillButtons.get(i).setVisible(true);
                }
            }
        }
    }
    public Card getCardByClickOnImg(String imgId) {
        if(imgId.startsWith("imgP1")){
            for(int i=0;i<this.playerOne.getSelectedCard().size();i++){
                if(imgId.equals("imgP1_" + (i+1))){
                    return this.playerOne.getSelectedCard().get(i);
                }
            }
        }
        else if(imgId.startsWith("imgP2")) {
            for(int i=0;i<this.playerTwo.getSelectedCard().size();i++){
                if(imgId.equals("imgP2_" + (i+1))){
                    return this.playerTwo.getSelectedCard().get(i);
                }
            }
        }
        return null;
    }

    //Buttons Controllers
    public void onNext(ActionEvent e) throws Exception{
        //send player names to BuyingPhaseController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/PlayerOneBuyingPhase.fxml"));
        root = loader.load();

        PlayerOneBuyingPhaseController controller = loader.getController();
        controller.receiveData(this.playerOne, this.playerTwo);

        //Switch to BuyingPhaseScene
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onHit(ActionEvent e) {
        this.playerOne.takeDmg();
        this.playerOneHp.setText("Player One HP : " + this.playerOne.getHp());
        System.out.println("Player one HP : " + this.playerOne.getHp());
    }
    public void onMouseEntered(MouseEvent e) {
        ImageView imgV = (ImageView)e.getSource();
        imgV.setOnMouseEntered(c -> {
            imgV.setScaleX(1.25);
            imgV.setScaleY(1.25);
//            imgV.setStyle("-fx-border-color: #545454;");
        });
    }
    public void onMouseExited(MouseEvent e){
        ImageView imgV = (ImageView)e.getSource();
        imgV.setOnMouseExited(c -> {
            imgV.setScaleX(1);
            imgV.setScaleY(1);
        });
    }
    public void onSelect(MouseEvent e) {
        ImageView imgV = (ImageView)e.getSource();
        System.out.println("CLICKED!!!!");
        String imgId = ((ImageView)e.getSource()).getId();
        Card selectedCard = getCardByClickOnImg(imgId);
        //check if this attack button is hit, if the card turn is on playerOne arena
        if(this.isAttack && cardsOnArena.get(indexOfCard).getSelectedBy().getName().equals(this.playerOne.getName())){
            if(imgId.startsWith("imgP2") && selectedCard != null){
                selectedCard.takeDmg(this.cardThisTurn.getDamage());
                this.renderCardsHp();
                this.renderPlayerTwoCardImgViews();
            }
        }
    }
    public void onAttack(ActionEvent e) {
        //Attack actions
        Button thisButton = (Button)e.getSource();
        int indexOfThisButton = this.attackButtons.indexOf(thisButton);
        this.isAttack = true;
        //Player one card press attack -> need to show that you can select enemy card to attack.
        //Check if hit the button of player's one hands -> change opacity of card to show that you can not click the friendly card.
        if(indexOfThisButton < 4) {
            for(int i=0;i<this.playerOneImgViews.length;i++){
                this.playerOneImgViews[i].setOpacity(0.25);
            }
        }
        else {
            for(int i=0;i<this.playerTwoImgViews.length;i++){
                this.playerTwoImgViews[i].setOpacity(0.25);
            }
        }
    }
    public void onSkill(ActionEvent e) {
        //Skill Actions

        this.endTurn();
    }

    //Render
    public void renderPlayerOneCardImgViews() {
        int i;
        for(i=0;i<this.playerOne.getSelectedCard().size();i++){
            this.playerOneImgViews[i].setImage(this.playerOne.getSelectedCard().get(i).getImage());
        }
        for(int j=i+1;j<4;j++){
            this.playerOneImgViews[j].setImage(new Image("./Assets/blankCard.png"));
        }
        if(this.playerOne.getSelectedCard().size() == 0){
            this.playerOneImgViews[0].setImage(new Image("./Assets/blankCard.png"));
        }
    }
    public void renderPlayerTwoCardImgViews() {
        int i;
        for(i=0;i<this.playerTwo.getSelectedCard().size();i++) {
            this.playerTwoImgViews[i].setImage(this.playerTwo.getSelectedCard().get(i).getImage());
        }
        for(int j=i+1;j<4;j++){
            this.playerTwoImgViews[j].setImage(new Image("Assets/blankCard.png"));
        }
        if(this.playerTwo.getSelectedCard().size() == 0){
            this.playerTwoImgViews[0].setImage(new Image("./Assets/blankCard.png"));
        }
    }
    public void renderPlayerHp() {
        this.playerOneHp.setText("Player One HP : " + this.playerOne.getHp());
        this.playerTwoHp.setText("Player Two HP : " + this.playerTwo.getHp());
    }
    public void renderCardsHp() {
        for(int i=0;i<this.playerOne.getSelectedCard().size();i++) {
            this.hpCards.get(i).setText("" + this.playerOne.getSelectedCard().get(i).getHp() + "/" + this.playerOne.getSelectedCard().get(i).getMaxHp());
        }
        for(int i=0;i<this.playerTwo.getSelectedCard().size();i++){
            this.hpCards.get(i+4).setText("" + this.playerTwo.getSelectedCard().get(i).getHp() + "/" + this.playerTwo.getSelectedCard().get(i).getMaxHp());
        }
    }
}
