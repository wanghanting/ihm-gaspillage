package Program.Controller;

import Program.Model.ModelListOfFollow;
import Program.StageFactory;
import Program.ViewFollow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFollow {

    private ModelListOfFollow modelListOfAmi = null;
    private ModelListOfFollow modelListOfUsers = null;
    private String user;

    @FXML
    private Button btn_close;

    @FXML
    private Hyperlink link_aide;

    @FXML
    private Hyperlink link_accueil;

    @FXML
    private Hyperlink link_deco;

    @FXML
    private Label lbl_fans;

    @FXML
    private Label lbl_ami;

    @FXML
    private ListView lst_fans;

    @FXML
    private ListView lst_ami;

    @FXML
    private TextField text_pro;

    @FXML
    private Button btn_msg;

    public void setBtn_close(Stage stage){
        stage.close();
    }

    public ListView getLst_fans() {
        return lst_fans;
    }

    public ListView getLst_ami() {
        return lst_ami;
    }

    public TextField getText_pro() {
        return text_pro;
    }

    public void setLink_aide() {
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

    public void setLink_accueil(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/page_d'accueil.fxml"));
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) link_accueil.getScene ().getWindow ();
            stage.setTitle ("Page d'accueil");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    public void setLink_deco(){
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

    public void init(ModelListOfFollow listOfAmi, ModelListOfFollow listOfUsers, ViewFollow view, Stage stage, StageFactory factory){
        this.modelListOfAmi = listOfAmi;
        this.modelListOfUsers = listOfUsers;

        btn_close.setOnAction (event -> {
            setBtn_close (stage);
        });
    }

    public void setUser(String user){
        this.user = user;
    }
}
