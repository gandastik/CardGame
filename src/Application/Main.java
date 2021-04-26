package Application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {
    private Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/OpenScene.fxml"));
        primaryStage.setTitle("Card Battle");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image("Assets/icon.png"));
        primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent e) -> {
            if(KeyCode.ESCAPE == e.getCode()){
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exiting");
                alert.setHeaderText("You are about to exit");
                stage = (Stage) alert.getDialogPane().getScene().getWindow();
                stage.getIcons().add(new Image("Assets/icon.png"));
                if(alert.showAndWait().get() == ButtonType.OK){
                    primaryStage.close();
                }
            }
        });
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
