package Program;

import Program.Controller.ControllerType;
import Program.Model.ModelListOfTags;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader();

        ViewType view = new ViewType();

        ControllerType controller = new ControllerType();

        loader.setController(controller);

        Parent root = loader.load(getClass().getResourceAsStream(view.TYPE));

        ModelListOfTags model = new ModelListOfTags();

        controller.init(model);

        view.init(model,controller);

        primaryStage.setTitle(view.LABEL);
        primaryStage.setScene(new Scene(root, 700, 475));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
