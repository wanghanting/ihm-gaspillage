package Program.Controller;
import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class ControllerEnregistrer {
    @FXML
    private ModelListOfFood modelListFood;
    @FXML
    private TextField txt_nom;
    @FXML
    private Spinner sel_quan;
    @FXML
    private ChoiceBox sel_type;
    @FXML
    private DatePicker jour_achatj;
    @FXML
    private DatePicker jour_expira;
    @FXML
    private Spinner jour_avantexpi;
    @FXML
    private StringProperty txt_info;

    @FXML
    private Button btn_changerimg;
    @FXML
    private Button btn_ajouter;


    public void init(ModelListOfFood foodList) {
        this.modelListFood = foodList;
        //set image icon in the imageView

        //listner on the buttons
        btn_ajouter.setOnAction( event -> {
            modelListFood.addFood( new ModelFood(txt_nom.getText(),sel_type.getTypeSelector(),(int)sel_quan.getValue(),jour_achatj,jour_expira,(int)jour_avantexpi.getValue(),txt_info.toString()));
        });

    }

}
