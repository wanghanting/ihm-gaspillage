package Program;

import Program.Controller.ControllerEnregistrer;
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
        StageFactory stages = new StageFactory();
        //create a loader
        FXMLLoader loader = new FXMLLoader();
        ModelListOfFood modelListOfFood = new ModelListOfFood();
        ModelListOfTags modelListOfTags = new ModelListOfTags();
        ControllerEnregistrer controllerenregistrer= new ControllerEnregistrer();
        ViewEnregistrer viewEnregistrer=new ViewEnregistrer();
        loader.setController(controllerenregistrer);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/enregistrer.fxml"));
        root.getStylesheets().add(getClass().getResource("Resources/view.css").toExternalForm());
        //controllerenregistrer.getBtn_ajouter().getStyleClass().add("buttonFred");
        controllerenregistrer.init(modelListOfFood,primaryStage,stages);
        viewEnregistrer.init(modelListOfTags,controllerenregistrer);

        primaryStage.setTitle("Gaspillage");
        primaryStage.setScene(new Scene(root, 700, 375));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
