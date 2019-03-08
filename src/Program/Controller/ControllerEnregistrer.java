package Program.Controller;
import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import Program.StageFactory;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerEnregistrer {
    @FXML
    private ModelListOfFood modelListFood;
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
    private Button btn_changerimg;
    @FXML
    private Button btn_ajouter;


    public ChoiceBox getSel_type(){ return sel_type; }

    public Spinner getSpi_quan(){return spi_quan;}

    public Spinner getSpi_jour(){return  spi_jour;}

    void setBtn_ajouter(Stage stageold,StageFactory factory) throws IOException {
        try {
            modelListFood.addFood( new ModelFood(txt_nom.getText(),(String)sel_type.getValue(),(int)spi_quan.getValue(),jour_achatj.getValue(),jour_expira.getValue(),(int)spi_jour.getValue(),txt_info.getText()));
        }catch (Exception e){
            System.out.println(e);
        }
        stageold.close();
        factory.setModelListOfFood(modelListFood);
        factory.initAccueil();

    }
    //public Button getBtn_ajouter() {return btn_ajouter;}
    public void init(ModelListOfFood foodList, Stage stage, StageFactory factory) {
        this.btn_ajouter.getStyleClass().add("buttonFred");
        this.modelListFood = foodList;
        //listner on the buttons
        btn_ajouter.setOnAction( event -> {
            try {
                setBtn_ajouter(stage,factory);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }

}
