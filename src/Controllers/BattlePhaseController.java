package Controllers;

import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BattlePhaseController {
    private Node node;
    private Stage stage;
    private Parent root;
    private Scene scene;

    @FXML
    private Label playerOneName;
    @FXML
    private Label playerTwoName;
    @FXML
    private Label playerOneHp;
    @FXML
    private Label playerTwoHp;

    Player playerOne;
    Player playerTwo;

    //Just trying to figure out how to receive data from other controller
    public void receiveData(Player one, Player two){
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
        //send player names to BuyingPhaseController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/BuyingPhase.fxml"));
        root = loader.load();

        BuyingPhaseController buyingPhaseController = loader.getController();
        buyingPhaseController.receiveData(this.playerOne, this.playerTwo);

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
}
