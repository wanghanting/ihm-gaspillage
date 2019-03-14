package Program.Controller;

import Program.Model.ModelListOfUsers;
import Program.Model.ModelUser;
import Program.StageFactory;
import Program.View.ViewAccueil;
import Program.View.ViewInscription;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;


public class ControllerAuthentification extends Controller {
    private ModelUser user;
    private ModelListOfUsers userInformation = new ModelListOfUsers();
    @FXML
    private javafx.scene.control.Button btn_authentifier;



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

    @Override
    public void init(Stage stage, StageFactory factory){
        this.userInformation = factory.getModelListOfUsers();
        btn_authentifier.setOnAction( event -> {
            if(isRegistred()==false){
                authenerr.setText("Vous n'avez pas encore de compte ?"+"\n"+"Veuillez vous inscrire");
            }else {
                if (comfirmedPassword() == true) {
                    try {
                        setBtn_authentifier(factory);
                    } catch (IOException e) {
                        e.getStackTrace();
                    }
                } else {
                    authenerr.setText("Le nom d'utilisateur et le mot de passe ne correspondent pas"+"\n"+"Réessayer");
                }
            }
        });
        link_inscri.setOnAction (event -> {
            setLink_inscri(factory);
        });

        btn_close.setOnAction (event -> {
            setBtn_close (stage);
        });
    }

    void setBtn_close(Stage stage){
        stage.close ();
    }

    private void setLink_inscri(StageFactory factory) {
        try{
            factory.initAll(ViewInscription.PATH,factory.getControllerInscription(),factory.getViewInscription());}
        catch (Exception e ){
            e.getStackTrace();
        }
    }
    void setBtn_authentifier(StageFactory factory) throws IOException {
        factory.initAll(ViewAccueil.PATH,factory.getControllerAccueil(),factory.getViewAccueil());
        factory.setUser(this.user);
    }


    public boolean comfirmedPassword(){
        for(int i = 0;i<userInformation.getListOfUsers().size();i++){
            if(txt_frame1.getText().equals(userInformation.getListOfUsers().get(i).getUsername())&&txt_frame2.getText().equals(userInformation.getListOfUsers().get(i).getPassword())){
                System.out.printf("information confrimed!");
                comfirmedPassword = true;
            }
        }
        this.user=new ModelUser(txt_frame1.getText(),txt_frame2.getText());
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
