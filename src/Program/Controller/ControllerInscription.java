package Program.Controller;

import Program.Model.ModelListOfUsers;
import Program.Model.ModelUser;
import Program.StageFactory;
import Program.View.ViewAuthentification;
import Program.View.ViewProfilIns;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerInscription extends Controller{
    @FXML
    ModelListOfUsers userInformation = new ModelListOfUsers();

    @FXML
    private Button btn_close;

    @FXML
    private Button btn_suivant;


    @FXML
    private TextField text_frame1;
    @FXML
    private TextField text_frame2;
    @FXML
    private TextField text_frame3;

    @FXML
    boolean passwordComfirmed;

    @FXML
    ModelListOfUsers model;

    @FXML
    private Label inscrierr;

    @FXML
    Hyperlink link_authen;


    @FXML
    private void setBtn_close(){
        Stage stage = (Stage) btn_close.getScene ().getWindow ();
        stage.close();
    }


    public TextField getText_frame1() {
        return text_frame1;
    }
    public TextField getText_frame2() {
        return text_frame2;
    }
    public TextField getText_frame3() {
        return text_frame3;
    }





    public void init(Stage stage, StageFactory factory){
        this.userInformation = factory.getModelListOfUsers();

        btn_suivant.setOnAction(event -> {
            try {
                setBtn_suivant(factory);
            } catch (IOException e) {
                e.getStackTrace();
            }
        });

        link_authen.setOnAction (event -> {
            setLink_authen(factory);
        });
        btn_close.setOnAction(event -> {
            stage.close();
        });
    }

    void setBtn_suivant(StageFactory factory) throws IOException {
        if(comfirmInformation()== true) {
            try {
                factory.setUser( new ModelUser (text_frame1.getText(), text_frame2.getText()));
                userInformation.addUser(factory.getUser());
                factory.setModelListOfUsers(userInformation);
            } catch (Exception e) {
                e.getStackTrace();
            }
            factory.initAll(ViewProfilIns.PATH,factory.getControllerProfilIns(),factory.getViewProfilIns());
        }else{
            text_frame1.setText(" ");
            text_frame2.setText(" ");
            text_frame3.setText(" ");
            inscrierr.setText("The passwords entered twice do not match"+"\n"+"please re-enter.");
        }

    }

    @FXML
    private void setLink_authen( StageFactory factory) {
        try {
            factory.initAll(ViewAuthentification.PATH, factory.getControllerAuthentification(), factory.getViewAuthentification());
        }
        catch (Exception e ){
            e.getStackTrace();
        }
    }



    public boolean comfirmInformation(){
        if(text_frame1.getText()!= null && text_frame1.getText()!=null && text_frame2.getText().equals(text_frame3.getText())){
            passwordComfirmed = true;
            System.out.printf("ok!");
        }
        else{
            passwordComfirmed = false;

        }
        return passwordComfirmed;
    }



}
