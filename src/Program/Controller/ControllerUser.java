package Program.Controller;



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
    private Button btn_suivant;
    @FXML
    boolean passwordComfirmed;


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

        }
    }


}
