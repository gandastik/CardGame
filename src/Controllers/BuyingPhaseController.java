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


public class BuyingPhaseController {
    private Stage stage;
    private Scene scene;
    private Node node;
    private Parent root;

    Player playerOne;
    Player playerTwo;

    @FXML
    private Label playerOneName;
    @FXML
    private Label playerTwoName;

    public void displayName(String playerOne, String playerTwo) {
        //Set the name to the player
        this.playerOne = new Player(playerOne);
        this.playerTwo = new Player(playerTwo);

        //Display the name on the screen
        playerOneName.setText("Player One: " + playerOne);
        playerTwoName.setText("Player Two: " + playerTwo);
    }

    public void onNext(ActionEvent e) throws Exception{
        node = (Node) e.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();

        root = FXMLLoader.load(getClass().getResource("../Scenes/BattlePhase.fxml"));
        stage.setUserData(playerOne);

        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
