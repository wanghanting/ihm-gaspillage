package Program.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class ControllerAide {

    Scene scene;

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_ok;

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage)btn_close.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

    @FXML
    private void setBtn_ok(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/page_d'accueil.fxml"));
            Parent root1 = (Parent) fxmlLoader.load ();
            Stage stage = new Stage ();
            stage.initModality (Modality.APPLICATION_MODAL);
            stage.initStyle (StageStyle.UNDECORATED);
            stage.setTitle ("ABC");
            stage.setScene (new Scene (root1));
            stage.show ();
        } catch (IOException e) {
            e.printStackTrace ();
        }
    }


}
