package Program.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControllerAccueil {
    @FXML
    private Button btn_close;

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage)btn_close.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
}
