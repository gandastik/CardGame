package Controllers;

import Classes.Card;
import Classes.CardsCollection;
import Classes.FireTribe;
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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
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
    private ImageView img1, img2, img3, img4, img5, img6;
    private ImageView[] imageViews;
    private CardsCollection cardsCollection;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cardsCollection = new CardsCollection();
        this.initImageViews();
        for(int i=0;i<6;i++){
            imageViews[i].setImage(cardsCollection.getCardsCollection().get(i).getImage());
        }
    }

    public void initImageViews() {
        this.imageViews = new ImageView[6];
        this.imageViews[0] = this.img1;
        this.imageViews[1] = this.img2;
        this.imageViews[2] = this.img3;
        this.imageViews[3] = this.img4;
        this.imageViews[4] = this.img5;
        this.imageViews[5] = this.img6;
    }

    public void receiveData(Player one, Player two) {
        playerOne = one;
        playerTwo = two;

        //Display the name on the screen
        this.playerOneName.setText("Player One: " + playerOne.getName());
        this.playerTwoName.setText("Player Two: " + playerTwo.getName());

        //Display the hp on the screen
        this.playerOneHp.setText("Player One HP : " + playerOne.getHp());
        this.playerTwoHp.setText("Player Two HP: " + playerTwo.getHp());
    }

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

    public void onHit(ActionEvent e) {
        this.playerOne.takeDmg();
        this.playerOneHp.setText("Player One HP : " + this.playerOne.getHp());
        System.out.println("Player one HP : " + this.playerOne.getHp());
    }

    public void onBuy(ActionEvent e) {
        //Buying Mechanic
        String id =  ((Button)e.getSource()).getId();
        Card temp = getCardFromBtnId(id);
        System.out.println("Clicked BUY from Card name : " + temp.getName());
    }

    public Card getCardFromBtnId(String btnId) {
        for(int i=0;i<6;i++){
            if(btnId.equals("btn" + (i+1))){
                return cardsCollection.getCardsCollection().get(i);
            }
        }
        return null;
    }
}
