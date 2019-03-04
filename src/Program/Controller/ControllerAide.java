package Program.Controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControllerAide {

    @FXML
    private Button btn_ok;

    void setBtn_ok(Stage stage){
        stage.close();
    }

    public void init(Stage stage){
        btn_ok.setOnAction (event -> {
            setBtn_ok (stage);
        });
    }


}
