package Program.Controller;
import Program.Model.ModelFood;
import Program.Model.ModelListOfFood;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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

    void setBtn_ajouter(){
        try {
            modelListFood.addFood( new ModelFood(txt_nom.getText(),sel_type.getTypeSelector(),(int)spi_quan.getValue(),jour_achatj.getValue(),jour_expira.getValue(),(int)spi_jour.getValue(),txt_info.getText()));
        }catch (Exception e){
            System.out.println(e);
        }

        FXMLLoader fxmlLoader = new FXMLLoader (getClass ().getResource ("../Resources/page_d'accueil.fxml"));
        try {
            Parent root = (Parent) fxmlLoader.load ();
            Stage stage = (Stage) btn_ajouter.getScene ().getWindow ();
            stage.setTitle ("Enregistrer");
            stage.setScene (new Scene(root));
            stage.show ();
        }catch (
                IOException e){
            e.printStackTrace ();
        }
        System.out.println(modelListFood.getListOfFood().size());
    }
    public void init(ModelListOfFood foodList) {
        this.modelListFood = foodList;
        //listner on the buttons
        btn_ajouter.setOnAction( event -> {setBtn_ajouter(); });

    }

}
