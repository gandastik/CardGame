package Application;

import Classes.Card;
import Classes.FireTribe;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../Scenes/OpenScene.fxml"));
        primaryStage.setTitle("Card Battle");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        Card card1 = new Card("Burning_Algae", "fire", 3, 120, 100);
//        Card card2 = new Card("Burning_Algae", "fire", 3, 120, 100);
//        System.out.println(card1.equals(card2));
        launch(args);
    }
}
