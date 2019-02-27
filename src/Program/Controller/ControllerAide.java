package Program.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControllerAide {

    Scene scene;

    @FXML
    private Button btn_ok;

    @FXML
    private void setBtn_ok(){
        // get a handle to the stage
        Stage stage = (Stage)btn_ok.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


}
