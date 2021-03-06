package Program.Controller;

import Program.StageFactory;
import Program.View.ViewAccueil;
import Program.View.ViewProfilIns;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerProfil extends Controller {
    @FXML
    private Button btn_close;

    @FXML
    private Hyperlink link_accueil;

    @FXML
    private Label lbl_nom;

    @FXML
    private Label lbl_prenom;

    @FXML
    private Label lbl_mot;

    @FXML
    private Label lbl_profil;

    @FXML
    private Button btn_changer;

    private void closeButtonAction(Stage stage) {
        stage.close ();
    }

    private void setLink_accueil(StageFactory factory) throws IOException{
        factory.initAll(ViewAccueil.PATH,factory.getControllerAccueil(),factory.getViewAccueil());
    }

    private Label getLbl_nom(){
        return lbl_nom;
    }

    private Label getLbl_prenom(){
        return lbl_prenom;
    }

    private Label getLbl_mot(){
        return lbl_mot;
    }

    private Label getLbl_profil(){
        return lbl_profil;
    }

    @Override
    public void init(Stage stage, StageFactory factory){
        btn_close.setOnAction (event -> {
            closeButtonAction (stage);
        });

        link_accueil.setOnAction (event -> {
            try {
                setLink_accueil (factory);
            } catch (IOException e){
                e.printStackTrace ();
            }
        });
        btn_changer.setOnAction(event -> {
            try {
                factory.initAll(ViewProfilIns.PATH,factory.getControllerProfilIns(),factory.getViewProfilIns());
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        this.getLbl_nom().setText (factory.getUser().getLastName ());

        this.getLbl_prenom ().setText (factory.getUser().getFirstName ());

        this.getLbl_mot ().setText (factory.getUser().getSmallDescription ());

        this.getLbl_profil ().setText (factory.getUser().getLongDescription ());

    }

}

