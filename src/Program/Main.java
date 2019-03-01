package Program;

import Program.Controller.ControllerAccueil;
import Program.Model.ModelListOfFood;
import Program.Model.ModelListOfTags;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //create a loader
        FXMLLoader loader = new FXMLLoader();
        ModelListOfFood modelListOfFood = new ModelListOfFood();
        ControllerAccueil controllerAccueil= new ControllerAccueil();
        ViewFood viewFood = new ViewFood();
        loader.setController(controllerAccueil);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/page_d'accueil.fxml"));
        controllerAccueil.init(modelListOfFood,viewFood);
        viewFood.init(modelListOfFood,controllerAccueil);

        primaryStage.setTitle("Gaspillage");
        primaryStage.setScene(new Scene(root, 600, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
