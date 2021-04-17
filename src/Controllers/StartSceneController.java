package Controllers;

import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class StartSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField playerOneTextField;
    @FXML
    private TextField playerTwoTextField;

    Player playerOne;
    Player playerTwo;

    public void onOk(ActionEvent e) throws Exception{
        //send players object to BuyingPhaseController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/BuyingPhase.fxml"));
        root = loader.load();

        BuyingPhaseController buyingPhaseController = loader.getController();
        this.playerOne = new Player(playerOneTextField.getText());
        this.playerTwo = new Player(playerTwoTextField.getText());
        buyingPhaseController.receiveData(this.playerOne, this.playerTwo);

        //Switch to OpenScene also check if one of the text field is empty
        if(isTextFieldEmpty(playerOneTextField) || isTextFieldEmpty(playerTwoTextField)){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("WARNING!");
            alert.setHeaderText("Warning!");
            alert.setContentText("Please enter the player name");
            alert.show();
        }
        else if(isTheSameName()){
            Alert aleartName = new Alert(Alert.AlertType.WARNING);
            aleartName.setTitle("WARNING!");
            aleartName.setHeaderText("Warning!");
            aleartName.setContentText("Two players have the same name please change one of the player name.");
            aleartName.show();
        }
        else{
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    public Boolean isTextFieldEmpty(TextField field){
        if(field.getText().length() == 0){
            return true;
        }
        return false;
    }

    public Boolean isTheSameName() {
        return playerOneTextField.getText().equals(playerTwoTextField.getText());
    }

}
