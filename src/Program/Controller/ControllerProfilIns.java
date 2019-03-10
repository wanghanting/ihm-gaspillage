package Program.Controller;

import Program.Model.ModelListOfUsers;
import Program.Controller.ControllerProfil;
import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerProfilIns extends Controller{
    @FXML
    private Button btn_close;

    @FXML
    Button btn_sub;

    @FXML
    private Button btn_changeimage;

    @FXML
    public TextField txt_frame1;

    @FXML
    public TextField txt_frame2;

    @FXML
    public TextField txt_frame3;

    @FXML
    public TextArea txt_description;

//    ControllerInscription controller;

    @Override
    public void init(Stage stage, StageFactory factory) {

        btn_sub.setOnAction(event -> {
            try {
                setBtn_sub(stage, factory);
            } catch (IOException e) {
                e.getStackTrace();
            }
        });
    }

    //
    void setBtn_sub(Stage stageold, StageFactory factory) throws IOException {
        factory.user.setLastName (txt_frame1.getText ());
        factory.user.setFirstName (txt_frame2.getText ());
        factory.user.setSmallDescription (txt_frame3.getText ());
        factory.user.setLongDescription (txt_description.getText ());
        stageold.close();
        factory.initProfil();
    }

}