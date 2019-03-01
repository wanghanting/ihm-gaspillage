package Program.Controller;

import Program.Model.ModelListOfFood;
import Program.Model.ModelListOfTags;
import Program.ViewFood;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
    private Button btn_ajouter;
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
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) btn_close.getScene ().getWindow ();
        // do what you have to do
        stage.close ();
    }

    @FXML
    private void setLink_aide() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/aide.fxml"));
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = new Stage ();
            stage.setTitle ("Aide");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
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

    @FXML
    private void setBtn_type(){
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/types.fxml"));
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
    private void setBtn_ajouter(){
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/enregistrer.fxml"));
        try {
            Parent root = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) btn_follow.getScene ().getWindow ();
            stage.setTitle ("Enregistrer");
            stage.setScene (new Scene (root));
            stage.show ();
        }catch (IOException e){
            e.printStackTrace ();
        }

    }

    public ListView getPerimeFoodListView(){ return list_perimes;}

    public ListView getOkFoodListView(){ return this.list_aliok;}

//    public Button getBtn_close(){return this.btn_close;}

    public void init(ModelListOfFood food, ViewFood view) {
        this.modelListfood = food;
        //list_aliperimes = new ListView();

        btn_ajouter.setOnAction( event -> {
            setBtn_ajouter();
        });

        btn_type.setOnAction (event -> {
            setBtn_type ();
        });
    }



}
