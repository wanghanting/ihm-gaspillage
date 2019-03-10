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
import sun.security.smartcardio.SunPCSC;

import javax.imageio.IIOException;
import java.io.IOException;


public class ControllerAuthentification extends Controller {
    @FXML
    private javafx.scene.control.Button btn_authentifier;

    @FXML
    private ModelListOfUsers userInformation = new ModelListOfUsers();

    @FXML
    TextField txt_frame1;

    @FXML
    TextField txt_frame2;

    @FXML
    boolean comfirmedPassword = false;

    @FXML
    boolean isRegistred = false;

    @FXML
    Label authenerr;

    @FXML
    Hyperlink link_inscri;

    @FXML
    private Button btn_close;


    public void init(ModelListOfUsers model, Stage stage, StageFactory factory){
        this.userInformation = model;
        btn_authentifier.setOnAction( event -> {
            if(isRegistred()==false){
                authenerr.setText("You have not registered an account yet"+"\n"+"please register first");
            }else {
                if (comfirmedPassword() == true) {
                    try {
                        setBtn_authentifier(stage, factory);
                    } catch (IOException e) {
                        e.getStackTrace();
                    }
                } else {
                    authenerr.setText("The account name and password you entered do not match"+"\n"+" Please confirm and re-enter");
                }
            }
        });
        link_inscri.setOnAction (event -> {
            stage.close();
            setLink_inscri(stage,factory);
        });

        btn_close.setOnAction (event -> {
            setBtn_close (stage);
        });
    }

    void setBtn_close(Stage stage){
        stage.close ();
    }

    @FXML
    private void setLink_inscri(Stage stageold, StageFactory factory) {
        try{
            stageold.close();
            factory.initInscription(userInformation);}
        catch (Exception e ){
            e.getStackTrace();
        }
    }
    void setBtn_authentifier(Stage stageold,StageFactory factory) throws IOException {
        stageold.close();
        factory.initAccueil();
    }


    public boolean comfirmedPassword(){
        for(int i = 0;i<userInformation.getListOfUsers().size();i++){
            if(txt_frame1.getText().equals(userInformation.getListOfUsers().get(i).getUsername())&&txt_frame2.getText().equals(userInformation.getListOfUsers().get(i).getPassword())){
                System.out.printf("information confrimed!");
                comfirmedPassword = true;
            }
        }
        return comfirmedPassword;
    }

    public boolean isRegistred() {
        for (int i = 0; i < userInformation.getListOfUsers().size(); i++) {
            if (txt_frame1.getText().equals(userInformation.getListOfUsers().get(i).getUsername()) ){
                System.out.printf("you're registred!");
                isRegistred = true;
            }
        }
        return isRegistred;
    }


}
