package Controllers;

import Classes.*;
import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.event.Event;
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
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    private ArrayList<Label> hpPlayerOneCards;
    private ArrayList<Label> hpPlayerTwoCards;

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
    private ArrayList<Card> playerOneTempList;
    private ArrayList<Card> playerTwoTempList;

    private Boolean isAttack;
    private Boolean isSkill;

    public static int numberOfTurn = 1;

    private Player playerWinner;
    private ArrayList<Integer> moneyWon;

    private ArrayList<FadeTransition> playerOneFadeTransition;
    private ArrayList<FadeTransition> playerTwoFadeTransition;
    @FXML
    private Label criticalLabel;
    private FadeTransition criticalFade;

    //Initializations
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initVariables();
        this.initPlayerOneCardImgViews();
        this.initPlayerTwoCardImgViews();
        this.initHpCards();
        this.initPlayersFadeTransition();
        this.initCriticalFadeEffect();

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
        this.hpPlayerOneCards = new ArrayList<Label>();
        this.hpPlayerOneCards.addAll(Arrays.asList(hpP1_1, hpP1_2, hpP1_3, hpP1_4));
        this.hpPlayerTwoCards = new ArrayList<Label>();
       this.hpPlayerTwoCards.addAll(Arrays.asList(hpP2_1, hpP2_2, hpP2_3, hpP2_4));
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
        this.playerOneTempList = new ArrayList<Card>();
        this.playerTwoTempList = new ArrayList<Card>();
        this.isAttack = false;
        this.isSkill = false;
    }
    public void initPlayersFadeTransition() {
        this.playerOneFadeTransition = new ArrayList<FadeTransition>();
        this.playerTwoFadeTransition = new ArrayList<FadeTransition>();
         for(int i=0;i<this.playerOneImgViews.length;i++){
             this.playerOneFadeTransition.add(new FadeTransition(Duration.seconds(0.1), this.playerOneImgViews[i]));
             this.playerOneFadeTransition.get(i).setAutoReverse(true);
             int finalI = i;
             this.playerOneFadeTransition.get(i).setOnFinished(e -> playerOneFadeTransition.get(finalI).stop());
             this.playerOneFadeTransition.get(i).setFromValue(1.0);
             this.playerOneFadeTransition.get(i).setToValue(0.0);
             this.playerOneFadeTransition.get(i).setCycleCount(4);
         }
         for(int i=0;i<this.playerTwoImgViews.length;i++){
             this.playerTwoFadeTransition.add(new FadeTransition(Duration.seconds(0.1), this.playerTwoImgViews[i]));
             this.playerTwoFadeTransition.get(i).setAutoReverse(true);
             int finalI = i;
             this.playerTwoFadeTransition.get(i).setOnFinished(e -> playerTwoFadeTransition.get(finalI).stop());
             this.playerTwoFadeTransition.get(i).setFromValue(1.0);
             this.playerTwoFadeTransition.get(i).setToValue(0.0);
             this.playerTwoFadeTransition.get(i).setCycleCount(4);
         }

    }
    public void initCriticalFadeEffect() {
        this.criticalLabel.setVisible(false);
        this.criticalFade = new FadeTransition(Duration.seconds(0.2), criticalLabel);
        this.criticalFade.setOnFinished(e -> {
            this.criticalFade.stop();
            this.criticalLabel.setVisible(false);
        });
        this.criticalFade.setCycleCount(5);
        this.criticalFade.setFromValue(0.0);
        this.criticalFade.setToValue(1.0);
    }

    //Receiving data
    public void receiveData(Player one, Player two){
        playerOne = one;
        playerTwo = two;

        //add Card of players to the temp list -> so we can keep track of what card each player had in the first place.
        this.playerOneTempList.addAll(this.playerOne.getSelectedCard());
        this.playerTwoTempList.addAll(this.playerTwo.getSelectedCard());
        //Initializations
        this.initCardsOnArena();

        //Display the name on the screen
        this.playerOneName.setText("Player: " + playerOne.getName());
        this.playerTwoName.setText("Player: " + playerTwo.getName());

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
    public void endTurn(Event e) throws Exception{
        this.resetVisibility();
        this.isAttack = false;
        this.isSkill = false;

        if(this.checkIfFinish()){
            //If the battle is finished display the winning scene
            FXMLLoader confirmLoader = new FXMLLoader(getClass().getResource("../Scenes/ConfirmWinningScene.fxml"));
            root = confirmLoader.load();
            ConfirmWinningController controller = confirmLoader.getController();
            controller.receiveData(this.playerWinner, this.playerOne, this.playerTwo);
            Scene exitScene = new Scene(root);

            Stage window1 = new Stage();
            window1.initModality(Modality.APPLICATION_MODAL);
            window1.setTitle(this.playerWinner.getName() + " is the winner");

            window1.setScene(exitScene);
            window1.showAndWait();
            //If the click OK close the winner popup and change the current stage to PlayerOneBuyingPhase.
            if(ConfirmWinningController.onNext){
                stage = (Stage) ((ImageView)e.getSource()).getScene().getWindow();
                stage.close();
            }
        }
        else if(!this.checkIfFinish()){
            this.indexOfCard += 1;
            if(this.indexOfCard > this.cardsOnArena.size() - 1){
                this.indexOfCard = 0;
            }
            this.thisTurn();
        }
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
    public void resetVisibility(){
        for(int i=0;i<this.attackButtons.size();i++){
            this.attackButtons.get(i).setVisible(false);
            this.skillButtons.get(i).setVisible(false);
        }
        for(int i=0;i < this.playerOneImgViews.length;i++){
            this.playerOneImgViews[i].setOpacity(1);
        }
        for(int i=0;i<this.playerTwoImgViews.length;i++){
            this.playerTwoImgViews[i].setOpacity(1);
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
    public Card getCardByOnSkill(String btnId) {
        if(btnId.startsWith("skillBtnP1_")){
            for(int i=0;i<this.playerOne.getSelectedCard().size();i++) {
                if(btnId.equals("skillBtnP1_" + (i+1))){
                    return this.playerOne.getSelectedCard().get(i);
                }
            }
        }
        else if (btnId.startsWith("skillBtnP2_")){
            for(int i=0;i<this.playerTwo.getSelectedCard().size();i++) {
                if(btnId.equals("skillBtnP2_" + (i+1))){
                    return this.playerTwo.getSelectedCard().get(i);
                }
            }
        }
        return null;
    }
    public Boolean checkIfFinish(){
        if(this.playerOne.getSelectedCard().size() == 0){
            int totalLevel = 0;
            for(int i=0;i<this.playerTwo.getSelectedCard().size();i++){
                totalLevel += this.playerTwo.getSelectedCard().get(i).getLevel();
            }
            this.playerOne.takeDmg(totalLevel);
            System.out.println("Player One took " + totalLevel + " Damages");
            //Winner get more money, loser get less money
            this.playerTwo.addMoney(2 * totalLevel);
            this.playerOne.addMoney(3);
            this.playerWinner = this.playerTwo;
            this.renderPlayerHp();
            this.resetState();
            return true;
        }
        else if(this.playerTwo.getSelectedCard().size() == 0){
            int totalLevel = 0;
            for(int i=0;i<this.playerOne.getSelectedCard().size();i++){
                totalLevel += this.playerOne.getSelectedCard().get(i).getLevel();
            }
            this.playerTwo.takeDmg(totalLevel);
            System.out.println("Player Two took " + totalLevel + " Damages");
            //Winner get more money, loser get less money
            this.playerOne.addMoney(2 * totalLevel * BattlePhaseController.numberOfTurn);
            this.playerTwo.addMoney(BattlePhaseController.numberOfTurn + 2);
            this.playerWinner = this.playerOne;
            this.renderPlayerHp();
            this.resetState();
            return true;
        }
        return false;
    }
    public void resetState() {
        for(int i=0;i<this.playerOneTempList.size();i++) {
            this.playerOneTempList.get(i).reset();
        }
        for(int i=0;i<this.playerTwoTempList.size();i++) {
            this.playerTwoTempList.get(i).reset();
        }
        this.playerOne.setSelectedCard(this.playerOneTempList);
        this.playerTwo.setSelectedCard(this.playerTwoTempList);
    }
    public void playCriticalEffect() {
        this.criticalLabel.setVisible(true);
        this.criticalFade.play();
    }

    //Buttons Controllers
    public void onNext(ActionEvent e) throws Exception{
        //send player names to BuyingPhaseController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/PlayerOneBuyingPhase.fxml"));
        root = loader.load();

        PlayerOneBuyingPhaseController controller = loader.getController();
        controller.receiveData(this.playerOne, this.playerTwo);
        System.out.println("number of turn is " + BattlePhaseController.numberOfTurn);
        BattlePhaseController.numberOfTurn+=1;


        //Switch to BuyingPhaseScene
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    public void onMouseEntered(MouseEvent e) {
//        ImageView imgV = (ImageView)e.getSource();
//        imgV.setOnMouseEntered(c -> {
//            imgV.setScaleX(1.25);
//            imgV.setScaleY(1.25);
////            imgV.setStyle("-fx-border-color: #545454;");
//        });
    }
    public void onMouseExited(MouseEvent e){
//        ImageView imgV = (ImageView)e.getSource();
//        imgV.setOnMouseExited(c -> {
//            imgV.setScaleX(1);
//            imgV.setScaleY(1);
//        });
    }
    public void onSelect(MouseEvent e) throws Exception{
        ImageView imgV = (ImageView)e.getSource();
        System.out.println("CLICKED!!!!");
        String imgId = ((ImageView)e.getSource()).getId();
        Card selectedCard = getCardByClickOnImg(imgId);
        //check if this attack button is hit, if the card turn is on playerOne arena
        /* PLAYER ONE CARD'S TURN (ATTACK MODE) */
        if(this.isAttack && this.cardThisTurn.getSelectedBy().getName().equals(this.playerOne.getName())){
            if(imgId.startsWith("imgP2") && selectedCard != null){
                if(cardThisTurn.getTribe().equals("fire")){
                    FireTribe card = (FireTribe)cardThisTurn;
                    if(card.isCritical()){
                        this.playCriticalEffect();
                        System.out.println("CRITICALLLL !!! !! !");
                        selectedCard.takeDmg(this.cardThisTurn.getDamage() * 2);
                    }
                    else {
                        selectedCard.takeDmg(this.cardThisTurn.getDamage());
                    }
                }
                else {
                    selectedCard.takeDmg(this.cardThisTurn.getDamage());
                }
                if(selectedCard.getIsDead()){
                    System.out.println("DEAD");
                    this.playerTwo.getSelectedCard().remove(selectedCard);
                    this.cardsOnArena.remove(selectedCard);
                }
                else{
                    int indexOfSelectedCard = this.playerTwo.getSelectedCard().indexOf(selectedCard);
                    this.playerTwoFadeTransition.get(indexOfSelectedCard).play();
                }
                this.renderCardsHp();
                this.renderPlayerTwoCardImgViews();
                this.endTurn(e);
            }
        }
        /* PLAYER TWO CARD'S TURN (ATTACK MODE) */
        else if(this.isAttack && this.cardThisTurn.getSelectedBy().getName().equals(this.playerTwo.getName())){
            if(imgId.startsWith("imgP1") && selectedCard != null){
                if(cardThisTurn.getTribe().equals("fire")){
                    FireTribe card = (FireTribe)cardThisTurn;
                    if(card.isCritical()){
                        this.playCriticalEffect();
                        System.out.println("CRITICALLLL !!! !! !");
                        selectedCard.takeDmg(this.cardThisTurn.getDamage() * 2);
                    }
                    else {
                        selectedCard.takeDmg(this.cardThisTurn.getDamage());
                    }
                }
                else {
                    selectedCard.takeDmg(this.cardThisTurn.getDamage());
                }
                if(selectedCard.getIsDead()){
                    System.out.println("DEAD");
                    this.playerOne.getSelectedCard().remove(selectedCard);
                    this.cardsOnArena.remove(selectedCard);
                }
                else{
                    int indexOfSelectedCard = this.playerOne.getSelectedCard().indexOf(selectedCard);
                    this.playerOneFadeTransition.get(indexOfSelectedCard).play();
                }
                this.renderCardsHp();
                this.renderPlayerOneCardImgViews();
                this.endTurn(e);
            }
        }
        else if(this.isSkill && this.cardThisTurn.getSelectedBy().getName().equals(this.playerOne.getName())){
            if(imgId.startsWith("imgP1") && selectedCard != null){
                if(this.cardThisTurn.getTribe().equals("water")){
                    WaterTribe card = (WaterTribe)cardThisTurn;
                    selectedCard.healing(card.getHeal());
                }
                else if(this.cardThisTurn.getTribe().equals("rock")){
                    RockTribe card = (RockTribe)cardThisTurn;
                    selectedCard.shielding(card.getShield());
                }
                int indexOfSelectedCard = this.playerOne.getSelectedCard().indexOf(selectedCard);
                this.playerOneFadeTransition.get(indexOfSelectedCard).play();
                this.renderCardsHp();
                this.endTurn(e);
            }
        }
        else if(this.isSkill && this.cardThisTurn.getSelectedBy().getName().equals(this.playerTwo.getName())){
            if(imgId.startsWith("imgP2") && selectedCard != null){
                if(this.cardThisTurn.getTribe().equals("water")){
                    WaterTribe card = (WaterTribe)cardThisTurn;
                    selectedCard.healing(card.getHeal());
                }
                else if(this.cardThisTurn.getTribe().equals("rock")){
                    RockTribe card = (RockTribe)cardThisTurn;
                    selectedCard.shielding(card.getShield());
                }
                int indexOfSelectedCard = this.playerTwo.getSelectedCard().indexOf(selectedCard);
                this.playerTwoFadeTransition.get(indexOfSelectedCard).play();
                this.renderCardsHp();
                this.endTurn(e);
            }
        }
    }
    public void onAttack(ActionEvent e) {
        //Attack actions
        Button thisButton = (Button)e.getSource();
        int indexOfThisButton = this.attackButtons.indexOf(thisButton);
        //Player one card press attack -> need to show that you can select enemy card to attack.
        //Check if hit the button of player's one hands -> change opacity of card to show that you can not click the friendly card.
        if(!isSkill){
            System.out.println("ATTACK MODE");
            this.isAttack = true;
            if(indexOfThisButton < 4) {
                for (ImageView playerOneImgView : this.playerOneImgViews) {
                    playerOneImgView.setOpacity(0.25);
                }
            }
            else {
                for (ImageView playerTwoImgView : this.playerTwoImgViews) {
                    playerTwoImgView.setOpacity(0.25);
                }
            }
        }
    }
    public void onSkill(ActionEvent e) {
        //Skill Actions
        Button thisButton = (Button)e.getSource();
        String btnId = thisButton.getId();
        if(!this.isAttack && !cardThisTurn.getTribe().equals("fire")){
            System.out.println("SKILL MODE");
            this.isSkill = true;
            if(btnId.startsWith("skillBtnP1") && ( this.cardThisTurn.getTribe().equals("water") || this.cardThisTurn.getTribe().equals("rock") )){
                for (ImageView playerTwoImgView : this.playerTwoImgViews) {
                    playerTwoImgView.setOpacity(0.25);
                }
            }
            else if(btnId.startsWith("skillBtnP2") && ( this.cardThisTurn.getTribe().equals("water") || this.cardThisTurn.getTribe().equals("rock") )){
                for (ImageView playerOneImgView : this.playerOneImgViews) {
                    playerOneImgView.setOpacity(0.25);
                }
            }
        }
    }

    //Render
    public void renderPlayerOneCardImgViews() {
        int index = 0;
        for(int i=0;i<this.playerOne.getSelectedCard().size();i++){
            this.playerOneImgViews[i].setImage(this.playerOne.getSelectedCard().get(i).getImage());
            index = i;
        }
        for(int j= index+1;j<this.playerOneImgViews.length;j++){
            this.playerOneImgViews[j].setImage(new Image("./Assets/blankCard.png"));
        }
        if(this.playerOne.getSelectedCard().size() == 0){
            this.playerOneImgViews[0].setImage(new Image("./Assets/blankCard.png"));
        }
    }
    public void renderPlayerTwoCardImgViews() {
        int index = 0;
        for(int i=0;i<this.playerTwo.getSelectedCard().size();i++) {
            this.playerTwoImgViews[i].setImage(this.playerTwo.getSelectedCard().get(i).getImage());
            index = i;
        }
        for(int j=index+1;j<this.playerTwoImgViews.length;j++){
            this.playerTwoImgViews[j].setImage(new Image("Assets/blankCard.png"));
        }
        if(this.playerTwo.getSelectedCard().size() == 0){
            this.playerTwoImgViews[0].setImage(new Image("./Assets/blankCard.png"));
        }
    }
    public void renderPlayerHp() {
        this.playerOneHp.setText("HP: " + this.playerOne.getHp());
        this.playerTwoHp.setText("HP: " + this.playerTwo.getHp());
    }
    public void renderCardsHp() {
        int index1 = 0, index2 = 0;
        for(int i=0;i<this.playerOne.getSelectedCard().size();i++) {
            this.hpPlayerOneCards.get(i).setText("" + this.playerOne.getSelectedCard().get(i).getHp() + "/" + this.playerOne.getSelectedCard().get(i).getMaxHp());
            index1 = i;
        }
        for(int j=index1+1;j<this.hpPlayerOneCards.size();j++){
            this.hpPlayerOneCards.get(j).setVisible(false);
        }
        if(this.playerOne.getSelectedCard().size() == 0){
            this.hpPlayerOneCards.get(0).setVisible(false);
        }

        for(int i=0;i<this.playerTwo.getSelectedCard().size();i++){
            this.hpPlayerTwoCards.get(i).setText("" + this.playerTwo.getSelectedCard().get(i).getHp() + "/" + this.playerTwo.getSelectedCard().get(i).getMaxHp());
            index2 = i;
        }
        for(int j=index2+1;j<this.hpPlayerTwoCards.size();j++){
            this.hpPlayerTwoCards.get(j).setVisible(false);
        }
        if(this.playerTwo.getSelectedCard().size() == 0){
            this.hpPlayerTwoCards.get(0).setVisible(false);
        }
    }
}
