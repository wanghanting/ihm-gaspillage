package Program;

import Program.Controller.*;
import Program.Model.ModelListOfFood;
import Program.Model.ModelListOfTags;
import Program.Model.ModelListOfUsers;
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

    public Stage initFoodByType(String type) throws IOException{

        FXMLLoader loader= new FXMLLoader();
        Stage stage = new Stage();

        ViewFoodByType view = new ViewFoodByType();
        ControllerFoodByType controller = new ControllerFoodByType();


        loader.setController(controller);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/aliment_par_type.fxml"));

        modelListOfFood.setType(type);
        controller.init(modelListOfFood,view,stage,this,type);
        view.init(modelListOfFood, controller);
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

    public Stage initProfil() throws IOException{
        FXMLLoader loader = new FXMLLoader ();
        Stage stage = new Stage ();
        ControllerProfil controllerProfil = new ControllerProfil ();

        loader.setController (controllerProfil);
        Parent root = loader.load (getClass ().getResourceAsStream ("Resources/profil.fxml"));
        controllerProfil.init (stage, this);
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

    public Stage initInscription(ModelListOfUsers modelListOfUser) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        Stage stage = new Stage();

        ViewInscription viewUser = new ViewInscription();
        ControllerInscription controllerInscription = new ControllerInscription();


        loader.setController(controllerInscription);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/inscription.fxml"));

        controllerInscription.init(modelListOfUser, stage,this);
        viewUser.init(modelListOfUser, controllerInscription);
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

    public Stage initAuthentification(ModelListOfUsers modelListOfUser) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        Stage stage = new Stage();

        ViewAuthentification viewUser = new ViewAuthentification();
        ControllerAuthentification controllerAuthentification = new ControllerAuthentification();
        //ControllerAuthentification controllerInscription = new ControllerAuthentification();
        //loader.setController(controllerAuthentification);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/profil.fxml"));
        // controllerAuthentification.init(modelListOfUser, stage,this);
        // viewUser.init(modelListOfUser, controllerAuthentification);
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
    public Stage initInscriptionError( ) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        Stage stage = new Stage();

        Parent root = loader.load(getClass().getResourceAsStream("Resources/inscription_error.fxml"));
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

    public ModelListOfFood getModelListOfFood(){
        return modelListOfFood;
    }

}
