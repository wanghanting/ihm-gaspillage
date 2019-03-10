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

        btn_close.setOnAction (event -> {
            setBtn_close (stage);
        });
    }

    void setBtn_close(Stage stage){
        stage.close ();
    }

    void setBtn_suivant(Stage stageold,StageFactory factory) throws IOException {
        if(!text_frame1.getText().isEmpty()&&!text_frame2.getText().isEmpty()) {
            if (comfirmInformation() == true) {
                try {
                    userInformation.addUser(new ModelUser(text_frame1.getText(), text_frame2.getText()));
                } catch (Exception e) {
                    e.getStackTrace();
                }
                stageold.close();
                factory.initAuthentification(userInformation);
            } else {
                text_frame1.setText(" ");
                text_frame2.setText(" ");
                text_frame3.setText(" ");
                inscrierr.setText("The passwords entered twice do not match" + "\n" + "please re-enter.");
            }
        }else{
            inscrierr.setText("Your password and username cannot be empty"+"\n"+"please re-enter.");
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
        if(text_frame2.getText().equals(text_frame3.getText())){
//            inscrierr.setText("Your password and username cannot be empty"+"\n"+"please re-enter.");
            passwordComfirmed = true;
            System.out.printf("ok!");
        }
        else{
            passwordComfirmed = false;

        }
        return passwordComfirmed;
    }



}
