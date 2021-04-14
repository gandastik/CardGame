package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OpenSceneController {
    private Scene scene;
    private Stage stage;
    private Parent root;

    public void onPlay(ActionEvent e) throws Exception{
        //Switch to ....scene <-- change later
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/TempScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void onQuit(ActionEvent e) throws Exception{
        //QUIT APPLICATION
    }
}
