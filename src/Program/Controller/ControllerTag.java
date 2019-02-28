package Program.Controller;

import Program.Model.ModelTag;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ControllerTag {

    @FXML
    private Label tagName;

    @FXML
    public void init(ModelTag tag) {

        tagName.setText(tag.getName());

    }

}
