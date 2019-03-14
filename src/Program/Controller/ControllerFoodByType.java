
package Program.Controller;

import Program.Model.ModelListOfFood;
import Program.StageFactory;
import Program.View.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFoodByType extends Controller{

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
    public Label getType(){return type;}
    public ListView getPerimeFoodListView(){ return list_perimes;}
    public ListView getOkFoodListView(){ return this.list_aliok;}
    public ListView getPPFoodListView(){return  this.list_alipp;}

    public void init(Stage stage , StageFactory factory){
        back.setOnAction(event -> {
            try {
                setBack(factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        link_aide.setOnAction(event -> {
            try {
                setLink_aide(factory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        link_accueil.setOnAction(event -> {
            try {
                setLink_accueil(factory);
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

    private void setBack(StageFactory factory)throws IOException {
        factory.initAll(ViewType.PATH,factory.getControllerType(),factory.getViewType());
    }

    private void setLink_aide(StageFactory factory)throws IOException {
        factory.initAide();
    }

    private void setLink_accueil(StageFactory factory)throws IOException{
        factory.initAll(ViewAccueil.PATH,factory.getControllerAccueil(),factory.getViewAccueil());
    }

    private void setBtn_close(Stage stage){
        stage.close ();
    }

    private void setLink_deco( StageFactory factory) {
        try{
            factory.initAll(ViewAuthentification.PATH,factory.getControllerAuthentification(),factory.getViewAuthentification());
        }
        catch (Exception e ){
            e.getStackTrace();
        }
    }
}