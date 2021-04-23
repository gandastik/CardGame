package Controllers;

import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class ConfirmWinningController{
    private Node node;
    private Stage stage;
    private Parent root;
    private Scene scene;

    public static Boolean onNext;

    @FXML
    private Label winnerName, summary;
    private Player playerWinner;
    private Player playerOne, playerTwo;
    private int totalDmgTaken;


    public void receiveData(Player winner, Player one, Player two, int totalDmgTaken){
        this.playerWinner = winner;
        this.playerOne = one;
        this.playerTwo = two;
        this.totalDmgTaken = totalDmgTaken;

        this.winnerName.setText(this.playerWinner.getName() + " Has won Round No. " + BattlePhaseController.numberOfTurn);
        if(this.playerWinner.getName().equals(this.playerOne.getName())){
            this.summary.setText(this.playerWinner.getName() + " Has made " + (2 * BattlePhaseController.numberOfTurn + this.totalDmgTaken) + " golds\n" +
                    this.playerTwo.getName() + " Has lost " + this.totalDmgTaken + " life points");
        }
        else {
            this.summary.setText(this.playerWinner.getName() + " Has made " + (2 * BattlePhaseController.numberOfTurn + this.totalDmgTaken) + " golds\n" +
                    this.playerOne.getName() + " Has lost " + this.totalDmgTaken + " life points");
        }
    }

    public void onNext(ActionEvent e) throws Exception{
        //send player names to BuyingPhaseController
        onNext = true;
        stage = (Stage) ((Button)e.getSource()).getScene().getWindow();
        stage.close();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/PlayerOneBuyingPhase.fxml"));
        root = loader.load();

        PlayerOneBuyingPhaseController controller1 = loader.getController();
        controller1.receiveData(this.playerOne, this.playerTwo);

        System.out.println("number of turn is " + BattlePhaseController.numberOfTurn);
        BattlePhaseController.numberOfTurn+=1;

        //Switch to BuyingPhaseScene
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
