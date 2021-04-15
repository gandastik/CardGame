package Controllers;

import Classes.Player;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class BuyingPhaseController {
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
}
