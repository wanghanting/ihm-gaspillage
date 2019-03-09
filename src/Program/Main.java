package Program;

import Program.Controller.ControllerAuthentification;
import Program.Controller.ControllerEnregistrer;
import Program.Controller.ControllerInscription;
import Program.Model.ModelListOfFood;
import Program.Model.ModelListOfTags;
import Program.Model.ModelListOfUsers;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{

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
        controller.init(model,primaryStage,stages);

        view.init( model, controller );

        //create the view
        primaryStage.setScene(new Scene(root, view.WIDTH, view.HEIGHT));
        primaryStage.setTitle(view.LABEL);

        //show the view
        primaryStage.show();
        //StageFactory stages = new StageFactory();
        //create a loader
//        FXMLLoader loader = new FXMLLoader();
//        ModelListOfUsers modelListOfUsers = new ModelListOfUsers();
//        ControllerInscription controllerinscription= new ControllerInscription();
//        ViewInscription viewInscription=new ViewInscription();
//        loader.setController(controllerinscription);
//        Parent root = loader.load(getClass().getResourceAsStream("Resources/inscription.fxml"));
//        controllerinscription.init(modelListOfUsers,primaryStage,stages);
//        viewInscription.init(modelListOfUsers,controllerinscription);
//
//        primaryStage.setTitle("Inscription!");
//        primaryStage.setScene(new Scene(root, 600, 475));
//        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }
}
