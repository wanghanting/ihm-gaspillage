package Program;

import Program.Controller.*;
import Program.Model.ModelListOfFood;
import Program.Model.ModelListOfTags;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;


public class StageFactory {
    static int width = 600;
    static int height = 475;

    private ModelListOfTags modelListOfTags = new ModelListOfTags();
    private ModelListOfFood modelListOfFood = new ModelListOfFood();

    public Stage initAccueil() throws IOException {

        FXMLLoader loader= new FXMLLoader();
        Stage stage = new Stage();

        ViewAccueil viewFood = new ViewAccueil();
        ControllerAccueil controllerAccueil = new ControllerAccueil();


        loader.setController(controllerAccueil);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/page_d'accueil.fxml"));

        controllerAccueil.init(modelListOfFood,viewFood,stage,this);
        viewFood.init(modelListOfFood, controllerAccueil);
        stage.setScene(new Scene(root, width, height));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        return stage;
    }
    public Stage initEnregistrer() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Stage stage = new Stage();
        ControllerEnregistrer controllerenregistrer = new ControllerEnregistrer();
        ViewAccueil viewFood = new ViewAccueil();
        ViewEnregistrer viewEnregistrer = new ViewEnregistrer();
        loader.setController(controllerenregistrer);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/enregistrer.fxml"));

        controllerenregistrer.init(modelListOfFood, stage,this);
        viewEnregistrer.init(modelListOfTags, controllerenregistrer);
        stage.setScene(new Scene(root, width, height));
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                //�˴���stage�ر�ʱ��ͬʱ�������򣬱���stage�رպ󣬳������ر��ˣ�����̨�߳�ȴ��Ȼ���е�����
                System.exit(0);
            }
        });
        return stage;
    }

    public Stage initType() throws IOException {
        FXMLLoader loader = new FXMLLoader ();
        Stage stage = new Stage ();
        ViewType viewType = new ViewType ();
        ControllerType controller = new ControllerType ();

        loader.setController (controller);
        Parent root = loader.load (getClass ().getResourceAsStream ("Resources/types.fxml"));

        controller.init (modelListOfTags, viewType, stage, this);
        viewType.init (modelListOfTags, controller);
        stage.setScene (new Scene (root, width, height));
        stage.show ();
        stage.setOnCloseRequest (new EventHandler<WindowEvent> () {
            @Override
            public void handle(WindowEvent event) {
                System.exit (0);
            }
        });
        return stage;
    }

    public Stage initAide() throws IOException {
        FXMLLoader loader = new FXMLLoader ();
        Stage stage = new Stage ();
        ControllerAide controllerAide = new ControllerAide ();

        loader.setController (controllerAide);
        Parent root = loader.load (getClass ().getResourceAsStream ("Resources/aide.fxml"));
        controllerAide.init (stage);
        stage.setScene (new Scene (root, width, height));
        stage.show();
        stage.setOnCloseRequest (new EventHandler<WindowEvent> () {
            @Override
            public void handle(WindowEvent event) {
                System.exit (0);
            }
        });
        return stage;
    }

    public Stage initConsomation() throws IOException {
        FXMLLoader loader = new FXMLLoader ();
        Stage stage = new Stage ();
        ControllerConsomationG controllerConsomationG=new ControllerConsomationG();
        ViewConsomationG viewConsomationG = new ViewConsomationG();

        loader.setController (controllerConsomationG);
        Parent root = loader.load (getClass ().getResourceAsStream ("Resources/consommation_graphique.fxml"));
        viewConsomationG.init(controllerConsomationG,modelListOfFood);
        stage.setScene (new Scene (root, width, height));
        stage.show ();
        return stage;

    }

    public void setModelListOfFood(ModelListOfFood modelListOfFood){
        this.modelListOfFood = modelListOfFood;
    }

    public void setModelListOfTags(ModelListOfTags modelListOfTags){
        this.modelListOfTags = modelListOfTags;
    }

}