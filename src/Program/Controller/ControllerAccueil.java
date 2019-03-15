package Program.Controller;

import Program.Model.ModelListOfFood;
import Program.StageFactory;
import Program.View.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerAccueil extends Controller{
    private ModelListOfFood modelListfood = null;
    private ControllerMessages controllerMessages=new ControllerMessages();
    private ViewMessages viewMessages = new ViewMessages();
    private ControllerProfil controllerProfil = new ControllerProfil ();
    private ControllerAide controllerAide = new ControllerAide();
    private View viewp = new View();
    @FXML
    private ListView list_alipp;
    @FXML
    private ListView list_aliok;
    @FXML
    private ListView list_perimes;
    @FXML
    private Button btn_ajouterali;
    @FXML
    private Button btn_close;
    @FXML
    private Button btn_pro;
    @FXML
    private Button btn_mes;
    @FXML
    private Button btn_follow;
    @FXML
    private Button btn_type;
    @FXML
    private Hyperlink link_aide;
    @FXML
    private Hyperlink link_deco;
    @FXML
    private Button btn_conso;
    @FXML
    private Button btn_delete;
    @FXML
    private HBox hboxa;

    public HBox getHboxa(){return hboxa;}

    ControllerInscription controller;

    private void setLink_aide(StageFactory factory)throws IOException {
        factory.initAll(ViewAide.PATH,factory.getControllerAide(),factory.getViewAide());
    }

    @FXML
    private void setBtn_pro(StageFactory factory) throws IOException{
        factory.initAll("Resources/profil.fxml",controllerProfil,viewp);
    }

     void setBtn_ajouter(StageFactory factory) throws IOException {

            factory.setModelListOfFood(modelListfood);
            factory.initAll(ViewEnregistrer.PATH,factory.getControllerEnregistrer(),factory.getViewEnregistrer());

    }

    private void setLink_deco( StageFactory factory) {
        try{
            factory.initAll(ViewAuthentification.PATH,factory.getControllerAuthentification(),factory.getViewAuthentification());

        }
        catch (Exception e ){
            e.getStackTrace();
        }
    }
    void setBtn_type(StageFactory factory)throws IOException{
        factory.initAll(ViewType.PATH,factory.getControllerType(),factory.getViewType());
    }
    void setBtn_conso(StageFactory factory)throws IOException {
        factory.initCosommationT();
    }

    void setBtn_follow( StageFactory factory)throws IOException{
        factory.initAll(ViewFollow.PATH,factory.getControllerFollow(),factory.getViewFollow());
    }

    public ListView getPerimeFoodListView(){ return list_perimes;}
    public ListView getOkFoodListView(){ return this.list_aliok;}
    public ListView getPPFoodListView(){return  this.list_alipp;}

    void setBtn_close(Stage stage){
        stage.close ();
    }

    @Override
    public void init(Stage stage, StageFactory factory) {
        this.modelListfood = factory.getModelListOfFood();
        link_deco.setOnAction (event -> {
            setLink_deco(factory);
        });

        btn_close.setOnAction (event -> {
            setBtn_close (stage);
        });

        btn_pro.setOnAction (event -> {
            try{
                setBtn_pro (factory);
            }catch (IOException e){
                e.printStackTrace ();
            }

        });

        link_aide.setOnAction (event -> {
            try{
                factory.initAll(ViewAide.PATH,factory.getControllerAide(),factory.getViewAide());
            }catch (IOException e){
                e.printStackTrace ();
            }
        });
        btn_ajouterali.setOnAction( event -> {
            try {
                setBtn_ajouter(factory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btn_type.setOnAction(event -> {
            try {
                setBtn_type(factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        btn_conso.setOnAction(event -> {
            try {
                setBtn_conso(factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        btn_follow.setOnAction(event -> {
            try {
                setBtn_follow (factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        btn_delete.setOnAction(event -> {
            this.modelListfood.getListOfFoodCanDelete().remove(factory.getViewAccueil().getRangeSelectedItem());
            factory.setModelListOfFood(this.modelListfood);
            try {
                factory.initAll(ViewAccueil.PATH,factory.getControllerAccueil(),factory.getViewAccueil());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btn_mes.setOnAction(event -> {
            try {
                factory.initAll("Resources/messages.fxml",controllerMessages,viewMessages);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
