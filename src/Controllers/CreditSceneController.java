package Controllers;

import Classes.SoundEffects;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreditSceneController  implements Initializable{
    private Stage stage;
    private Scene scene;
    private Parent root;

    private SoundEffects sfx;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.sfx = new SoundEffects();
    }

    public void onBack(ActionEvent e) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/OpenScene.fxml"));
        root = loader.load();
        stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        this.sfx.playMenuClick();
    }
}
