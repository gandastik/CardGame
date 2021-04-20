package Controllers;

import Classes.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class OpenSceneController implements Initializable {
    @FXML
    private AnchorPane scenePane;
    private Scene scene;
    private Stage stage;
    private Parent root;

    private Media soundOpenSceneBackgroundMedia;
    private MediaPlayer soundOpenSceneBackgroundMediaPlayer;


    //Initializations
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playSoundOpenSceneBackground();
    }



    public void onPlay(ActionEvent e) throws Exception{
        //Switch to Startscene
        root = FXMLLoader.load(getClass().getResource("../Scenes/StartScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    public void onQuit(ActionEvent e) throws Exception{
        stage = (Stage) scenePane.getScene().getWindow();
        System.out.println("You have quit the program!");
        stage.close();
    }

    private void playSoundOpenSceneBackground() {

        soundOpenSceneBackgroundMedia = new Media("../Assets/SoundGame/SoundMenuMusic.mp3");

        soundOpenSceneBackgroundMediaPlayer = new MediaPlayer(soundOpenSceneBackgroundMedia);
        soundOpenSceneBackgroundMediaPlayer.play();
    }
}
