package Program.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerAccueil {
    @FXML
    private Button btn_close;

    @FXML
    private Button btn_pro;

    @FXML
    private Hyperlink link_aide;

    @FXML
    private void closeButtonAction() {
        // get a handle to the stage
        Stage stage = (Stage) btn_close.getScene ().getWindow ();
        // do what you have to do
        stage.close ();
    }

    @FXML
    private void setLink_aide() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/aide.fxml"));
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = new Stage ();
//            stage.initModality (Modality.APPLICATION_MODAL);
//            stage.initStyle (StageStyle.UNDECORATED);
            stage.setTitle ("Aide");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void setBtn_pro(){
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/profil.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) btn_pro.getScene ().getWindow ();
//            stage.initModality (Modality.APPLICATION_MODAL);
//            stage.initStyle (StageStyle.UNDECORATED);
            stage.setTitle ("Mon profil");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
