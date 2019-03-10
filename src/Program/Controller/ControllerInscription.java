package Program.Controller;

import Program.Model.ModelListOfUsers;
import Program.Model.ModelUser;
import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerInscription {
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





    public void init(ModelListOfUsers model, Stage stage, StageFactory factory){
        this.userInformation = model;

        btn_suivant.setOnAction(event -> {
            try {
                setBtn_suivant(stage, factory);
            } catch (IOException e) {
                e.getStackTrace();
            }
        });

        link_authen.setOnAction (event -> {
            stage.close();
            setLink_authen(stage,factory);
        });
    }

    void setBtn_suivant(Stage stageold,StageFactory factory) throws IOException {
        if(comfirmInformation()== true) {
            try {
                factory.user = new ModelUser (text_frame1.getText(), text_frame2.getText());
                userInformation.addUser(factory.user);
                factory.setModelListOfUsers(userInformation);
            } catch (Exception e) {
                e.getStackTrace();
            }
            stageold.close();
            factory.initProfilIns ();
        }else{
            text_frame1.setText(" ");
            text_frame2.setText(" ");
            text_frame3.setText(" ");
            inscrierr.setText("The passwords entered twice do not match"+"\n"+"please re-enter.");
        }

    }

    @FXML
    private void setLink_authen(Stage stageold, StageFactory factory) {
        try{
            stageold.close();
            factory.initAuthentification1(userInformation);}
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
