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
    @FXML
    private Label playerOneHp;
    @FXML
    private Label playerTwoHp;

    public void receiveData(Player one, Player two) {
        playerOne = one;
        playerTwo = two;

        //Display the name on the screen
        this.playerOneName.setText("Player One: " + one.getName());
        this.playerTwoName.setText("Player Two: " + two.getName());

        //Display the hp on the screen
        this.playerOneHp.setText("Player One HP : " + one.getHp());
        this.playerTwoHp.setText("Player Two HP: " + two.getHp());
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
}
