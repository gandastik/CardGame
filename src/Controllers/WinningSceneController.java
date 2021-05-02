package Controllers;

import Classes.Player;
import Classes.SoundEffects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class WinningSceneController {
    @FXML
    private Label playerName;

    public void receiveData(Player player) {
        this.playerName.setText(player.getName() + " is the WINNER");
        SoundEffects.playWinning();
    }

    public void onBack(ActionEvent e) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/OpenScene.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

            SoundEffects.stopWinning();
            SoundEffects.playMenuClick();
    }
}
