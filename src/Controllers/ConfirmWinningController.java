package Controllers;

import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class ConfirmWinningController {
    private Node node;
    private Stage stage;
    private Parent root;
    private Scene scene;

    private Player playerOne, playerTwo;

    public static void display() throws Exception {
        Parent exitParent = FXMLLoader.load(ConfirmWinningController.class.getResource("../scenes/ConfirmWinningScene.fxml"));
        Scene exitScene = new Scene(exitParent);

        Stage window1 = new Stage();
        window1.initModality(Modality.APPLICATION_MODAL);
        window1.setTitle("Do you want to exit?");

        window1.setScene(exitScene);
        window1.showAndWait();
    }

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

    public void receiveData(Player one, Player two) {
        playerOne = one;
        playerTwo = two;
    }
}
