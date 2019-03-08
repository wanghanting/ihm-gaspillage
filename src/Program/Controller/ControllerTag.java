package Program.Controller;

import Program.Model.ModelTag;
import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerTag {

    @FXML
    private Label tagName;

    @FXML
    public void init(ModelTag tag) {

        tagName.setText(tag.getName());

    }

}
