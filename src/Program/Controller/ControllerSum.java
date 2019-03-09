package Program.Controller;

import Program.Model.ModelSum;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


public class ControllerSum {

    @FXML
    private Label sum;

    @FXML
    public void init(ModelSum sum){
        this.sum.setText(sum.getName() + "       " + sum.getSum());
    }
}
