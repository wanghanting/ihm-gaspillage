package Program.Controller;

import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerMessages extends Controller {
    @FXML
    private Button btn_close;

    @FXML
    private Hyperlink link_aide;

    @FXML
    private Hyperlink link_accueil;

    @FXML
    private Hyperlink link_deco;

    @FXML
    private ListView list_newm;

    @FXML
    private ListView list_oldm;

    @FXML
    private void setBtn_close(){
        Stage stage = (Stage) btn_close.getScene ().getWindow ();
        stage.close ();
    }

    public ListView getList_newm(){return list_newm;}
    public ListView getList_oldm(){return list_oldm;}
    public void init(Stage stage, StageFactory stageFactory){
        link_accueil.setOnAction(event ->
        {
            try {
                stageFactory.initAccueil();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        link_aide.setOnAction(event -> {
            try {
                stageFactory.initAide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        link_deco.setOnAction (event -> {
            setLink_deco(stageFactory);
        });
    }

    private void setLink_deco( StageFactory factory) {
        try{
            factory.initAuthentification1();
        }
        catch (Exception e ){
            e.getStackTrace();
        }
    }
}
