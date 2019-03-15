package Program;

import Program.Controller.*;
import Program.Model.*;
import Program.View.*;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;


public class StageFactory {
    static int width = 600;
    static int height = 400;
    private String typeOfAffich;
    private ModelUser user;
    private ModelListOfUsers modelListOfUsers = new ModelListOfUsers();
    private ModelListOfTags modelListOfTags = new ModelListOfTags();

    private ModelListOfFood modelListOfFood = new ModelListOfFood();
    private ModelListOfFollow modelListOfFollow = new ModelListOfFollow();
    private String typeOfConsom = "somme";
    private ModelListOfMes modelListOfMes = new ModelListOfMes();
    private ModelUser rece = new ModelUser("U", "HHH");
    private Stage stage;
    private ControllerProfil controllerProfil = new ControllerProfil();
    private ControllerProfilIns controllerProfilIns = new ControllerProfilIns();
    private ControllerAide controllerAide = new ControllerAide();
    private ControllerAccueil controllerAccueil = new ControllerAccueil();
    private ControllerMessages controllerMessages = new ControllerMessages();
    private ControllerConsomationGraph controllerConsomationGraph = new ControllerConsomationGraph();
    private ControllerFollow controllerFollow = new ControllerFollow();
    private ControllerInscription controllerInscription = new ControllerInscription();
    private ControllerType controllerType = new ControllerType();
    private ControllerEnregistrer controllerEnregistrer = new ControllerEnregistrer();
    private ControllerAuthentification controllerAuthentification = new ControllerAuthentification();
    private ViewAuthentification viewAuthentification = new ViewAuthentification();
    private ViewAide viewAide = new ViewAide();
    private ViewType viewType = new ViewType();
    private ViewProfil viewProfil = new ViewProfil();
    private ViewProfilIns viewProfilIns = new ViewProfilIns();
    private ViewFollow viewFollow = new ViewFollow();
    private ViewAccueil viewAccueil = new ViewAccueil();

    public ControllerEnregistrer getControllerEnregistrer() {
        return controllerEnregistrer;
    }

    public void setUser(ModelUser user) {
        this.user = user;
    }
    public ModelListOfTags getModelListOfTags() {
        return modelListOfTags;
    }

    public ModelListOfFollow getModelListOfFollow() {
        return modelListOfFollow;
    }

    public ControllerMessages getControllerMessages() {
        return controllerMessages;
    }

    public ControllerConsomationGraph getControllerConsomationG() {
        return controllerConsomationGraph;
    }

    public ControllerFollow getControllerFollow() {
        return controllerFollow;
    }

    public ControllerInscription getControllerInscription() {
        return controllerInscription;
    }

    public ViewFollow getViewFollow() {
        return viewFollow;
    }

    public ControllerType getControllerType() {
        return controllerType;
    }

    public ViewType getViewType() {
        return viewType;
    }

    public ViewFoodByType getFoodByType() {
        return foodByType;
    }

    public String getTypeOfAffich() {
        return typeOfAffich;
    }


    public ViewEnregistrer getViewEnregistrer() {
        return viewEnregistrer;
    }

    private ViewEnregistrer viewEnregistrer = new ViewEnregistrer();


    public ViewAccueil getViewAccueil() {
        return viewAccueil;
    }

    public ViewInscription getViewInscription() {
        return viewInscription;
    }

    private ViewInscription viewInscription = new ViewInscription();

    public ViewAide getViewAide() {
        return viewAide;
    }

    public ControllerAuthentification getControllerAuthentification() {
        return this.controllerAuthentification;
    }

    public ViewAuthentification getViewAuthentification() {
        return this.viewAuthentification;
    }

    public ControllerAide getControllerAide() {
        return controllerAide;
    }

    public ControllerAccueil getControllerAccueil() {
        return controllerAccueil;
    }

    private ControllerFoodByType controllerFoodByType = new ControllerFoodByType();
    private ViewFoodByType foodByType = new ViewFoodByType();

    public ViewFoodByType getViewFoodByType() {
        return foodByType;
    }

    public ControllerFoodByType getControllerFoodByType() {
        return controllerFoodByType;
    }

    public StageFactory(Stage stage) {
        this.stage = stage;
    }

    public Stage initAide() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        ControllerAide controllerAide = new ControllerAide();
        Stage stage1 = new Stage();

        loader.setController(controllerAide);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/aide.fxml"));
        controllerAide.init(stage1, this);

        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage1.setScene(scene);

        stage1.show();
        stage1.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                System.exit(0);
            }
        });
        return stage1;
    }


    public ControllerProfil getControllerProfil() {
        return controllerProfil;
    }

    public ControllerProfilIns getControllerProfilIns() {
        return controllerProfilIns;
    }

    public ViewProfil getViewProfil() {
        return viewProfil;
    }

    public ViewProfilIns getViewProfilIns() {
        return viewProfilIns;
    }

    public Stage initConsomation() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        ControllerConsomationGraph controllerConsomationGraph = new ControllerConsomationGraph();
        ViewConsomationG viewConsomationG = new ViewConsomationG();

        loader.setController(controllerConsomationGraph);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/consommation_graphique.fxml"));
        ModelListOfSum modelSum = new ModelListOfSum();
        ModelListOfChart modelChart = new ModelListOfChart();
        modelSum.init(modelListOfFood, modelListOfTags);
        modelChart.init(modelSum);
        controllerConsomationGraph.init(stage, this);
        if (typeOfConsom.equals("somme")) {
            controllerConsomationGraph.setSel_cosm_type(typeOfConsom);
        } else {
            controllerConsomationGraph.setSel_cosm_type("par " + typeOfConsom);
        }
        viewConsomationG.init(modelChart, modelSum, modelListOfFood, modelListOfTags, controllerConsomationGraph, typeOfConsom);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);
        stage.show();
        return stage;
    }

    public Stage initCosommationT() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        ViewConsommationTextDate view = new ViewConsommationTextDate();
        ControllerConsommationTextDate controller = new ControllerConsommationTextDate();


        loader.setController(controller);
        Parent root = loader.load(getClass().getResourceAsStream("Resources/consommation_texte.fxml"));

        ModelListOfSum model = new ModelListOfSum();
        controller.init(model, view, stage, this);
        if (typeOfConsom.equals("somme")) {
            controller.setSel_cosm_type(typeOfConsom);
        } else {
            controller.setSel_cosm_type("par " + typeOfConsom);
        }
        view.init(model, modelListOfFood, modelListOfTags, controller, typeOfConsom);
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

    public void initAll(String path, Controller controller, View view) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setController(controller);
        Parent root = loader.load(getClass().getResourceAsStream(path));
        controller.init(stage, this);
        view.init(controller, this);
        Scene scene = new Scene(root, width, height);
        scene.getStylesheets().add(getClass().getResource("Resources/styles/style.css").toString());
        stage.setScene(scene);
        stage.show();
        listenToSize(stage,controller);
    }


    public void setModelListOfFood(ModelListOfFood modelListOfFood) {
        this.modelListOfFood = modelListOfFood;
    }

    public void setModelListOfTags(ModelListOfTags modelListOfTags) {
        this.modelListOfTags = modelListOfTags;
    }

    public ModelListOfFood getModelListOfFood() {
        return modelListOfFood;
    }

    public void setTypeOfConsom(String type) {
        typeOfConsom = type;
    }

    public ModelListOfMes getModelListOfMes() {
        return modelListOfMes;
    }

    public ModelUser getUser() {
        return this.user;
    }

    public ModelListOfUsers getModelListOfUsers() {
        return this.modelListOfUsers;
    }

    public void setModelListOfUsers(ModelListOfUsers user) {
        this.modelListOfUsers = user;
    }

    public void setRece(ModelUser u) {
        this.rece = u;
    }

    public ModelUser getRece() {
        return this.rece;
    }

    void listenToSize(Stage stage, Controller controller) {
        stage.widthProperty().addListener((ObservableValue<? extends Number> ov,
                                           Number old_val, Number new_val) -> {
            controller.getHboxa().setPrefWidth(new_val.doubleValue());

        });
        stage.heightProperty().addListener((ObservableValue<? extends Number> ov,
                                            Number old_val, Number new_val) -> {
            controller.getHboxa().setPrefHeight(new_val.doubleValue());

        });

    }


    public void setType(String type) {
        this.typeOfAffich = type;
    }

    public String getType() {
        return this.typeOfAffich;
    }
}