package Program.Controller;

import Program.Model.ModelTag;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ControllerTag {

    @FXML
    private Label tagName;

    @FXML
    public void init(ModelTag tag) {
        try {
            tagName.setText(tag.getName());
        } catch (NullPointerException e) {
            System.out.println("发生异常的是:" + e.getMessage());
        }
    }


}
