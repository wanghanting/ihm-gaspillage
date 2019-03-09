package Program.Controller;

import Program.Model.ModelListOfUsers;
import Program.Model.ModelUser;
import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerAuthentification {
    @FXML
    private javafx.scene.control.Button btn_authentifier;

    @FXML
    private ModelListOfUsers userInformation;

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


    public void init(ModelListOfUsers model, Stage stage, StageFactory factory){
        this.userInformation = model;
        btn_authentifier.setOnAction( event -> {
            if(isRegistred()==false){
                authenerr.setText("You have not registered an account yet, please register first");
            }else {
                if (comfirmedPassword() == true) {

                    try {
                        setBtn_authentifier(stage, factory);
                    } catch (IOException e) {
                        e.getStackTrace();
                    }
                } else {
                    authenerr.setText("The account name and password you entered do not match. Please confirm and re-enter");
                }
            }
        });
    }

    void setBtn_authentifier(Stage stageold,StageFactory factory) throws IOException {
        stageold.close();
        factory.initAuthentification(userInformation);
    }

    public boolean comfirmedPassword(){
        for(int i = 0;i<userInformation.ListOfUsers.size();i++){
            if(txt_frame1.getText()==userInformation.ListOfUsers.get(i).getUsername()&&txt_frame2.getText()==userInformation.ListOfUsers.get(i).getPassword()){
                System.out.printf("information confrimed!");
                comfirmedPassword = true;
            }
        }
        return comfirmedPassword;
    }

    public boolean isRegistred() {
        for (int i = 0; i < userInformation.ListOfUsers.size(); i++) {
            if (txt_frame1.getText() == userInformation.ListOfUsers.get(i).getUsername()) {
                System.out.printf("you're registred!");
                isRegistred = true;
            }
        }
        return isRegistred;
    }


}
