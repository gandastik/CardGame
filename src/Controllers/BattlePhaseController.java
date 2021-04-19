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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
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
    private Button attackBtnP1_1, attackBtnP1_2, attackBtnP1_3, attackBtnP1_4, skillBtnP1_1, skillBtnP1_2, skillBtnP1_3, skillBtnP1_4;
    private ArrayList<Button> skillButtons;
    private ArrayList<Button> attackButtons;

    private Player playerOne;
    private Player playerTwo;

    private ArrayList<Card> cardsOnArena;
    private int indexOfCard;

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
    }
    public void initHpCards() {
        this.hpCards = new ArrayList<Label>();
        this.hpCards.addAll(Arrays.asList(hpP1_1, hpP1_2, hpP1_3, hpP1_4, hpP2_1, hpP2_2, hpP2_3, hpP2_4));
    }
    public void initSkillButtons(){
        this.skillBtnP1_1.setVisible(false);
        this.skillBtnP1_2.setVisible(false);
        this.skillBtnP1_3.setVisible(false);
        this.skillBtnP1_4.setVisible(false);
        this.skillButtons.addAll(Arrays.asList(skillBtnP1_1, skillBtnP1_2, skillBtnP1_3, skillBtnP1_4));
    }
    public void initAttackButtons() {
        this.attackBtnP1_1.setVisible(false);
        this.attackBtnP1_2.setVisible(false);
        this.attackBtnP1_3.setVisible(false);
        this.attackBtnP1_4.setVisible(false);
        this.attackButtons.addAll(Arrays.asList(attackBtnP1_1, attackBtnP1_2, attackBtnP1_3, attackBtnP1_4));
    }
    public void initVariables(){
        this.indexOfCard = 0;
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
        this.renderPlayerOneCardImgViews();
        this.renderPlayerTwoCardImgViews();
        this.renderCardsHp();
    }

    //Methods
    /*
    public void sortCardsOnArenaBySpeed() {
        for(int i=0;i<this.cardsOnArena.size();i++){
            for(int j=i+1;j<this.cardsOnArena.size();j++){
                if(this.cardsOnArena.get(i).getSpeed() < this.cardsOnArena.get(j).getSpeed() ){
                    Collections.swap(this.cardsOnArena, i, j);
                }
            }
        }
    }*/
    public void thisTurn( ){
        Card cardThisTurn = cardsOnArena.get(this.indexOfCard);
        Player player = cardThisTurn.getSelectedBy();
        String prefix;
        if(player.getName().equals(this.playerOne.getName())){
            prefix="P1";
        }
        else {
            prefix = "P2";
        }
        int index = player.getSelectedCard().indexOf(cardThisTurn);
        showButton(prefix, index);
    }
    public void endTurn() {
        this.indexOfCard += 1;
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
        else{
            for(int i=4;i<this.attackButtons.size();i++) {
                if(i == index){
                    this.attackButtons.get(i).setVisible(true);
                }
            }
            for(int i=4;i<this.skillButtons.size();i++) {
                if(i == index) {
                    this.skillButtons.get(i).setVisible(true);
                }
            }
        }
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
    public void onAttack(ActionEvent e) {
        //Attack actions
        Button thisButton = (Button)e.getSource();
        int indexOfThisButton = this.attackButtons.indexOf(thisButton);
        if(indexOfThisButton < 4) {

        }
        this.endTurn();
    }
    public void onSkill(ActionEvent e) {
        //Skill Actions

        this.endTurn();
    }

    //Render
    public void renderPlayerOneCardImgViews() {
        for(int i=0;i<this.playerOne.getSelectedCard().size();i++){
            this.playerOneImgViews[i].setImage(this.playerOne.getSelectedCard().get(i).getImage());
        }
    }
    public void renderPlayerTwoCardImgViews() {
        for(int i=0;i<this.playerTwo.getSelectedCard().size();i++) {
            this.playerTwoImgViews[i].setImage(this.playerTwo.getSelectedCard().get(i).getImage());
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
