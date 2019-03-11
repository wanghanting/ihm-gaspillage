package Program.Controller;

import Program.Model.ModelListOfFollow;
import Program.Model.ModelUser;
import Program.StageFactory;
import Program.View.ViewFollow;
import Program.View.ViewSend;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFollow extends Controller {

    private ModelListOfFollow modelListOfAmi = null;
    private ModelListOfFollow modelListOfUsers = null;
    private ControllerSend controllerSend=new ControllerSend();
    private ViewSend viewSend = new ViewSend();
    private ModelUser user;

    @FXML
    private Button btn_close;

    @FXML
    private Hyperlink link_aide;

    @FXML
    private Hyperlink link_accueil;

    @FXML
    private Hyperlink link_deco;

    @FXML
    private Label lbl_fans;

    @FXML
    private Label lbl_ami;

    @FXML
    private ListView lst_fans;

    @FXML
    private ListView lst_ami;

    @FXML
    private TextField text_pro;

    @FXML
    private Button btn_msg;
    @FXML
    private HBox hboxa;

    public HBox getHboxa(){return hboxa;}

    public void setBtn_close(Stage stage){
        stage.close();
    }

    public ListView getLst_fans() {
        return lst_fans;
    }

    public ListView getLst_ami() {
        return lst_ami;
    }

    public TextField getText_pro() {
        return text_pro;
    }

    private void setLink_aide(StageFactory stageFactory) throws IOException{
        stageFactory.initAide ();
    }

    private void setLink_accueil( StageFactory factory) throws IOException{
        factory.initAccueil ();
    }

    public void init(ModelListOfFollow listOfAmi, ModelListOfFollow listOfUsers, ViewFollow view, Stage stage, StageFactory factory){
        this.modelListOfAmi = listOfAmi;
        this.modelListOfUsers = listOfUsers;

        btn_close.setOnAction (event -> {
            setBtn_close (stage);
        });

        link_aide.setOnAction (event -> {
            try{
                setLink_aide (factory);
            }catch (IOException e){
                e.printStackTrace ();
            }
        });

        link_accueil.setOnAction (event -> {
            try {
                setLink_accueil (factory);
            } catch (IOException e){
                e.printStackTrace ();
            }
        });

        link_deco.setOnAction (event -> {
            setLink_deco(factory);
        });

        btn_msg.setOnAction(event -> {
            factory.setRece(this.user);
            try {
                factory.initMes("Resources/send.fxml",controllerSend,viewSend);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void setRece(ModelUser user){
        this.user = user;
    }

    private void setLink_deco( StageFactory factory) {
        try{
            factory.initAuthentification1();
        }
        catch (Exception e ){
            e.getStackTrace();
        }
    }
}
