
package Program.Controller;

import Program.Model.ModelListOfFood;
import Program.StageFactory;
import Program.View.ViewFoodByType;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFoodByType {
    private ModelListOfFood modelListOfFood = null;

    @FXML
    private ListView list_alipp;
    @FXML
    private ListView list_aliok;
    @FXML
    private ListView list_perimes;
    @FXML
    private Label type;
    @FXML
    private Button back;
    @FXML
    private Hyperlink link_aide;
    @FXML
    private Hyperlink link_accueil;
    @FXML
    private Hyperlink link_deco;
    @FXML
    private Button btn_close;

    public ListView getPerimeFoodListView(){ return list_perimes;}
    public ListView getOkFoodListView(){ return this.list_aliok;}
    public ListView getPPFoodListView(){return  this.list_alipp;}

    public void init(ModelListOfFood food, ViewFoodByType view, Stage stage , StageFactory stageFactory,String type){
        this.modelListOfFood = food;
        this.type.setText(type);
        back.setOnAction(event -> {
            try {
                setBack(stage,stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        link_aide.setOnAction(event -> {
            try {
                setLink_aide(stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        link_accueil.setOnAction(event -> {
            try {
                setLink_accueil(stage,stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        btn_close.setOnAction(event -> {
            setBtn_close(stage);
        });
        link_deco.setOnAction (event -> {
            setLink_deco(stage,stageFactory);
        });
    }

    private void setBack(Stage stageOld,StageFactory stageFactory)throws IOException {
        stageOld.close();
        stageFactory.initType();
    }

    private void setLink_aide(StageFactory factory)throws IOException {
        factory.initAide ();
    }

    private void setLink_accueil(Stage stageOld,StageFactory factory)throws IOException{
        stageOld.close();
        factory.initAccueil();
    }

    private void setBtn_close(Stage stage){
        stage.close ();
    }

    private void setLink_deco(Stage stageold, StageFactory factory) {
        try{
            stageold.close();
            factory.initAuthentification1();
        }
        catch (Exception e ){
            e.getStackTrace();
        }
    }
}