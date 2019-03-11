package Program.Controller;

import Program.Model.ModelListOfTags;
import Program.Model.ModelTag;
import Program.StageFactory;
import Program.View.ViewType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerType extends Controller{

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
    private HBox hboxa;

    public HBox getHboxa(){return hboxa;}


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
                setLink_accueil(factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        btn_open.setOnAction(event -> {
            try {
                setBtn_open(factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        btn_ajoute.setOnAction(event -> {
            setBtn_ajoute();
            factory.setModelListOfTags(modelListOfTags);
        });


        link_aide.setOnAction(event -> {
            try {
                setLink_aide(factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        btn_close.setOnAction(event -> {
            setBtn_close(stage);
        });
        link_deco.setOnAction (event -> {
            setLink_deco(factory);
        });
    }

    @FXML
    private void setBtn_ajoute() {
        modelListOfTags.add(new ModelTag(txt_tag.getText()));

    }

    @FXML
    private void setLink_aide(StageFactory factory)throws IOException {
        factory.initAide ();
    }

    @FXML
    private void setLink_accueil(StageFactory factory)throws IOException{
            factory.initAccueil();
    }

    @FXML
    private void setBtn_open(StageFactory factory)throws IOException{
        factory.initFoodByType(type);
    }

    private void setBtn_close(Stage stage){
        stage.close ();
    }

    private void setLink_deco(StageFactory factory) {
        try{
            factory.initAuthentification1();
        }
        catch (Exception e ){
            e.getStackTrace();
        }
    }

    public void setType(String type){
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
