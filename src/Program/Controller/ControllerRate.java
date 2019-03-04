package Program.Controller;

import Program.Model.ModelRate;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerRate {

    @FXML
    private Label rate;

    @FXML
    public void init(ModelRate rate){
        this.rate.setText(rate.getName() + "    " + rate.getRate());
    }
}
