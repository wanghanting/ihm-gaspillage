package Program.Controller;

import Program.Model.ModelListOfFollow;
import Program.Model.ModelUser;
import Program.StageFactory;
import Program.View.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerFollow extends Controller {

    private ModelListOfFollow modelListOfFollow;
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

    private void setLink_aide(StageFactory factory) throws IOException{
        factory.initAide();
    }

    private void setLink_accueil( StageFactory factory) throws IOException{
        factory.initAll(ViewAccueil.PATH,factory.getControllerAccueil(),factory.getViewAccueil());
    }
    @Override
    public void init(Stage stage, StageFactory factory){
        this.modelListOfFollow =factory.getModelListOfFollow();

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
                factory.initAll("Resources/send.fxml",controllerSend,viewSend);
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
            factory.initAll(ViewAuthentification.PATH,factory.getControllerAuthentification(),factory.getViewAuthentification());
        }
        catch (Exception e ){
            e.getStackTrace();
        }
    }
}
