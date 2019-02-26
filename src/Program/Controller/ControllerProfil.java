package Program.Controller;

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

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) btn_close.getScene ().getWindow ();
        stage.close ();
    }

    @FXML
    private void setLink_accueil() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/page_d'accueil.fxml"));
            Parent root = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) link_accueil.getScene ().getWindow ();
            stage.setTitle ("Page d'accueil");
            stage.setScene (new Scene (root));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
