package Program.Controller;

import Program.Model.ModelListOfUsers;
import Program.Controller.ControllerProfil;
import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
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

    @FXML
    private Hyperlink link_accueil;

//    ControllerInscription controller;

    @Override
    public void init(Stage stage, StageFactory factory) {

        btn_sub.setOnAction(event -> {
            try {
                setBtn_sub(factory);
            } catch (IOException e) {
                e.getStackTrace();
            }
        });

        btn_close.setOnAction (event -> {
            closeButtonAction (stage);
        });
    }

    //
    void setBtn_sub( StageFactory factory) throws IOException {
        if(txt_frame1.getText() == null){
            factory.user.setLastName (" ");
        }else {
            factory.user.setLastName(txt_frame1.getText());
        }
        if(txt_frame2.getText() == null){
            factory.user.setFirstName (" ");
        }else {
            factory.user.setFirstName (txt_frame2.getText ());
        }
        if(txt_frame3.getText () == null){
            factory.user.setSmallDescription (" ");
        }else {
            factory.user.setSmallDescription (txt_frame3.getText ());
        }
        if(txt_description.getText () == null){
            factory.user.setLongDescription (" ");
        }else {
            factory.user.setLongDescription (txt_description.getText ());
        }
        factory.initProfil();
    }

    private void closeButtonAction(Stage stage) {
        stage.close ();
    }

}