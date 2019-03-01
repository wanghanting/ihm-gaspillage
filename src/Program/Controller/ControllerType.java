package Program.Controller;

import Program.Model.ModelListOfTags;
import Program.Model.ModelTag;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerType {

    private ModelListOfTags modelListOfTags = null;

    @FXML
    private Hyperlink link_accueil;
    @FXML
    private Hyperlink link_aide;
    @FXML
    private Hyperlink link_deco;
    @FXML
    private Button btn_close;
    @FXML
    private Button btn_ajoute;
    @FXML
    private ListView choosenTag;
    @FXML
    private TextField txt_tag;

    @FXML
    public ListView getListView() {
        return choosenTag;
    }

    @FXML
    public TextField getTxt_tag() {
        return txt_tag;
    }

    @FXML
    public void init(ModelListOfTags tagList) {
        this.modelListOfTags = tagList;
        setBtn_ajoute();
        setLink_accueil ();
//        setLink_deco ();
//        closeButtonAction ();
        setLink_aide ();
    }

    @FXML
    private void setBtn_ajoute() {

        btn_ajoute.setOnAction(event -> {
            modelListOfTags.add(new ModelTag(txt_tag.getText()));
        });

    }

    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) btn_close.getScene ().getWindow ();
        // do what you have to do
        btn_close.setOnAction (event -> {
            stage.close ();
        });
    }

    @FXML
    private void setLink_aide() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/aide.fxml"));
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = new Stage ();
            stage.setTitle ("Aide");
            stage.setScene (new Scene (root1));
//            stage.show ();
            link_aide.setOnAction (event -> {
                stage.showAndWait ();
            });
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void setLink_accueil(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/page_d'accueil.fxml"));
            Parent root1 = (Parent) fxmlLoader.load ();
//            Stage stage = (Stage) link_accueil.getScene ().getWindow ();
            Stage stage = new Stage ();
            stage.setTitle ("Page d'accueil");
            stage.setScene (new Scene (root1));
            link_accueil.setOnAction (event ->{
                stage.show ();
            });
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
}
