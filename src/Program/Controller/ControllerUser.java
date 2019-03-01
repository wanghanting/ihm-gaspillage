package Program.Controller;



import Program.Model.ModelFood;
import Program.Model.ModelUser;
import javafx.fxml.FXML;
import javafx.scene.control.Hyperlink;
import Program.Model.ModelListOfUsers;
import Program.Model.ModelUser;
import Program.Controller.ControllerInscription;

import java.awt.*;

public class ControllerUser {
    @FXML
    private TextField text_frame1;
    @FXML
    private TextField text_frame2;
    @FXML
    private TextField text_frame3;
    @FXML
    private javafx.scene.control.Button btn_suivant;
    @FXML
    private javafx.scene.control.Button btn_authentifier;
    @FXML
    boolean passwordComfirmed;
    @FXML
    boolean usernamePasswordUniforme;

ModelListOfUsers userInformation = new ModelListOfUsers();
//    private Button btn_close;
//    private Button btn_suivant;
//    private Hyperlink link_auth;

    //constructor
    public ControllerUser(){

    }
////initialiser les textArea a vide;
//    public void initialize(){
//        text_frame1.setText("");
//        text_frame2.setText("");
//        text_frame3.setText("");
//    }


    public TextField getText_frame1() {
        return text_frame1;
    }
    public TextField getText_frame2() {
        return text_frame2;
    }
    public TextField getText_frame3() {
        return text_frame3;
    }

    public boolean comfirmInformation(){
        if(getText_frame1()!=null&&getText_frame2()!=null && getText_frame2()== getText_frame3()){
            passwordComfirmed = true;
        }
        else{
            passwordComfirmed = false;
        }
        return passwordComfirmed;
    }

    public void storeUserInformation(){
        if(comfirmInformation()){
            btn_suivant.setOnAction( event -> {
                userInformation.ListOfUsers.add(new ModelUser(text_frame1.getText(),text_frame2.getText()));
            });
        }
    }
//athentification
    public boolean authendification(ModelUser usertest){
        for(int i=0;i<userInformation.ListOfUsers.size();i++){
            if(usertest.getUsername() == userInformation.ListOfUsers.get(i).getUsername()&& usertest.getPassword()==userInformation.ListOfUsers.get(i).getPassword()){
                usernamePasswordUniforme = true;
                btn_authentifier.setOnAction(event -> {

                });
            }else{
                usernamePasswordUniforme = false;
            }
        }
        return usernamePasswordUniforme;
    }


}
