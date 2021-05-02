package Controllers;

import Classes.Player;
import Classes.SoundEffects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
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

    private static Media media;
    private static MediaPlayer mediaPlayer;

    public void onOk(ActionEvent e) throws Exception{
        //send players object to BuyingPhaseController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/PlayerOneBuyingPhase.fxml"));
        root = loader.load();

        PlayerOneBuyingPhaseController controller = loader.getController();
        this.playerOne = new Player(playerOneTextField.getText());
        this.playerTwo = new Player(playerTwoTextField.getText());
        controller.receiveData(this.playerOne, this.playerTwo);

        //Button SFX
        SoundEffects.playMenuClick();

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
            SoundEffects.playBackgroundMusic();
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
