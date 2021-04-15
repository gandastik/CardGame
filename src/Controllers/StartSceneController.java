package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    public void onOk(ActionEvent e) throws Exception{

        //send player names to BuyingPhaseController
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Scenes/BuyingPhase.fxml"));
        root = loader.load();

        BuyingPhaseController buyingPhaseController = loader.getController();
        buyingPhaseController.displayName(playerOneTextField.getText(), playerTwoTextField.getText());

        //Switch to OpenScene
//        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/OpenScene.fxml"));
        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
