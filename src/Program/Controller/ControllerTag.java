package Program.Controller;

import Program.Model.ModelTag;
import javafx.fxml.FXML;

import java.awt.*;

public class ControllerTag {

    @FXML
    private Label tagName;

    public void init(ModelTag tag){ tagName.setText(tag.getName());}
}
