package Program.Controller;

import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import Program.Model.ModelUser;
import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import Program.Model.ModelListOfUsers;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerUser {
    @FXML
    private Label user;

    public void init(ModelUser name) {
        user.setText(name.getUsername());
    }
}
