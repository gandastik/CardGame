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


    public void receiveData(Player winner, Player one, Player two){
        this.playerWinner = winner;
        this.playerOne = one;
        this.playerTwo = two;

        this.winnerName.setText(this.playerWinner.getName());
        this.summary.setText(this.playerWinner.getName() + " Have made " + this.playerWinner.getMoney());
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
