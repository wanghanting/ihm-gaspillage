package Program.Controller;

import Program.Model.ModelMessage;
import javafx.fxml.FXML;

import javafx.scene.control.Label;

public class ControllerMessage extends Controller{
    @FXML
    private Label lab_mes;

    public void init(ModelMessage modelMessage){
        lab_mes.setText(modelMessage.getMessage()+"  sender:"+modelMessage.getSender().getUsername()+" "+modelMessage.getDate());
        lab_mes.setWrapText(true);
    }
}
