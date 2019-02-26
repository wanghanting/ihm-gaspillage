package Program.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerBienvenue {
    @FXML
    private Button btn_close1;

    @FXML
    private Button btn_authentifier;


    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) btn_close1.getScene ().getWindow ();
        stage.close();
    }

    @FXML
    private void setBtn_auth() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/aide.fxml"));
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) btn_authentifier.getScene ().getWindow ();
            stage.setTitle ("Aide");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }

}
