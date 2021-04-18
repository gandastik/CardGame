package Controllers;

import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BattlePhaseController implements Initializable {
    private Node node;
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private Label playerOneName, playerTwoName, playerOneHp, playerTwoHp;

    @FXML
    private ImageView imgP1_1, imgP1_2, imgP1_3, imgP1_4;
    private ImageView[] playerOneImgViews;

    Player playerOne;
    Player playerTwo;

    //Initializations
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.initPlayerOneCardImgViews();

    }
    public void initPlayerOneCardImgViews(){
        this.playerOneImgViews = new ImageView[4];
        this.playerOneImgViews[0] = imgP1_1;
        this.playerOneImgViews[1] = imgP1_2;
        this.playerOneImgViews[2] = imgP1_3;
        this.playerOneImgViews[3] = imgP1_4;
    }

    //Receiving data
    public void receiveData(Player one, Player two){
        playerOne = one;
        playerTwo = two;

        //Display the name on the screen
        this.playerOneName.setText("Player One: " + playerOne.getName());
        this.playerTwoName.setText("Player Two: " + playerTwo.getName());

        //Display the hp on the screen
        this.renderPlyaersHp();

        //render
        this.renderPlayerOneCardImgViews();
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
        });
    }
    public void onMouseExited(MouseEvent e){
        ImageView imgV = (ImageView)e.getSource();
        imgV.setOnMouseExited(c -> {
            imgV.setScaleX(1);
            imgV.setScaleY(1);
        });
    }


    //Render
    public void renderPlayerOneCardImgViews() {
        for(int i=0;i<this.playerOne.getSelectedCard().size();i++){
            this.playerOneImgViews[i].setImage(this.playerOne.getSelectedCard().get(i).getImage());
        }
    }
    public void renderPlyaersHp() {
        this.playerOneHp.setText("Player One HP : " + this.playerOne.getHp());
        this.playerTwoHp.setText("Player Two HP : " + this.playerTwo.getHp());
    }
}
