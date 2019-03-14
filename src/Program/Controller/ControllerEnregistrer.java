package Program.Controller;
import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import Program.StageFactory;
import Program.View.ViewAccueil;
import Program.View.ViewAuthentification;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class ControllerEnregistrer extends Controller{
    private ModelListOfFood modelListFood;
    @FXML
    private HBox hboxa;
    @FXML
    private TextField txt_nom;
    @FXML
    private Spinner spi_quan;
    @FXML
    private ChoiceBox sel_type;
    @FXML
    private DatePicker jour_achatj;
    @FXML
    private DatePicker jour_expira;
    @FXML
    private Spinner spi_jour;
    @FXML
    private TextArea txt_info;
    @FXML
    private Label lab_noti;
    @FXML
    private Label lab_notifi;
    @FXML
    private Button btn_changerimg;
    @FXML
    private Button btn_ajouter;
    @FXML
    private Hyperlink link_aide;
    @FXML
    private Hyperlink link_accueil;
    @FXML
    private Hyperlink link_deco;
    @FXML
    private Button btn_close;

    public HBox getHboxa(){return  hboxa;}
    public ChoiceBox getSel_type(){ return sel_type; }

    public Spinner getSpi_quan(){return spi_quan;}

    public Spinner getSpi_jour(){return  spi_jour;}

    public Button getBtn_ajouter(){return btn_ajouter;}

    public TextField getTxt_nom(){return txt_nom;}

    public Label getLab_noti(){return lab_noti;}

    public Label getLab_notifi(){return lab_notifi;}


    public void setBtn_close(Stage stage){
        stage.close();
    }

    private void setLink_aide(StageFactory factory) throws IOException{
        factory.initAide();
    }

    private void setLink_accueil( StageFactory factory) throws IOException{
        factory.initAll(ViewAccueil.PATH,factory.getControllerAccueil(),factory.getViewAccueil());
    }

    //public Button getBtn_ajouter() {return btn_ajouter;}
    public void init(Stage stage, StageFactory factory) {
        this.modelListFood = factory.getModelListOfFood();
        this.jour_expira.setValue(LocalDate.now());
        //listner on the buttons
        btn_ajouter.setOnAction( event -> {
            try {
                if((txt_nom.getText().equals(""))) {
                    lab_noti.getStyleClass().add("labelred");
                }
                if(sel_type.getValue()==null){
                    this.lab_notifi.getStyleClass().add("labelred");
                }
                if((!txt_nom.getText().equals(""))&&!(sel_type.getValue()==null)){
                    try {
                        modelListFood.addFood( new ModelFood(txt_nom.getText(),(String)sel_type.getValue(),(int)spi_quan.getValue(),jour_achatj.getValue(),jour_expira.getValue(),(int)spi_jour.getValue(),txt_info.getText()));
                    }catch (Exception e){
                        System.out.println(e);
                    }
                    factory.setModelListOfFood(modelListFood);
                    factory.initAll(ViewAccueil.PATH,factory.getControllerAccueil(),factory.getViewAccueil());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

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
