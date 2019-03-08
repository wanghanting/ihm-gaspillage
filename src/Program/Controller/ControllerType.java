package Program.Controller;

import Program.Model.ModelListOfTags;
import Program.Model.ModelTag;
import Program.StageFactory;
import Program.ViewType;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerType {

    private ModelListOfTags modelListOfTags = null;
    private String type;

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
    private Button btn_open;

    @FXML
    public ListView getListView() {
        return choosenTag;
    }

    @FXML
    public TextField getTxt_tag() {
        return txt_tag;
    }

    @FXML
    public void init(ModelListOfTags tagList, ViewType view, Stage stage, StageFactory factory) {
        this.modelListOfTags = tagList;
        link_accueil.setOnAction(event -> {
            try {
                setLink_accueil(stage,factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        btn_open.setOnAction(event -> {
            try {
                setBtn_open(stage,factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        btn_ajoute.setOnAction(event -> {
            setBtn_ajoute();
            factory.setModelListOfTags(modelListOfTags);
        });

//        setLink_deco ();
//        closeButtonAction ();
        setLink_aide ();
    }

    @FXML
    private void setBtn_ajoute() {
        modelListOfTags.add(new ModelTag(txt_tag.getText()));

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
    private void setLink_accueil(Stage stageold,StageFactory factory)throws IOException{
            stageold.close();
            factory.initAccueil();
    }

    @FXML
    private void setBtn_open(Stage stageold,StageFactory factory)throws IOException{
        stageold.close();
        factory.initFoodByType(type);
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

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
