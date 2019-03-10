package Program.Controller;

import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class ControllerAide extends Controller{

    @FXML
    private Button btn_ok;

    void setBtn_ok(Stage stage){
        stage.close();
    }
    @Override
    public void init(Stage stage, StageFactory stages){
        btn_ok.setOnAction (event -> {
            setBtn_ok (stage);
        });
    }


}
