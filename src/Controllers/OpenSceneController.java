package Controllers;

import Classes.SoundEffects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;


public class OpenSceneController {
    @FXML
    private AnchorPane scenePane;
    private Scene scene;
    private Stage stage;
    private Parent root;


    public void onPlay(ActionEvent e) throws Exception{
        //Switch to Startscene
        root = FXMLLoader.load(getClass().getResource("../Scenes/StartScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        SoundEffects.playMenuClick();
    }

    public void onCredit(ActionEvent e) throws Exception{
        //Switch to Creditscene
        root = FXMLLoader.load(getClass().getResource("../Scenes/CreditScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

        //Player menuclick sfx
        SoundEffects.playMenuClick();
    }

    public void onQuit(ActionEvent e) throws Exception{
        SoundEffects.playMenuClick();

        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("You have quit the program!");
        stage.close();
    }
}
