package Program.Controller;

import Program.Model.ModelFood;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerFood {
    @FXML
    private Label food;
    public void init(ModelFood mfood) {
        food.setText(mfood.getName()+"  "+mfood.getFoodType()+"  "+mfood.getQuantity());
    }
}
