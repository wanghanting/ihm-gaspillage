package Program;

import Program.Controller.ControllerAuthentification;
//import Program.Controller.ControllerEnregistrer;
//import Program.Model.ModelListOfFood;
//import Program.Model.ModelListOfTags;
import Program.Model.ModelListOfUsers;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception {

        FXMLLoader loader = new FXMLLoader();

        StageFactory stages = new StageFactory();

        ViewAuthentification view = new ViewAuthentification();

        //create a controller
        ControllerAuthentification controller = new ControllerAuthentification();

        //attach controller
        loader.setController(controller);

        //attach XML file
        Parent root = loader.load(getClass().getResourceAsStream("Resources/authentification.fxml"));


        ModelListOfUsers model = new ModelListOfUsers();

        //initialize the controller
        controller.init(model, primaryStage, stages);

        view.init(model, controller);
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        primaryStage.setScene(scene);

        //create the view

        //   show the view
        primaryStage.show();
        primaryStage.widthProperty().addListener((ObservableValue<? extends Number> ov,
                                           Number old_val, Number new_val) -> {
            //controllerenregistrer.getHboxa().setPrefWidth(600);

        });

    }



    public static void main(String[] args) {
        launch(args);
    }
}