package Program;

import Program.Controller.*;
import Program.Model.*;
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
    public ModelUser user =  new ModelUser("user1","shagua");
    private ModelListOfUsers modelListOfUsers=new ModelListOfUsers();
    private ModelListOfTags modelListOfTags = new ModelListOfTags();
    private ModelListOfFood modelListOfFood = new ModelListOfFood();
    private ModelListOfFollow modelListOfAmi = new ModelListOfFollow ();
    private ModelListOfFollow modelListOfFans = new ModelListOfFollow ();
    private String typeOfConsom = "somme";
    private ModelListOfMes modelListOfMes = new ModelListOfMes();
    private ModelUser rece = new ModelUser("U","HHH");

    public Stage initAccueil() throws IOException {

        FXMLLoader loader= new FXMLLoader();
        Stage stage = new Stage();

        ViewAccueil viewFood = new ViewAccueil();
        ControllerAccueil controllerAccueil = new ControllerAccueil();


        loader.setController(controllerAccueil);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/page_d'accueil.fxml"));

        controllerAccueil.init(modelListOfFood,viewFood,stage,this);
        viewFood.init(modelListOfFood, controllerAccueil);

        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);

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
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);
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

        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);

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

        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);

        stage.show ();
        stage.setOnCloseRequest (new EventHandler<WindowEvent> () {
            @Override
            public void handle(WindowEvent event) {
                System.exit (0);
            }
        });
        return stage;
    }

    public Stage initFollow() throws IOException {
        FXMLLoader loader = new FXMLLoader ();
        Stage stage = new Stage ();
        ViewFollow viewFollow = new ViewFollow ();
        ControllerFollow controller = new ControllerFollow ();

        loader.setController (controller);
        Parent root = loader.load (getClass ().getResourceAsStream ("Resources/follower.fxml"));

        controller.init (modelListOfFans, modelListOfAmi, viewFollow, stage, this);
        viewFollow.init (modelListOfAmi, controller);

        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);

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
        controllerAide.init (stage,this);

        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);

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
        ModelUser user1 = new ModelUser ("hahaha", "asd");
        user1.setFirstName ("Hanting");
        user1.setLastName ("WANG");
        user1.setSmallDescription ("asddd");
        user1.setLongDescription ("dadas");
        user = user1;

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

    public Stage initConsomation() throws IOException {
        FXMLLoader loader = new FXMLLoader ();
        Stage stage = new Stage ();
        ControllerConsomationG controllerConsomationG=new ControllerConsomationG();
        ViewConsomationG viewConsomationG = new ViewConsomationG();

        loader.setController (controllerConsomationG);
        Parent root = loader.load (getClass ().getResourceAsStream ("Resources/consommation_graphique.fxml"));
        ModelListOfSum modelSum = new ModelListOfSum();
        ModelListOfChart modelChart = new ModelListOfChart();
        modelSum.init(modelListOfFood,modelListOfTags);
        modelChart.init(modelSum);
        controllerConsomationG.init(stage,this);
        if(typeOfConsom.equals("somme")){
            controllerConsomationG.setSel_cosm_type(typeOfConsom);
        }else {
            controllerConsomationG.setSel_cosm_type("par " + typeOfConsom);
        }
        viewConsomationG.init(modelChart,modelSum,modelListOfFood,modelListOfTags,controllerConsomationG,typeOfConsom);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);
        stage.show ();
        return stage;
    }

    public Stage initAuthentification(ModelListOfUsers modelListOfUser) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        Stage stage = new Stage();

//        ViewAuthentification viewUser = new ViewAuthentification();
//        ControllerAuthentification controllerAuthentification = new ControllerAuthentification();
//        loader.setController(controllerAuthentification);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/profil_torempli.fxml"));
//         controllerAuthentification.init(modelListOfUser, stage,this);
//         viewUser.init(modelListOfUser, controllerAuthentification);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        return stage;
    }

    public Stage initAuthentification1(ModelListOfUsers modelListOfUser) throws IOException {
        FXMLLoader loader= new FXMLLoader();
        Stage stage = new Stage();

        ViewAuthentification viewUser = new ViewAuthentification();
        ControllerAuthentification controllerAuthentification = new ControllerAuthentification();
        loader.setController(controllerAuthentification);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/authentification.fxml"));
        controllerAuthentification.init(modelListOfUser, stage,this);
        viewUser.init(modelListOfUser, controllerAuthentification);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        return stage;
    }

    public Stage initCosommationT()throws IOException{
        FXMLLoader loader= new FXMLLoader();
        Stage stage = new Stage();

        ViewConsommationTextDate view = new ViewConsommationTextDate();
        ControllerConsommationTextDate controller = new ControllerConsommationTextDate();


        loader.setController(controller);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/consommation_texte.fxml"));

        ModelListOfSum model = new ModelListOfSum();
        controller.init(model,view,stage,this);
        if(typeOfConsom.equals("somme")){
            controller.setSel_cosm_type(typeOfConsom);
        }else {
            controller.setSel_cosm_type("par " + typeOfConsom);
        }
        view.init(model,modelListOfFood,modelListOfTags, controller,typeOfConsom);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        return stage;
    }
    public void initMes(String path, Controller controller, View view) throws IOException {
        FXMLLoader loader = new FXMLLoader ();
        Stage stage = new Stage ();
        loader.setController (controller);
        Parent root = loader.load (getClass ().getResourceAsStream (path));
        controller.init(stage,this);
        view.init(controller,this);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);
        stage.show ();
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
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
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

    public void setTypeOfConsom(String type){
        typeOfConsom = type;
    }

    public ModelListOfMes getModelListOfMes(){
        return modelListOfMes;
    }
    public void setUser(){this.user = new ModelUser("user1","shagua");}
    public ModelUser getUser(){return this.user;}
    public ModelListOfUsers getModelListOfUsers(){return this.modelListOfUsers;}
    public void setRece(ModelUser u){this.rece = u;}
    public ModelUser getRece(){return this.rece;}
}