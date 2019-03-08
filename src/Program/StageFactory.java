package Program;

import Program.Controller.ControllerAccueil;
import Program.Controller.ControllerEnregistrer;
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
    static int width=600;
    static int height=475;

    public Stage initAccueil(ModelListOfFood modelListOfFood) throws IOException {
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
                //�˴���stage�ر�ʱ��ͬʱ�������򣬱���stage�رպ󣬳������ر��ˣ�����̨�߳�ȴ��Ȼ���е�����
                System.exit(0);
            }
        });
        return stage;
    }
    public Stage initEnregistrer(ModelListOfFood modelListOfFood) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Stage stage = new Stage();
        ModelListOfTags modelListOfTags = new ModelListOfTags();
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
}
