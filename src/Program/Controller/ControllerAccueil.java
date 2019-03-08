package Program.Controller;

import Program.Model.ModelListOfFood;
import Program.Model.ModelListOfTags;
import Program.StageFactory;
import Program.ViewAccueil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerAccueil {
    private ModelListOfFood modelListfood = null;
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
    private void setLink_aide(StageFactory stageFactory) throws IOException{
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/aide.fxml"));
//            Parent root = (Parent) fxmlLoader.load ();
//            Stage stage = new Stage ();
//            stage.initModality (Modality.APPLICATION_MODAL);
//            stage.initStyle (StageStyle.UNDECORATED);
//            stage.setTitle ("Aide");
//            stage.setScene (new Scene (root));
//            stage.show ();
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }
        stageFactory.initAide ();

    }

    @FXML
    private void setBtn_pro(){
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/profil.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) btn_pro.getScene ().getWindow ();
            stage.setTitle ("Mon profil");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void setBtn_mes(){
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/messages.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) btn_pro.getScene ().getWindow ();
            stage.setTitle ("Messages");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

   @FXML
    private void setLink_deco(){
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/authentification1.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) link_deco.getScene ().getWindow ();
            stage.setTitle ("Gaspillage");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void setBtn_follow(){
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/follower.fxml"));
        try {
            Parent root = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) btn_follow.getScene ().getWindow ();
            stage.setTitle ("Follower/Followings");
            stage.setScene (new Scene (root));
            stage.show ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }

     void setBtn_ajouter(Stage stageold,StageFactory factory) throws IOException {

            stageold.close();
            factory.setModelListOfFood(modelListfood);
            factory.initEnregistrer();

    }

    void setBtn_type(Stage stageold,StageFactory factory)throws IOException{
        stageold.close();
        factory.initType();
    }
    void setBtn_conso(Stage stageold,StageFactory factory)throws IOException {
        stageold.close();
        factory.initConsomation();
    }

    public ListView getPerimeFoodListView(){ return list_perimes;}
    public ListView getOkFoodListView(){ return this.list_aliok;}
    public ListView getPPFoodListView(){return  this.list_alipp;}

    void setBtn_close(Stage stage){
        stage.close ();
    }
    public void init(ModelListOfFood food, ViewAccueil view, Stage stage, StageFactory factory) {
        this.modelListfood = food;
        btn_close.setOnAction (event -> {
            setBtn_close (stage);
        });
        link_aide.setOnAction (event -> {
            try{
                setLink_aide (factory);
            }catch (IOException e){
                e.printStackTrace ();
            }
        });
        btn_ajouterali.setOnAction( event -> {
            try {
                setBtn_ajouter(stage,factory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        btn_type.setOnAction(event -> {
            try {
                setBtn_type(stage,factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        btn_conso.setOnAction(event -> {
            try {
                setBtn_conso(stage,factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }



}
