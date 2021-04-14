package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TempSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void onOk(ActionEvent e) throws Exception{
        //Switch to OpenScene
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/OpenScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
