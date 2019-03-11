package Program.Controller;

import Program.Model.ModelListOfMes;
import Program.Model.ModelMessage;
import Program.Model.ModelUser;
import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;


public class ControllerSend extends Controller {
    StageFactory factory;
    ModelListOfMes modelListOfMes;
    @FXML
    private Button btn_send;
    @FXML
    private Label lab_rece;
    @FXML
    private TextArea txt_mes;

    public Label getLab_rece() {
        return lab_rece;
    }

    @Override
    public void init(Stage stage, StageFactory factory){
        this.factory = factory;
        modelListOfMes = factory.getModelListOfMes();
        btn_send.setOnAction(event -> {
            modelListOfMes.getListOfMes().add(new ModelMessage(factory.getUser(),findUser(lab_rece.getText()),txt_mes.getText(), LocalDateTime.now()));
            try {
                factory.initAccueil();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

    private ModelUser findUser(String name){
        for(ModelUser user:factory.getModelListOfUsers().getListOfUsers()){
            if (user.getUsername().equals(name)){
                return user;
            }
        }
        return null;

    }
}
