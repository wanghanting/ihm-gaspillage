package Program.Controller;

import Program.Model.ModelListOfFollow;
import Program.StageFactory;
import Program.ViewFollow;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFollow {

    private ModelListOfFollow modelListOfAmi = null;
    private ModelListOfFollow modelListOfUsers = null;
    private String user;

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

    private void setLink_accueil(Stage stageold, StageFactory factory) throws IOException{
        stageold.close ();
        factory.initAccueil ();
    }

    private void setLink_deco(Stage stageold, StageFactory factory) throws IOException{
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
                setLink_accueil (stage, factory);
            } catch (IOException e){
                e.printStackTrace ();
            }
        });

        link_deco.setOnAction (event -> {
            try{
                setLink_deco (stage, factory);
            }catch (IOException e){
                e.printStackTrace ();
            }
        });
    }

    public void setUser(String user){
        this.user = user;
    }
}
