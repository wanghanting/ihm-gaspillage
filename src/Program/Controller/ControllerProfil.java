package Program.Controller;

import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerProfil {
    @FXML
    private Button btn_close;

    @FXML
    private Hyperlink link_accueil;

    private void closeButtonAction(Stage stage) {
        stage.close ();
    }

    private void setLink_accueil(Stage stageold, StageFactory factory) throws IOException{
        stageold.close ();
        factory.initAccueil ();
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
