package Program.Controller;

import Program.StageFactory;
import Program.View.ViewAccueil;
import Program.View.ViewAuthentification;
import javafx.fxml.FXML;
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
    public void init(Stage stage, StageFactory factory){
        link_accueil.setOnAction(event ->
        {
            try {
                factory.initAll(ViewAccueil.PATH,factory.getControllerAccueil(),factory.getViewAccueil());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        link_aide.setOnAction(event -> {
            try {
                factory.initAide();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        link_deco.setOnAction (event -> {
            setLink_deco(factory);
        });
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
