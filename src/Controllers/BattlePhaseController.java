package Controllers;

import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BattlePhaseController {
    private Node node;
    private Stage stage;


    @FXML
    private Label dataLabel;

    Player playerOne;

    //Just trying to figure out how to receive data from other controller
    public void showData(ActionEvent event){
        node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        playerOne = (Player) stage.getUserData();
        String name = playerOne.getName();

        dataLabel.setText("Data : " + name);
    }
}
