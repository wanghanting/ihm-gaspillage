package Program.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
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
    private Label lbl_1;

    @FXML
    private Label lbl_2;

    @FXML
    private ListView lst_1;

    @FXML
    private ListView lst_2;

    @FXML
    private TextArea text_pro;

    @FXML
    private Button btn_msg;

    public void closeButtonAction(){
        Stage stage = (Stage) btn_close.getScene ().getWindow ();
        stage.close();
    }

    public ListView getLst_1() {
        return lst_1;
    }

    public ListView getLst_2() {
        return lst_2;
    }


    public void setLink_aide() {
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

    public void setLink_accueil(){
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

    public void setLink_deco(){
        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/authentification1.fxml"));
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

    public void initFollow(){
    }
}
