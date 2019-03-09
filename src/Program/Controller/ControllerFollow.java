package Program.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFollow {
    @FXML
    private Button btn_close;

    @FXML
    private Hyperlink link_aide;

    @FXML
    private Hyperlink link_accueil;

    @FXML
    private Hyperlink link_deco;

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) btn_close.getScene ().getWindow ();
        stage.close();
    }

    @FXML
    private void setLink_aide() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/aide.fxml"));
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = new Stage ();
            stage.setTitle ("Aide");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void setLink_accueil(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/page_d'accueil.fxml"));
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) link_accueil.getScene ().getWindow ();
            stage.setTitle ("Page d'accueil");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

    @FXML
    private void setLink_deco(){
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/authentification.fxml"));
        try {
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) link_deco.getScene ().getWindow ();
            stage.setTitle ("Gaspillage");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }
}
