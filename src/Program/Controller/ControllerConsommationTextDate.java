package Program.Controller;

import Program.Model.ModelListOfFood;
import Program.Model.ModelListOfSum;
import Program.StageFactory;
import Program.ViewConsommationTextDate;
import Program.ViewFoodByType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerConsommationTextDate {

    @FXML
    private Button btn_close;
    @FXML
    private Hyperlink link_accueil;
    @FXML
    private Hyperlink link_aide;
    @FXML
    private Hyperlink link_deco;
    @FXML
    private ListView list_cons;
    @FXML
    private ListView list_gas;
    @FXML
    private ListView list_taux;
    @FXML
    private DatePicker date_from;
    @FXML
    private DatePicker date_to;
    @FXML
    private Label lab_from;
    @FXML
    private Label lab_to;

    public ListView getList_cons(){return list_cons;}
    public ListView getList_gas(){return list_gas;}
    public ListView getList_taux(){return list_taux;}
    public DatePicker getDate_from(){return date_from;}
    public DatePicker getDate_to(){return date_to;}


    @FXML
    public void init(ModelListOfSum sum, ViewConsommationTextDate view, Stage stage , StageFactory stageFactory){
        if(stageFactory.getModelListOfFood().getDateFrom() == null ){
            lab_from.setText("Pas choisir");
        }else {
            lab_from.setText(stageFactory.getModelListOfFood().getDateFrom().toString());
        }
        if(stageFactory.getModelListOfFood().getDateTo() == null){
            lab_to.setText("Pas choisir");
        }else {
            lab_to.setText(stageFactory.getModelListOfFood().getDateTo().toString());
        }
        date_from.setOnAction(event -> {
            try {
                stageFactory.getModelListOfFood().setDateFrom(date_from.getValue());
                setDate(stage,stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
        date_to.setOnAction(event -> {
            try {
                stageFactory.getModelListOfFood().setDateTo(date_to.getValue());
                setDate(stage,stageFactory);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

    @FXML
    private void setDate(Stage stage,StageFactory factory)throws IOException{
        stage.close();
        factory.initCosommationT();
    }
}
