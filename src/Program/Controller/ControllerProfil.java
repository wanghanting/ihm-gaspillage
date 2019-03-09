package Program.Controller;

import Program.StageFactory;
import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;

import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerProfil {
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

    private void closeButtonAction(Stage stage) {
        stage.close ();
    }

    private void setLink_accueil(Stage stageold, StageFactory factory) throws IOException{
        stageold.close ();
        factory.initAccueil ();
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


    public void init(Stage stage, StageFactory factory){
        btn_close.setOnAction (event -> {
            closeButtonAction (stage);
        });

        link_accueil.setOnAction (event -> {
            try {
                setLink_accueil (stage, factory);
            } catch (IOException e){
                e.printStackTrace ();
            }
        });

        this.getLbl_nom().setText (factory.user.getLastName ());

        this.getLbl_prenom ().setText (factory.user.getFirstName ());

        this.getLbl_mot ().setText (factory.user.getSmallDescription ());

        this.getLbl_profil ().setText (factory.user.getLongDescription ());

    }

//    @FXML
//    private void setLink_accueil() {
//        try {
//            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/page_d'accueil.fxml"));
//            Parent root = (Parent) fxmlLoader.load ();
//            Stage stage = (Stage) link_accueil.getScene ().getWindow ();
//            stage.setTitle ("Page d'accueil");
//            stage.setScene (new Scene (root));
//            stage.show ();
//        } catch (IOException e) {
//            e.printStackTrace ();
//        }
//    }
}
