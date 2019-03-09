package Program.Controller;

import Program.Model.ModelListOfUsers;
import Program.Model.ModelUser;
import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerAuthentification {
    @FXML
    private javafx.scene.control.Button btn_authentifier;

    @FXML
    private ModelListOfUsers userInformation;



    public void init(ModelListOfUsers model, Stage stage, StageFactory factory){
        this.userInformation = model;
        btn_authentifier.setOnAction( event -> {
            try{
                setBtn_authentifier(stage,factory);
            }catch(IOException e){
                e.getStackTrace();
            }
        });
    }

    void setBtn_authentifier(Stage stageold,StageFactory factory) throws IOException {
        stageold.close();
        factory.initAuthentification(userInformation);
    }


}
