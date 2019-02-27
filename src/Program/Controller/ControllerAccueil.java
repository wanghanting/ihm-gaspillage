package Program.Controller;

import Program.Model.ModelListOfFood;
import Program.View.ViewFood;
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
    private Button btn_close;
    @FXML
    private Button btn_pro;
    @FXML
    private Button btn_mes;
    @FXML
    private Button btn_follow;
    @FXML
    private Hyperlink link_aide;
    @FXML
    private Hyperlink link_deco;
    @FXML
    private ListView list_aliperimes;
    @FXML
    private ListView list_alipp;
    @FXML
    private ListView list_aliok;
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
//            stage.initModality (Modality.APPLICATION_MODAL);
//            stage.initStyle (StageStyle.UNDECORATED);
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
    public void init(ModelListOfFood foodList, ViewFood view) {
        this.modelListfood = foodList;
    }

    public ListView getPerimeFoodListView(){ return list_aliperimes;}


}
